package com.example.clinics.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> greetingMessage;
    private final MutableLiveData<String> aboutMessage;
    private final MutableLiveData<String> achievementMessage;
    private final MutableLiveData<String> goalMessage;
    private final MutableLiveData<String> testimoniesMessage;

    public HomeViewModel() {
        greetingMessage = new MutableLiveData<>();
        aboutMessage = new MutableLiveData<>();
        achievementMessage = new MutableLiveData<>();
        goalMessage = new MutableLiveData<>();
        testimoniesMessage = new MutableLiveData<>();

        greetingMessage.setValue("Welcome to the Clinics!");
        aboutMessage.setValue("About the Hospital called Clinics");
        achievementMessage.setValue("Achievements: ...");
        goalMessage.setValue("Goals: ...");
        testimoniesMessage.setValue("Testimonies: ...");
    }

    public LiveData<String> getGreetingMessage() {
        return greetingMessage;
    }

    public LiveData<String> getAboutMessage() {
        return aboutMessage;
    }

    public LiveData<String> getAchievementMessage() {
        return achievementMessage;
    }

    public LiveData<String> getGoalMessage() {
        return goalMessage;
    }

    public LiveData<String> getTestimoniesMessage() {
        return testimoniesMessage;
    }
}
