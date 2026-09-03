package com.hospital.dao;

import com.hospital.model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private static final List<Appointment> appointments = new ArrayList<>();
    private static int idCounter = 1;

    public boolean isDoctorAvailable(int doctorId, String date) {
        for (Appointment app : appointments) {
            if (app.getDoctorId() == doctorId && app.getAppointmentDate().equalsIgnoreCase(date)) {
                return false;
            }
        }
        return true;
    }

    public boolean bookAppointment(int patientId, int doctorId, String date) {
        Appointment newAppointment = new Appointment(idCounter++, patientId, doctorId, date);
        appointments.add(newAppointment);
        return true;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}