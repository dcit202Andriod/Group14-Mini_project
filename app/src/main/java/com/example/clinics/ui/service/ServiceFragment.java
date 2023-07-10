package com.example.clinics.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.clinics.R;

public class ServiceFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_service, container, false);

        TextView emergencyServiceTextView = root.findViewById(R.id.emergencyServiceText);
        emergencyServiceTextView.setText("Emergency Care");

        TextView inpatientServiceTextView = root.findViewById(R.id.inpatientServiceText);
        inpatientServiceTextView.setText("Inpatient Care");

        TextView outpatientServiceTextView = root.findViewById(R.id.outpatientServiceText);
        outpatientServiceTextView.setText("Outpatient Care");

        TextView surgeryServiceTextView = root.findViewById(R.id.surgeryServiceText);
        surgeryServiceTextView.setText("Surgery");

        TextView diagnosticServiceTextView = root.findViewById(R.id.diagnosticServiceText);
        diagnosticServiceTextView.setText("Diagnostic Services");

        TextView maternityServiceTextView = root.findViewById(R.id.maternityServiceText);
        maternityServiceTextView.setText("Maternity and Neonatal Care");

        TextView rehabilitationServiceTextView = root.findViewById(R.id.rehabilitationServiceText);
        rehabilitationServiceTextView.setText("Rehabilitation Services");

        TextView mentalHealthServiceTextView = root.findViewById(R.id.mentalHealthServiceText);
        mentalHealthServiceTextView.setText("Mental Health Services");

        TextView specializedServiceTextView = root.findViewById(R.id.specializedServiceText);
        specializedServiceTextView.setText("Specialized Medical Services");

        TextView pharmacyServiceTextView = root.findViewById(R.id.pharmacyServiceText);
        pharmacyServiceTextView.setText("Pharmacy Services");

        TextView palliativeServiceTextView = root.findViewById(R.id.palliativeServiceText);
        palliativeServiceTextView.setText("Palliative Care and Hospice Services");

        return root;
    }
}
