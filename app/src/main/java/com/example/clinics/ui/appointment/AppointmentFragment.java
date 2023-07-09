package com.example.clinics.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

public class AppointmentFragment extends Fragment {

    private EditText patientNameEditText;
    private EditText timeEditText;
    private EditText dayEditText;
    private EditText emailEditText;
    private AppointmentViewModel appointmentViewModel;
    private Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appointmentViewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        // Initialize the UI components
        spinner = view.findViewById(R.id.spinner);

        // Create an ArrayAdapter using a string array resource and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.spinner_items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        patientNameEditText = view.findViewById(R.id.patient_name);
        timeEditText = view.findViewById(R.id.timeEditText);
        dayEditText = view.findViewById(R.id.dayEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        Button submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            // Retrieve the input values
            String patientName = patientNameEditText.getText().toString();
            String time = timeEditText.getText().toString();
            String day = dayEditText.getText().toString();
            String email = emailEditText.getText().toString();

            // Pass the data to the ViewModel
            appointmentViewModel.submitAppointment(patientName, time, day, email);

            if (patientName.isEmpty() || time.isEmpty() || day.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Appointment submitted successfully", Toast.LENGTH_SHORT).show();
                patientNameEditText.setText("");
                timeEditText.setText("");
                dayEditText.setText("");
                emailEditText.setText("");
            }
        });

        return view;
    }
}
