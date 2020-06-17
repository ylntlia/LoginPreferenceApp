package com.example.loginpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("Registered")
public class MenuActivity extends AppCompatActivity {
    TextView nama;
    Button btnLogout;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nama = findViewById(R.id.tvNama);
        btnLogout = findViewById(R.id.btnLogout);
        final SessionManager sm = new SessionManager(getApplicationContext());
        nama.setText("Selamat Datang, "+sm.getNama());
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.logoutUser();
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
}

