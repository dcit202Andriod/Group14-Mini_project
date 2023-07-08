package com.example.clinics.ui.doctors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DoctorsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DoctorsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is service fragment");
    }

    public DoctorsViewModel(MutableLiveData<String> mText) {
        this.mText = mText;
    }

    public LiveData<String> getText() {
        return mText;
    }
}