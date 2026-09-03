package com.hospital.dao;

import com.hospital.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static final List<Doctor> doctors = new ArrayList<>();

    static {
        doctors.add(new Doctor(101, "Dr. Sarah Smith", "Cardiology"));
        doctors.add(new Doctor(102, "Dr. Rajesh Sharma", "Neurology"));
        doctors.add(new Doctor(103, "Dr. Priya Patel", "Pediatrics"));
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        for (Doctor doc : doctors) {
            if (doc.getId() == id) return doc;
        }
        return null;
    }
}