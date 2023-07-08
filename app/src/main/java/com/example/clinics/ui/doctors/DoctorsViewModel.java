package com.example.clinics.ui.doctors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorsViewModel extends ViewModel {

    private final MutableLiveData<List<Doctor>> doctors;

    public DoctorsViewModel() {
        doctors = new MutableLiveData<>();
        doctors.setValue(getDoctorsList());
    }

    public LiveData<List<Doctor>> getDoctors() {
        return doctors;
    }

    private List<Doctor> getDoctorsList() {
        List<Doctor> doctorsList = new ArrayList<>();
        doctorsList.add(new Doctor("Dr. John Doe", "Cardiology"));
        doctorsList.add(new Doctor("Dr. Jane Smith", "Dermatology"));
        doctorsList.add(new Doctor("Dr. Alex Johnson", "Orthopedics"));
        return doctorsList;
    }
}

