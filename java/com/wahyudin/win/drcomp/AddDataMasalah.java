package com.wahyudin.win.drcomp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wahyudin.win.drcomp.Model.Masalah;

public class AddDataMasalah extends AppCompatActivity {
    private EditText EditText_Kode;
    private EditText EditText_NamaMasalah;
    private EditText EditText_Saran;
    Button button_addMasalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_masalah);
        EditText_Kode = (EditText) findViewById(R.id.EditText_Kode);
        EditText_NamaMasalah = (EditText) findViewById(R.id.EditText_NamaMasalah);
        EditText_Saran = (EditText)findViewById(R.id.EditText_Saran);

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_masalah = database.getReference("Masalah");
        final String mGroupid = table_masalah.push().getKey();

        button_addMasalah = (Button)findViewById(R.id.button_addMasalah);
        button_addMasalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateKodeInput() | !validateNamaMasalahInput() | !validateSaranInput()){
                    return;
                }
                final ProgressDialog mDialog = new ProgressDialog(AddDataMasalah.this);
                mDialog.setMessage("Silahkan tunggu...");
                mDialog.show();

                table_masalah.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        mDialog.dismiss();
                        Masalah masalah = new Masalah(EditText_Kode.getText().toString(),EditText_NamaMasalah.getText().toString(),EditText_Saran.getText().toString());
                        table_masalah.child(mGroupid).setValue(masalah);
                        Toast.makeText(AddDataMasalah.this, "data is added sucessfully", Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    public boolean validateKodeInput() {
        String kodeInput = EditText_Kode.getText().toString().trim();
        if (kodeInput.isEmpty()) {
            EditText_Kode.setError("Kode tidak boleh kosong!");
            return false;
        }else {
            EditText_Kode.setError(null);
            return true;
        }
    }
    public boolean validateNamaMasalahInput() {
        String namaMasalahInput = EditText_NamaMasalah.getText().toString().trim();
        if (namaMasalahInput.isEmpty()) {
            EditText_NamaMasalah.setError("Nama Masalah tidak boleh kosong!");
            return false;
        }else {
            EditText_NamaMasalah.setError(null);
            return true;
        }
    }
    public boolean validateSaranInput() {
        String saranInput = EditText_Saran.getText().toString().trim();
        if (saranInput.isEmpty()) {
            EditText_Saran.setError("Saran tidak boleh kosong!");
            return false;
        }else {
            EditText_Saran.setError(null);
            return true;
        }
    }

}
