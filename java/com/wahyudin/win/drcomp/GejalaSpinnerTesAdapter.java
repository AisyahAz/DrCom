package com.wahyudin.win.drcomp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wahyudin.win.drcomp.Model.Gejala;

import java.util.ArrayList;

public class GejalaSpinnerTesAdapter extends ArrayAdapter<Gejala> {
    public GejalaSpinnerTesAdapter(Context context, ArrayList<Gejala> gejalas) {
        super(context, 0, gejalas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Gejala gejala = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_item_gejala, parent, false);
        }
        // Lookup view for data population
        TextView TextView_kode = (TextView) convertView.findViewById(R.id.Textview_kode);
        TextView TextView_nama = (TextView) convertView.findViewById(R.id.Textview_nama);
        // Populate the data into the template view using the data object
        TextView_kode.setText(gejala.kode);
        TextView_nama.setText(gejala.nama);

        // Return the completed view to render on screen
        return convertView;
    }

}