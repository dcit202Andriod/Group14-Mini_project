package com.example.clinics.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

public class ContactFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactViewModel contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView contactNameTextView = root.findViewById(R.id.contactNameTextView);
        TextView contactPhoneTextView = root.findViewById(R.id.contactPhoneTextView);
        TextView contactEmailTextView = root.findViewById(R.id.contactEmailTextView);

        String contactName = contactViewModel.getContactName();
        String contactPhone = contactViewModel.getContactPhone();
        String contactEmail = contactViewModel.getContactEmail();

        contactNameTextView.setText(contactName);
        contactPhoneTextView.setText(contactPhone);
        contactEmailTextView.setText(contactEmail);

        return root;
    }
}
