package com.wahyudin.win.drcomp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wahyudin.win.drcomp.Model.Masalah;

import java.util.ArrayList;

public class MasalahAdapter extends ArrayAdapter<Masalah> {
    public MasalahAdapter(Context context, ArrayList<Masalah> masalahs) {
        super(context, 0, masalahs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Masalah masalah = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_item_masalah, parent, false);
        }
        // Lookup view for data population
        TextView TextView_no = (TextView) convertView.findViewById(R.id.Textview_no);
        TextView TextView_nama = (TextView) convertView.findViewById(R.id.Textview_nama);
        // Populate the data into the template view using the data object
        TextView_no.setText(masalah.kode);
        TextView_nama.setText(masalah.nama);

        // Return the completed view to render on screen
        return convertView;
    }

}
