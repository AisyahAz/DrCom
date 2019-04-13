package com.wahyudin.win.drcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    Button btnTabelGejala,btnTabelMasalah,btnTabelPengetahuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnTabelPengetahuan = (Button)findViewById(R.id.btnTabelPengetahuan);
        btnTabelPengetahuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, TabelPengetahuan.class);
                startActivity(i);
            }
        });
        btnTabelGejala = (Button)findViewById(R.id.btnTabelGejala);
        btnTabelGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, TabelGejala.class);
                startActivity(i);
            }
        });
        btnTabelMasalah = (Button)findViewById(R.id.btnTabelMasalah);
        btnTabelMasalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, TabelMasalah.class);
                startActivity(i);
            }
        });
    }
}
