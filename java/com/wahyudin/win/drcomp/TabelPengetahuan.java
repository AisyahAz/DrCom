package com.wahyudin.win.drcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wahyudin.win.drcomp.Model.Masalah;
import com.wahyudin.win.drcomp.Model.Pengetahuan;

import java.util.ArrayList;

public class TabelPengetahuan extends AppCompatActivity {
    public ArrayList<Pengetahuan> tableArrayList;
    public PengetahuanAdapter tableArrayAdapter;
    public ListView tableList;
    private Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_pengetahuan);

        tableList = findViewById(R.id.Listview_tabelPengetahuan);

        initTableList();

        btnAddData = (Button)findViewById(R.id.btnAddData);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TabelPengetahuan.this, AddDataPengetahuan.class);
                startActivity(i);
            }
        });
    }

    private void initTableList() {
        tableArrayList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Pengetahuan");

        tableArrayAdapter = new PengetahuanAdapter(this,tableArrayList);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Pengetahuan pengetahuan = dataSnapshot.getValue(Pengetahuan.class);
                tableArrayList.add(pengetahuan);
                tableList.setAdapter(tableArrayAdapter);

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Pengetahuan pengetahuan = dataSnapshot.getValue(Pengetahuan.class);
                tableArrayList.add(pengetahuan);
                tableList.setAdapter(tableArrayAdapter);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(TabelPengetahuan.this,"error = "+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        tableArrayAdapter = new PengetahuanAdapter(this,tableArrayList);
        tableList.setAdapter(tableArrayAdapter);
    }
}
