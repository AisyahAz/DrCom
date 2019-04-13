package com.wahyudin.win.drcomp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.wahyudin.win.drcomp.Model.Gejala;
import java.util.ArrayList;

public class SpinnerAdapterGejala extends ArrayAdapter {
    public SpinnerAdapterGejala(Context context, ArrayList<Gejala> gejalas )
    {
        super(context,0,gejalas);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initSpinnerView(position,convertView,parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initSpinnerView(position,convertView,parent);
    }
    private View initSpinnerView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data_item_gejala,parent,false);
        }

        TextView Textview_kode = convertView.findViewById(R.id.Textview_kode);
        TextView Textview_nama = convertView.findViewById(R.id.Textview_nama);
        Gejala gejala = (Gejala) getItem(position);
        Textview_kode.setText(gejala.kode);
        Textview_nama.setText(gejala.nama);

        return convertView;
    }
}
