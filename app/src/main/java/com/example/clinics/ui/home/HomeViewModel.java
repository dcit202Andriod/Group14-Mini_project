package com.example.clinics.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> welcomeMessage;

    public HomeViewModel() {
        welcomeMessage = new MutableLiveData<>();
        welcomeMessage.setValue("Welcome to the Hospital App!");
    }

    public LiveData<String> getWelcomeMessage() {
        return welcomeMessage;
    }
}
