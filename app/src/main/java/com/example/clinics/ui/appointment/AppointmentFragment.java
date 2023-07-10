package com.example.clinics.ui.appointment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

import java.text.DateFormat;
import java.util.Calendar;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        // Initialize the UI components
        doctorNameEditText = view.findViewById(R.id.patient_name);
        timeEditText = view.findViewById(R.id.timeEditText);
        dayEditText = view.findViewById(R.id.dayEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        Button submitButton = view.findViewById(R.id.submitButton);

        // Set an OnClickListener on the dayEditText to show the DatePickerDialog
        dayEditText.setOnClickListener(v -> showDatePicker());

        submitButton.setOnClickListener(v -> {
            // Retrieve the input values
            String doctorName = doctorNameEditText.getText().toString();
            String time = timeEditText.getText().toString();
            String day = dayEditText.getText().toString();
            String email = emailEditText.getText().toString();

            // Pass the data to the ViewModel
            appointmentViewModel.submitAppointment(doctorName, time, day, email);

            if (doctorName.isEmpty() || time.isEmpty() || day.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Appointment submitted successfully", Toast.LENGTH_SHORT).show();
                clearForm();
            }
        });

        return view;
    }

    private void showDatePicker() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), (view, year1, month1, dayOfMonth) -> {
            // Update the dayEditText with the selected date
            calendar.set(year1, month1, dayOfMonth);
            DateFormat dateFormat = DateFormat.getDateInstance();
            String selectedDate = dateFormat.format(calendar.getTime());
            dayEditText.setText(selectedDate);
        }, year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

    private void clearForm() {
        doctorNameEditText.setText("");
        timeEditText.setText("");
        dayEditText.setText("");
        emailEditText.setText("");
    }
}
