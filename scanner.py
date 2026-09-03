import cv2
import json
import os
import sys
import time
from datetime import datetime
import pandas as pd
import numpy as np

# Audio Alert Setup (Native Windows Sound Support)
try:
    import winsound
    def play_sound(sound_type="success"):
        if sound_type == "success":
            winsound.Beep(1000, 200)  # High pitch beep for success
        elif sound_type == "warning":
            winsound.Beep(400, 150)   # Low pitch beep for duplicate/error
            winsound.Beep(400, 150)
except ImportError:
    # Cross-platform fallback using system terminal bell
    def play_sound(sound_type="success"):
        print('\a', end='', flush=True)

# In-Memory Storage (Bina Database Ke Data Store Karne Ke Liye)
attendance_records = []
scanned_rolls = set()

# 1. Mark Attendance Entry (In-Memory Logic)
def mark_attendance(student_data):
    roll = student_data.get("roll")
    name = student_data.get("name")
    branch = student_data.get("branch", "N/A")
    
    current_date = datetime.now().strftime("%Y-%m-%d")
    current_time = datetime.now().strftime("%H:%M:%S")

    # Duplicate Scan Verification
    if roll in scanned_rolls:
        print(f"[WARNING] Duplicate Entry: {roll} already marked today!")
        play_sound("warning")
        return f"ALREADY MARKED TODAY: {roll}", (0, 0, 255)

    # Save Record to RAM
    scanned_rolls.add(roll)
    record = {
        "roll_number": roll,
        "name": name,
        "branch": branch,
        "date": current_date,
        "time": current_time
    }
    attendance_records.append(record)
    
    print(f"[SUCCESS] Attendance Marked: {name} ({roll}) at {current_time}")
    play_sound("success")
    return f"SUCCESS: {name}", (0, 255, 0)

# 2. Export to CSV Report on Program Close
def export_to_csv():
    try:
        if attendance_records:
            df = pd.DataFrame(attendance_records)
            df.to_csv("attendance_report.csv", index=False)
            print("\n[INFO] Attendance report exported successfully to 'attendance_report.csv'")
        else:
            print("\n[INFO] No records scanned in this session.")
    except Exception as e:
        print(f"\n[ERROR] CSV Export Failed: {e}")

# 3. Main Webcam Scanner Engine
def run_scanner():
    cap = cv2.VideoCapture(0, cv2.CAP_DSHOW)
    if not cap.isOpened():
        print("[INFO] Switching to default webcam driver...")
        cap = cv2.VideoCapture(0)

    if not cap.isOpened():
        print("[CRITICAL ERROR] Webcam could not be accessed. Please check camera connections.")
        return

    qr_detector = cv2.QRCodeDetector()
    display_msg = "Scan your QR Code"
    msg_color = (255, 255, 255)
    last_scan_time = 0

    print("[INFO] Scanner Started Successfully.")
    print("[INFO] Press 'q' key on camera window to quit scanner and save CSV.")

    while True:
        ret, frame = cap.read()
        if not ret or frame is None:
            print("[ERROR] Camera feed stopped unexpectedly.")
            break

        data, bbox, _ = qr_detector.detectAndDecode(frame)

        if data:
            try:
                student_info = json.loads(data)
                if "roll" in student_info and "name" in student_info:
                    display_msg, msg_color = mark_attendance(student_info)
                else:
                    display_msg = "INVALID QR CODE"
                    msg_color = (0, 0, 255)
                    play_sound("warning")
            except json.JSONDecodeError:
                display_msg = "FORMAT ERROR"
                msg_color = (0, 0, 255)
                play_sound("warning")
            
            last_scan_time = time.time()

        # Reset UI Banner text after 3 seconds back to default state
        if last_scan_time > 0 and (time.time() - last_scan_time > 3):
            display_msg = "Scan your QR Code"
            msg_color = (255, 255, 255)
            last_scan_time = 0

        # Draw Target QR Bounding Box
        if bbox is not None and len(bbox) > 0:
            pts = bbox.astype(int).reshape(-1, 2)
            for j in range(len(pts)):
                next_point = pts[(j + 1) % len(pts)]
                cv2.line(frame, tuple(pts[j]), tuple(next_point), (255, 0, 0), 2)

        # Draw Top HUD Banner Overlay
        cv2.rectangle(frame, (0, 0), (640, 40), (0, 0, 0), -1)
        cv2.putText(frame, display_msg, (10, 28), cv2.FONT_HERSHEY_SIMPLEX, 0.7, msg_color, 2)

        cv2.imshow("Automated QR Attendance Scanner", frame)

        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()
    export_to_csv()

if __name__ == "__main__":
    run_scanner()