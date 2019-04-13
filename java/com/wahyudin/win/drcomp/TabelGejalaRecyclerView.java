package com.wahyudin.win.drcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wahyudin.win.drcomp.Interface.ItemClickListener;
import com.wahyudin.win.drcomp.Model.TesGejala;
import com.wahyudin.win.drcomp.ViewHolder.GejalaViewHolder;

public class TabelGejalaRecyclerView extends AppCompatActivity {

    //Firebase
    FirebaseDatabase database;
    DatabaseReference gejalas;
    FirebaseRecyclerAdapter<TesGejala,GejalaViewHolder>adapter;


    //View
    RecyclerView recycler_gejala;
    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_gejala_recycler_view);

        //Init Firebase
        database = FirebaseDatabase.getInstance();
        gejalas = database.getReference("TesGejala");



        // Init View
        recycler_gejala = (RecyclerView)findViewById(R.id.Recyclerview_gejala);
        recycler_gejala.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_gejala.setLayoutManager(layoutManager);

        loadGejala();


    }

    private void loadGejala() {
        adapter = new FirebaseRecyclerAdapter<TesGejala, GejalaViewHolder>(
                TesGejala.class,
                R.layout.test_item_gejala,
                GejalaViewHolder.class,
                gejalas
        ) {
            @Override
            protected void populateViewHolder(GejalaViewHolder viewHolder, TesGejala model, int position) {
                viewHolder.Textview_kode.setText(model.getKode());
                viewHolder.Textview_nama.setText(model.getNama());

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        // mengirim Kategori Id dan membuka activity baru
                        Intent sembakoList = new Intent(TabelGejalaRecyclerView.this, Dashboard.class);
                        sembakoList.putExtra("CategoryId",adapter.getRef(position).getKey());
                        startActivity(sembakoList);
                    }
                });
            }
        };
        adapter.notifyDataSetChanged();// merefresh data bila data diubah
        recycler_gejala.setAdapter(adapter);
    }
}
