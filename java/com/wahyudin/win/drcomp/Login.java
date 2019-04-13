package com.wahyudin.win.drcomp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wahyudin.win.drcomp.Common.Common;
import com.wahyudin.win.drcomp.Model.Admin;


public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button signIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            // mainmenu activity disini
            finish();
            startActivity(new Intent(getApplicationContext(), Dashboard.class));

        }

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        signIn = (Button) findViewById(R.id.Button_masuk);

        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == signIn){
            userLogin();
        }
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //jika email kosong
            Toast.makeText(this, "Silahkan masukkan email", Toast.LENGTH_SHORT).show();

            //menghentikan eksekusi dari fungsi ini
            return;
        }
        if (TextUtils.isEmpty(password)){
            //jika password kosong
            Toast.makeText(this, "Silahkan masukkan password", Toast.LENGTH_SHORT).show();

            //menghentikan eksekusi dari fungsi ini
            return;
        }
        // jika validasi berhasil
        // progressBar akan pertama kali ditampilkan
        progressDialog.setMessage("Sedang mendaftarkan user...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //start activity menu utama
                            finish();
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));

                        }

                    }
                });

    }
}