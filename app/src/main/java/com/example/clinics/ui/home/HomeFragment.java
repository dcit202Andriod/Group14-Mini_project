package com.example.clinics.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinics.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView welcomeQuoteTextView = root.findViewById(R.id.welcomeQuoteTextView);
        TextView healthQuoteTextView = root.findViewById(R.id.healthQuoteTextView);

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        String welcomeQuote = homeViewModel.getWelcomeQuote();
        String healthQuote = homeViewModel.getHealthQuote();

        welcomeQuoteTextView.setText(welcomeQuote);
        healthQuoteTextView.setText(healthQuote);

        return root;
    }
}
