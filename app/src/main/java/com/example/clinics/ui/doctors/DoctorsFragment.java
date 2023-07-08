package com.example.clinics.ui.doctors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.databinding.FragmentDoctorsBinding;

public class DoctorsFragment extends Fragment {

    private FragmentDoctorsBinding binding;
    private DoctorsAdapter doctorsAdapter;
    private DoctorsViewModel doctorsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDoctorsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        doctorsViewModel = new ViewModelProvider(this).get(DoctorsViewModel.class);
        doctorsViewModel.getDoctors().observe(getViewLifecycleOwner(), doctors -> {
            doctorsAdapter = new DoctorsAdapter(requireContext(), doctors);
            binding.listViewDoctors.setAdapter(doctorsAdapter);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
