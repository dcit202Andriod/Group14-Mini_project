package com.example.clinics.ui.contact;

import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private String phoneNumber = "0554989558";
    private String emailAddress = "dynamicinnovators32@gmail.com";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
