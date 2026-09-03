package com.hospital.model;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;

    public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getAppointmentDate() { return appointmentDate; }
}