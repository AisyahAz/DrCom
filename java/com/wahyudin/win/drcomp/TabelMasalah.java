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
import com.wahyudin.win.drcomp.Model.Gejala;
import com.wahyudin.win.drcomp.Model.Masalah;

import java.util.ArrayList;

public class TabelMasalah extends AppCompatActivity {
    Button btnAddDataMasalah;
    public ArrayList<Masalah> tableArrayList;
    public MasalahAdapter tableArrayAdapter;
    public ListView tableList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_masalah);
        btnAddDataMasalah = (Button)findViewById(R.id.btnAddDataMasalah);
        btnAddDataMasalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TabelMasalah.this, AddDataMasalah.class);
                startActivity(i);
            }
        });

        tableList = findViewById(R.id.Listview_tabelMasalah);

        initTableList();
    }

    private void initTableList() {
        tableArrayList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Masalah");

        tableArrayAdapter = new MasalahAdapter(this,tableArrayList);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Masalah masalah = dataSnapshot.getValue(Masalah.class);
                tableArrayList.add(masalah);
                tableList.setAdapter(tableArrayAdapter);

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Masalah masalah = dataSnapshot.getValue(Masalah.class);
                tableArrayList.add(masalah);
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
                Toast.makeText(TabelMasalah.this,"error = "+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        tableArrayAdapter = new MasalahAdapter(this,tableArrayList);
        tableList.setAdapter(tableArrayAdapter);
    }
}
