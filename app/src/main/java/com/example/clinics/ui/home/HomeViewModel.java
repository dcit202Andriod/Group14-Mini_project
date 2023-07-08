package com.example.clinics.ui.home;

import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final String welcomeQuote;
    private final String healthQuote;

    public HomeViewModel() {
        welcomeQuote = "Embrace a healthier lifestyle and experience the joy of well-being. Welcome to a new chapter of your life.";
        healthQuote = "Health is a state of complete physical, mental, and social well-being, not merely the absence of disease or infirmity. - World Health Organization";
    }

    public String getWelcomeQuote() {
        return welcomeQuote;
    }

    public String getHealthQuote() {
        return healthQuote;
    }
}
