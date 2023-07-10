package com.example.clinics.ui.appointment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppointmentViewModel extends ViewModel {
    // LiveData fields for appointment details
    private final MutableLiveData<String> doctorNameLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> timeLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> dayLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> emailLiveData = new MutableLiveData<>();

    // Method for submitting the appointment form
    public void submitAppointment(String doctorName, String time, String day, String email) {
        // Perform any necessary processing or validation

        // Update LiveData fields with the appointment details
        doctorNameLiveData.setValue(doctorName);
        timeLiveData.setValue(time);
        dayLiveData.setValue(day);
        emailLiveData.setValue(email);

        // Perform any other actions as needed (e.g., saving to a database, making API requests, etc.)
    }
}
