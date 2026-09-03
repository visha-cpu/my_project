package com.hospital.dao;

import com.hospital.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static final List<Patient> patients = new ArrayList<>();
    private static int idCounter = 1;

    static {
        patients.add(new Patient(idCounter++, "Rahul Sharma", 28, "Male"));
        patients.add(new Patient(idCounter++, "Ananya Roy", 34, "Female"));
    }

    public void addPatient(String name, int age, String gender) {
        Patient patient = new Patient(idCounter++, name, age, gender);
        patients.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
}