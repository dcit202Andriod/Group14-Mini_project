package com.example.clinics.ui.doctors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.clinics.R;

public class DoctorsFragment extends Fragment {

    private ListView doctorsListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);
        doctorsListView = rootView.findViewById(R.id.doctorsListView);

        // Sample data of doctors and their positions
        String[] doctors = {
                "Dr. John Smith - Cardiologist",
                "Dr. Jane Doe - Neurologist",
                "Dr. Robert Johnson - Orthopedic Surgeon",
                "Dr. Sarah Williams - Pediatrician",
                "Dr. Michael Brown - Dermatologist"
        };

        // Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, doctors);
        doctorsListView.setAdapter(adapter);

        return rootView;
    }
}
