package com.example.clinics.ui.appointment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentFragment extends Fragment {

    private EditText doctorNameEditText;
    private Spinner timeEditText;
    private EditText dateEditText;
    private EditText emailEditText;
    private EditText phoneNumber;
    private EditText patientName;
    private AppointmentViewModel appointmentViewModel;
    private List<String> availableTimes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appointmentViewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);
        availableTimes = createAvailableTimes(); // Initialize the list of available times
    }

    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        // Initialize the UI components
        doctorNameEditText = view.findViewById(R.id.patient_name);
        timeEditText = view.findViewById(R.id.timeEditText);
        phoneNumber = view.findViewById(R.id.phoneNumberText);
        emailEditText = view.findViewById(R.id.emailEditText);
        dateEditText = view.findViewById(R.id.dateEditText);
        patientName = view.findViewById(R.id.patient_name);
        Button submitButton = view.findViewById(R.id.submitButton);

        // Create an ArrayAdapter for the available times and set it to the timeEditText
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, availableTimes);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeEditText.setAdapter(timeAdapter);

        // Set an OnClickListener on the dateEditText to show the DatePickerDialog
        dateEditText.setOnClickListener(v -> showDatePicker());

        submitButton.setOnClickListener(v -> {
            // Retrieve the input values
            String doctorName = doctorNameEditText.getText().toString();
            String time = timeEditText.getSelectedItem().toString();
            String date = dateEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String phone = phoneNumber.getText().toString();
            String patient_Name = patientName.getText().toString();

            // Pass the data to the ViewModel
            appointmentViewModel.submitAppointment(doctorName, time, date, email);

            if (patient_Name.isEmpty() || doctorName.isEmpty() || time.isEmpty() || date.isEmpty() || email.isEmpty() || phone.isEmpty()) {
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
            // Update the dateEditText with the selected date
            calendar.set(year1, month1, dayOfMonth);
            DateFormat dateFormat = DateFormat.getDateInstance();
            String selectedDate = dateFormat.format(calendar.getTime());
            dateEditText.setText(selectedDate);
        }, year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

    private List<String> createAvailableTimes() {
        // Create a list of available times
        List<String> times = new ArrayList<>();
        times.add("09:00 AM");
        times.add("10:00 AM");
        times.add("11:00 AM");
        // Add more available time options as needed
        return times;
    }

    private void clearForm() {
        doctorNameEditText.setText("");
        timeEditText.setSelection(0);
        dateEditText.setText("");
        emailEditText.setText("");
        phoneNumber.setText("");
        patientName.setText("");
    }
}
