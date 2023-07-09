package com.example.clinics.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private static MutableLiveData<String> mText = null;

    public ContactViewModel(MutableLiveData<String> mText) {
        ContactViewModel.mText = mText;
    }

    public static LiveData<String> getText() {
        return mText;
    }
}