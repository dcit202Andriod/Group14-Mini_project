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
        doctorsList.add(new Doctor("Dr. Daniel Rodriguez", "Head of Internal Medicine"));
        doctorsList.add(new Doctor("Dr. Benjamin Cooper", "Director of Anesthesiology"));
        doctorsList.add(new Doctor("Dr. Alex Johnson", "Orthopedics"));
        doctorsList.add(new Doctor("Dr. Olivia Hall", "Chief of Endocrinology"));
        doctorsList.add(new Doctor("Dr. Megan Thompson", "Director of Psychiatry"));
        doctorsList.add(new Doctor("Dr. Amanda Lewis", "Director of Pulmonology"));
        doctorsList.add(new Doctor("Dr. Jennifer Lee", "Director of Emergency Medicine"));
        doctorsList.add(new Doctor("Dr. Michael Johnson", "Director of Surgery"));
        doctorsList.add(new Doctor("Dr. Robert Wilson", "Head of Neurology"));
        doctorsList.add(new Doctor("Dr. David Anderson", "Chief of Cardiology"));
        return doctorsList;
    }
}

