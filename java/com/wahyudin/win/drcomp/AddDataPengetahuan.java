package com.wahyudin.win.drcomp;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.wahyudin.win.drcomp.Model.Gejala;
import com.wahyudin.win.drcomp.Model.Masalah;
import com.wahyudin.win.drcomp.Model.Pengetahuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddDataPengetahuan extends AppCompatActivity{
    public String fullgejala;
    public String hasiltidak1;
    public String hasilYa1;
    public String fullmasalah;
    public String selectedSpinnerGejala1;
    public String selectedSpinnerGejala2;
    public String selectedSpinnerGejala3;
    public String selectedSpinnerMasalah1;
    public String selectedSpinnerMasalah2;
    private EditText EditText_addPertanyaan;
    private Button button_addPengetahuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_pengetahuan);

        EditText_addPertanyaan = (EditText)findViewById(R.id.EditText_addPertanyaan);

        final Spinner spin1 = findViewById(R.id.spinner_gejala);
        final Spinner spinGejala1 = findViewById(R.id.spinner_gejala1);
        final Spinner spinGejala2 = findViewById(R.id.spinner_gejala2);
        final Spinner spinMasalah = findViewById(R.id.spinner_masalah);
        final Spinner spinMasalah1 = findViewById(R.id.spinner_masalah1);

        final ArrayList<Gejala> gejalaList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Gejala");



        final ArrayList<String> gejala = new ArrayList<>();


        DatabaseReference myRefgejala1 = database.getReference("Gejala");
        myRefgejala1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gejala.add("");

                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String kode=datas.child("kode").getValue().toString();
                    String nama=datas.child("nama").getValue().toString();

                    fullgejala=kode+" - "+nama;
                    gejala.add(fullgejala);
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, gejala);

                    spin1.setPrompt("pilih gejala!");
                    //tambahan baru

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, gejala) {
                        @Override
                        public View getDropDownView(int position, View convertView, ViewGroup parent)
                        {
                            View v = null;

                            // If this is the initial dummy entry, make it hidden
                            if (position == 0) {
                                TextView tv = new TextView(getContext());
                                tv.setHeight(0);
                                tv.setVisibility(View.GONE);
                                v = tv;
                            }
                            else {
                                // Pass convertView as null to prevent reuse of special case views
                                v = super.getDropDownView(position, null, parent);
                            }

                            // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                            parent.setVerticalScrollBarEnabled(false);
                            return v;
                        }
                    };
                    //akhir tambahan baru
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spin1.setAdapter(adapter);
                    spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            selectedSpinnerGejala1 = parent.getItemAtPosition(pos).toString();

                                // Notify the selected item text
//                                Toast.makeText(parent.getContext(),
//                                        "OnItemSelectedListener : " + selectedSpinnerGejala1,
//                                        Toast.LENGTH_SHORT).show();


                    }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            return;
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Gagal membaca data gejala", error.toException());
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                gejala.add("");

                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String kode=datas.child("kode").getValue().toString();
                    String nama=datas.child("nama").getValue().toString();

                    fullgejala=kode+" - "+nama;

                    gejala.add(fullgejala);
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, gejala);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinGejala1.setAdapter(adapter);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, gejala) {
                        @Override
                        public View getDropDownView(int position, View convertView, ViewGroup parent)
                        {
                            View v = null;

                            // If this is the initial dummy entry, make it hidden
                            if (position == 0) {
                                TextView tv = new TextView(getContext());
                                tv.setHeight(0);
                                tv.setVisibility(View.GONE);
                                v = tv;
                            }
                            else {
                                // Pass convertView as null to prevent reuse of special case views
                                v = super.getDropDownView(position, null, parent);
                            }

                            // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                            parent.setVerticalScrollBarEnabled(false);
                            return v;
                        }
                    };
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinGejala1.setAdapter(adapter);
                    spinGejala1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            selectedSpinnerGejala2 = parent.getItemAtPosition(pos).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
return;                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Gagal membaca data gejala", error.toException());
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gejala.add("");

                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String kode=datas.child("kode").getValue().toString();
                    String nama=datas.child("nama").getValue().toString();

                    fullgejala=kode+" - "+nama;

                    gejala.add(fullgejala);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, gejala) {
                        @Override
                        public View getDropDownView(int position, View convertView, ViewGroup parent)
                        {
                            View v = null;

                            // If this is the initial dummy entry, make it hidden
                            if (position == 0) {
                                TextView tv = new TextView(getContext());
                                tv.setHeight(0);
                                tv.setVisibility(View.GONE);
                                v = tv;
                            }
                            else {
                                // Pass convertView as null to prevent reuse of special case views
                                v = super.getDropDownView(position, null, parent);
                            }

                            // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                            parent.setVerticalScrollBarEnabled(false);
                            return v;
                        }
                    };
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinGejala2.setAdapter(adapter);
                    spinGejala2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            selectedSpinnerGejala3 = parent.getItemAtPosition(pos).toString();

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
return;                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Gagal membaca data gejala", error.toException());
            }
        });

        final ArrayList<Masalah> masalahList = new ArrayList<>();
        FirebaseDatabase databaseMasalah = FirebaseDatabase.getInstance();
        DatabaseReference myRefMasalah = database.getReference("Masalah");

        final ArrayList<String> masalah = new ArrayList<>();
        myRefMasalah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                masalah.add("");
                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String kode=datas.child("kode").getValue().toString();
                    String nama=datas.child("nama").getValue().toString();

                    fullmasalah=kode+" - "+nama;

                    masalah.add(fullmasalah);
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, masalah);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinMasalah.setAdapter(adapter);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, masalah) {
                        @Override
                        public View getDropDownView(int position, View convertView, ViewGroup parent)
                        {
                            View v = null;

                            // If this is the initial dummy entry, make it hidden
                            if (position == 0) {
                                TextView tv = new TextView(getContext());
                                tv.setHeight(0);
                                tv.setVisibility(View.GONE);
                                v = tv;
                            }
                            else {
                                // Pass convertView as null to prevent reuse of special case views
                                v = super.getDropDownView(position, null, parent);
                            }

                            // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                            parent.setVerticalScrollBarEnabled(false);
                            return v;
                        }
                    };
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinMasalah.setAdapter(adapter);
                    spinMasalah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            selectedSpinnerMasalah1 = parent.getItemAtPosition(pos).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
return;                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Gagal membaca data gejala", error.toException());
            }
        });
        myRefMasalah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                masalah.add("");
                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String kode=datas.child("kode").getValue().toString();
                    String nama=datas.child("nama").getValue().toString();

                    fullmasalah=kode+" - "+nama;

                    masalah.add(fullmasalah);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, masalah) {
                        @Override
                        public View getDropDownView(int position, View convertView, ViewGroup parent)
                        {
                            View v = null;

                            // If this is the initial dummy entry, make it hidden
                            if (position == 0) {
                                TextView tv = new TextView(getContext());
                                tv.setHeight(0);
                                tv.setVisibility(View.GONE);
                                v = tv;
                            }
                            else {
                                // Pass convertView as null to prevent reuse of special case views
                                v = super.getDropDownView(position, null, parent);
                            }

                            // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                            parent.setVerticalScrollBarEnabled(false);
                            return v;
                        }
                    };
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinMasalah1.setAdapter(adapter);
                    spinMasalah1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            selectedSpinnerMasalah2 = parent.getItemAtPosition(pos).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
return;                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Gagal membaca data gejala", error.toException());
            }
        });

        //init firebase
        final FirebaseDatabase databasePengetahuan = FirebaseDatabase.getInstance();
        final DatabaseReference table_pengetahuan = database.getReference("Pengetahuan");
        final String mGroupidPengetahuan = table_pengetahuan.push().getKey();

        button_addPengetahuan = (Button)findViewById(R.id.button_addPengetahuan);
        button_addPengetahuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(AddDataPengetahuan.this);
                mDialog.setMessage("Silahkan tunggu...");
                mDialog.show();

                table_pengetahuan.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        mDialog.dismiss();
                        String kosongTidak = "";


                        if (selectedSpinnerGejala3 != kosongTidak)
                                hasiltidak1 = selectedSpinnerGejala3;
                        else if(selectedSpinnerMasalah2 != kosongTidak){
                            hasiltidak1 = selectedSpinnerMasalah2;
                        }

                        String kosongYa = "";


                        if (selectedSpinnerGejala2 != kosongYa)
                            hasilYa1 = selectedSpinnerGejala3;
                        else if(selectedSpinnerMasalah1 != kosongYa){
                            hasilYa1 = selectedSpinnerMasalah1;
                        }




                        Pengetahuan pengetahuan = new Pengetahuan(hasiltidak1,hasilYa1,selectedSpinnerGejala1,EditText_addPertanyaan.getText().toString());
                        table_pengetahuan.child(mGroupidPengetahuan).setValue(pengetahuan);
                        Toast.makeText(AddDataPengetahuan.this, "data is added sucessfully", Toast.LENGTH_SHORT).show();
                        finish();


                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}

//    private void initGejalaSpinner() {
//        gejalaArrayList = new ArrayList<>();
//       // gejalaArrayList.add(new Gejala("اختر المحافظه", "0"));
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Gejala");
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Gejala gejala = dataSnapshot.getValue(Gejala.class);
//                gejalaArrayList.add(gejala);
//            }
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                Gejala gejala = dataSnapshot.getValue(Gejala.class);
//                gejalaArrayList.add(gejala);
//            }
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//            }
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        spinGejala = findViewById(R.id.spinner_gejala);
//        spinnerAdapterGejala = new SpinnerAdapterGejala(this, gejalaArrayList);
//
//        spinGejala.setAdapter(spinnerAdapterGejala);
//        spinGejala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                //  Gejala gejala=  (Gejala) spinGejala.getSelectedItem();
//                //  Toast.makeText(AddDataPengetahuan.this, gejala.kode, Toast.LENGTH_SHORT).show();
//
//                Toast.makeText(AddDataPengetahuan.this, "good", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                Toast.makeText(AddDataPengetahuan.this, "bad", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Toast.makeText(this, "that means the  method is working", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        spinGejala.setOnItemClickListener();
//        Gejala gejala = (Gejala)spinGejala.getSelectedItem();
//        Toast.makeText(this, gejala.kode,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
