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
import com.wahyudin.win.drcomp.Model.Gejala;
import com.wahyudin.win.drcomp.Model.Masalah;

public class AddDataGejala extends AppCompatActivity {
    private EditText EditText_kodeGejala;
    private EditText EditText_namaGejala;
    private Button button_addGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_gejala);

        EditText_kodeGejala = (EditText)findViewById(R.id.EditText_kodeGejala);
        EditText_namaGejala = (EditText)findViewById(R.id.EditText_namaGejala);

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_gejala = database.getReference("Gejala");
        final String mGroupid = table_gejala.push().getKey();

        button_addGejala = (Button)findViewById(R.id.button_addGejala);
        button_addGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateKodeGejalaInput() | !validateNamaGejalaInput()){
                    return;
                }
                final ProgressDialog mDialog = new ProgressDialog(AddDataGejala.this);
                mDialog.setMessage("Silahkan tunggu...");
                mDialog.show();

                table_gejala.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        mDialog.dismiss();
                        Gejala gejala = new Gejala(EditText_kodeGejala.getText().toString(),EditText_namaGejala.getText().toString());
                        table_gejala.child(mGroupid).setValue(gejala);
                        Toast.makeText(AddDataGejala.this, "data is added sucessfully", Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }

    public boolean validateKodeGejalaInput() {
        String kodeInput = EditText_kodeGejala.getText().toString().trim();
        if (kodeInput.isEmpty()) {
            EditText_kodeGejala.setError("Kode tidak boleh kosong!");
            return false;
        }else {
            EditText_kodeGejala.setError(null);
            return true;
        }
    }
    public boolean validateNamaGejalaInput() {
        String kodeInput = EditText_namaGejala.getText().toString().trim();
        if (kodeInput.isEmpty()) {
            EditText_namaGejala.setError("Nama gejala tidak boleh kosong!");
            return false;
        }else {
            EditText_namaGejala.setError(null);
            return true;
        }
    }
}
