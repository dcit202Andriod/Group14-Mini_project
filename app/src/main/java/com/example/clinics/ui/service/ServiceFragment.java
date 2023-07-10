package com.example.clinics.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.databinding.FragmentServiceBinding;

public class ServiceFragment extends Fragment {

    private FragmentServiceBinding binding;
    private ServiceViewModel serviceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView serviceTextView = binding.serviceText;
        final TextView emergencyServiceTextView = binding.emergencyServiceText;
        final TextView laboratoryServiceTextView = binding.laboratoryServiceText;
        final TextView radiologyServiceTextView = binding.radiologyServiceText;


        serviceViewModel = new ViewModelProvider(this).get(ServiceViewModel.class);

        serviceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String text) {
                serviceTextView.setText(text);
            }
        });

        serviceViewModel.getEmergencyService().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String emergencyService) {
                emergencyServiceTextView.setText(emergencyService);
            }
        });

        serviceViewModel.getLaboratoryService().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String laboratoryService) {
                laboratoryServiceTextView.setText(laboratoryService);
            }
        });

        serviceViewModel.getRadiologyService().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String radiologyService) {
                radiologyServiceTextView.setText(radiologyService);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
