package com.wahyudin.win.drcomp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wahyudin.win.drcomp.Model.Masalah;
import com.wahyudin.win.drcomp.Model.Pengetahuan;

import java.util.ArrayList;

public class PengetahuanAdapter extends ArrayAdapter<Pengetahuan> {
    public PengetahuanAdapter(Context context, ArrayList<Pengetahuan> pengetahuans) {
        super(context, 0, pengetahuans);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Pengetahuan pengetahuan = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_item_pengetahuan, parent, false);
        }
        // Lookup view for data population
        TextView TextView_no = (TextView) convertView.findViewById(R.id.Textview_no);
        TextView Textview_pertanyaan = (TextView) convertView.findViewById(R.id.Textview_pertanyaan);
        // Populate the data into the template view using the data object
        TextView_no.setText(""+(position+1)+". ");
        Textview_pertanyaan.setText(pengetahuan.pertanyaan);

        // Return the completed view to render on screen
        return convertView;
    }

}
