package com.example.clinics.ui.appointment;

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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

import java.text.DateFormat;
import java.util.Calendar;

public class AppointmentFragment extends Fragment {

    private EditText doctorNameEditText;
    private EditText timeEditText;
    private EditText dateEditText;
    private EditText emailEditText;
    private EditText phoneNumber;
    private EditText patientName;
    private Spinner spinner1;
    private Spinner spinner2;
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
        spinner1 = view.findViewById(R.id.spinner);

        // Create an ArrayAdapter using a string array resource and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.spinner_items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);

        // Initialize the UI components
        spinner2 = view.findViewById(R.id.timeEditText);

        // Create an ArrayAdapter using a string array resource and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(requireContext(),
                R.array.available_times, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter1);

        // Initialize the UI components
        doctorNameEditText = view.findViewById(R.id.patient_name);
        timeEditText = view.findViewById(R.id.timeEditText);
        phoneNumber = view.findViewById(R.id.phoneNumberText);
        emailEditText = view.findViewById(R.id.emailEditText);
        dateEditText = view.findViewById(R.id.dateEditText);
        patientName = view.findViewById(R.id.patient_name);
        Button submitButton = view.findViewById(R.id.submitButton);

        // Set an OnClickListener on the dateEditText to show the DatePickerDialog
        dateEditText.setOnClickListener(v -> showDatePicker());

        submitButton.setOnClickListener(v -> {
            // Retrieve the input values
            String doctorName = doctorNameEditText.getText().toString();
            String time = timeEditText.getText().toString();
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
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year1, month1, dayOfMonth) -> {
            // Update the dateEditText with the selected date
            calendar.set(year1, month1, dayOfMonth);
            DateFormat dateFormat = DateFormat.getDateInstance();
            String selectedDate = dateFormat.format(calendar.getTime());
            dateEditText.setText(selectedDate);
        }, year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

    private void clearForm() {
        doctorNameEditText.setText("");
        timeEditText.setText("");
        dateEditText.setText("");
        emailEditText.setText("");
        phoneNumber.setText("");
        patientName.setText("");
    }
}
