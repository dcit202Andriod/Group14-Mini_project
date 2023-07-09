package com.example.clinics.ui.doctors;

public class Doctor {
    private final String name;
    private final String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}
