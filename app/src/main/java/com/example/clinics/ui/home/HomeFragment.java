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
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView greetingText = root.findViewById(R.id.text_greeting);
        TextView aboutText = root.findViewById(R.id.text_about);
        TextView achievementText = root.findViewById(R.id.text_achievements_and_goals);
        TextView goalText = root.findViewById(R.id.text_all_aims);

        homeViewModel.getGreetingMessage().observe(getViewLifecycleOwner(), greetingText::setText);
        homeViewModel.getAboutMessage().observe(getViewLifecycleOwner(), aboutText::setText);
        homeViewModel.getAchievementMessage().observe(getViewLifecycleOwner(), achievementText::setText);
        homeViewModel.getGoalMessage().observe(getViewLifecycleOwner(), goalText::setText);

        return root;
    }
}
