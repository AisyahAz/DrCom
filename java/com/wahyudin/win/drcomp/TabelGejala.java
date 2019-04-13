package com.wahyudin.win.drcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.wahyudin.win.drcomp.Model.Gejala;

import java.util.ArrayList;

public class TabelGejala extends AppCompatActivity {
    Button btnAddData;
    public ArrayList<Gejala> tableArrayList;
    public GejalaAdapter tableArrayAdapter;
    public ListView tableList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_gejala);
        btnAddData = (Button)findViewById(R.id.btnAddData);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TabelGejala.this, AddDataGejala.class);
                startActivity(i);
            }
        });

        tableList = findViewById(R.id.Listview_tabel2);

        tableList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked","pos: " + pos);

                return true;
            }
        });

        initTableList();
    }



    private void initTableList() {
        tableArrayList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Gejala");

        tableArrayAdapter = new GejalaAdapter(this,tableArrayList);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Gejala gejala = dataSnapshot.getValue(Gejala.class);
                tableArrayList.add(gejala);
                tableList.setAdapter(tableArrayAdapter);

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Gejala gejala = dataSnapshot.getValue(Gejala.class);
                tableArrayList.add(gejala);
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
                Toast.makeText(TabelGejala.this,"error = "+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        tableArrayAdapter = new GejalaAdapter(this,tableArrayList);
        tableList.setAdapter(tableArrayAdapter);
    }

}
