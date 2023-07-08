package com.example.clinics.ui.contact;

import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private final String contactName;
    private final String contactPhone;
    private final String contactEmail;

    public ContactViewModel() {
        contactName = "John Doe";
        contactPhone = "+1234567890";
        contactEmail = "john.doe@example.com";
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
