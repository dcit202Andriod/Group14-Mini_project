package com.example.clinics.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private static MutableLiveData<String> mText = null;

    public ContactViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is service fragment");
    }

    public ContactViewModel(MutableLiveData<String> mText) {
        this.mText = mText;
    }

    public static LiveData<String> getText() {
        return mText;
    }
}