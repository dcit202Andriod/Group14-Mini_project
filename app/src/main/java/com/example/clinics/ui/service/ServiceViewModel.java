package com.example.clinics.ui.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServiceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ServiceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is service fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    // Additional hospital services
    public LiveData<String> getEmergencyService() {
        MutableLiveData<String> emergencyService = new MutableLiveData<>();
        emergencyService.setValue("Emergency Service");
        return emergencyService;
    }

    public LiveData<String> getLaboratoryService() {
        MutableLiveData<String> laboratoryService = new MutableLiveData<>();
        laboratoryService.setValue("Laboratory Service");
        return laboratoryService;
    }

    public LiveData<String> getRadiologyService() {
        MutableLiveData<String> radiologyService = new MutableLiveData<>();
        radiologyService.setValue("Radiology Service");
        return radiologyService;
    }
}
