package com.example.clinics.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

public class AppointmentFragment extends Fragment {

    private EditText doctorNameEditText;
    private EditText timeEditText;
    private EditText dayEditText;
    private EditText emailEditText;
    private AppointmentViewModel appointmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appointmentViewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        // Initialize the UI components
        doctorNameEditText = view.findViewById(R.id.doctorNameEditText);
        timeEditText = view.findViewById(R.id.timeEditText);
        dayEditText = view.findViewById(R.id.dayEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        Button submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            // Retrieve the input values
            String doctorName = doctorNameEditText.getText().toString();
            String time = timeEditText.getText().toString();
            String day = dayEditText.getText().toString();
            String email = emailEditText.getText().toString();

            // Pass the data to the ViewModel
            appointmentViewModel.submitAppointment(doctorName, time, day, email);

            if (doctorNameEditText.getText().toString().equals("") ||
                    timeEditText.getText().toString().equals("") ||
                    dayEditText.getText().toString().equals("") ||
                    emailEditText.getText().toString().equals("")) {

                Toast.makeText(getActivity().getApplicationContext(), "All fields are required!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Appointment submitted successfully", Toast.LENGTH_SHORT).show();
                doctorNameEditText.setText("");
                timeEditText.setText("");
                dayEditText.setText("");
                emailEditText.setText("");
            }

        });

        return view;
    }
}
