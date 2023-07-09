package com.example.clinics.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.clinics.R;

public class HomeFragment extends Fragment {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView welcomeText = root.findViewById(R.id.text_home);
        Button appointmentButton = root.findViewById(R.id.btn_appointment);

        // Set welcome text
        welcomeText.setText("Welcome to the Hospital App!");

        // Handle button click
        appointmentButton.setOnClickListener(v -> {
            // Perform some action, e.g., open appointment screen
        });

        return root;
    }
}
