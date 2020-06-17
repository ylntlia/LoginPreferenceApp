package com.example.loginpreferenceapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    protected Cursor cursor;
    EditText user, pass;
    Button btnRegistrasi, btnLogin;
    DataHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DataHelper(this);
        user = findViewById(R.id.edtUsername);
        pass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnRegistrasi = findViewById(R.id.buttonDaftar);
        SessionManager sessionManager = new SessionManager(
                this.getApplication());
        if(sessionManager.isLoggedIn()){
            goToActivity();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CekLogin();
            }
        });
        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(getBaseContext(),
                        RegisterActivity.class);
                startActivity(daftar);
            }
        });
    }
    public void CekLogin(){
        SessionManager sessionManager = new SessionManager(
                this.getApplication());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_user WHERE username = " + "'"+user.getText().toString()+"' AND password = '"+pass.getText().toString()+"'",
        null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            sessionManager.createLoginSession(cursor.getString(2).toString(),
                    cursor.getString(1).toString());
            Toast.makeText(getApplicationContext(),"Benar",Toast.LENGTH_SHORT).show
                    ();
            goToActivity();
        }else{
            Toast.makeText(getApplicationContext(),"Salah",Toast.LENGTH_SHORT).show
                    ();
        }
    }
    public void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),
                MenuActivity.class);
        startActivity(mIntent);
    }
}

