package com.wahyudin.win.drcomp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wahyudin.win.drcomp.Interface.ItemClickListener;
import com.wahyudin.win.drcomp.R;

public class GejalaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView Textview_kode;
    public TextView Textview_nama;

    private ItemClickListener itemClickListener;

    public GejalaViewHolder (View itemView) {
        super(itemView);

        Textview_kode = (TextView)itemView.findViewById(R.id.Textview_kode);
        Textview_nama = (TextView)itemView.findViewById(R.id.Textview_nama);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
