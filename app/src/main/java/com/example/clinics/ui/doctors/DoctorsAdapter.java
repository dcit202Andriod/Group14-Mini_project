package com.example.clinics.ui.doctors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clinics.R;

import java.util.List;

public class DoctorsAdapter extends BaseAdapter {

    private final Context context;
    private final List<Doctor> doctorsList;

    public DoctorsAdapter(Context context, List<Doctor> doctorsList) {
        this.context = context;
        this.doctorsList = doctorsList;
    }

    @Override
    public int getCount() {
        return doctorsList.size();
    }

    @Override
    public Object getItem(int position) {
        return doctorsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_doctor, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.text_doctor_name);
            viewHolder.textViewSpecialty = convertView.findViewById(R.id.text_doctor_specialty);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Doctor doctor = doctorsList.get(position);

        viewHolder.textViewName.setText(doctor.getName());
        viewHolder.textViewSpecialty.setText(doctor.getSpecialty());

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewSpecialty;
    }
}
