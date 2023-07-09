package com.example.clinics.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;
    private Button callButton;
    private Button emailButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        callButton = root.findViewById(R.id.call_button);
        emailButton = root.findViewById(R.id.email_button);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open available apps for phone calls
                String phoneNumber = contactViewModel.getPhoneNumber();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open available apps for email
                String emailAddress = contactViewModel.getEmailAddress();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + emailAddress));
                startActivity(emailIntent);
            }
        });

        return root;
    }
}
