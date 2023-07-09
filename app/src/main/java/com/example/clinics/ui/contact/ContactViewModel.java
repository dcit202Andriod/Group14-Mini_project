package com.example.clinics.ui.contact;

import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private String phoneNumber = "1234567890";
    private String emailAddress = "example@example.com";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
