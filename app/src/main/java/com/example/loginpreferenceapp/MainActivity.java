package com.example.loginpreferenceapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.buttonLogin);
        btnMoveActivity.setOnClickListener(this);
        }

@Override
public void onClick(View v) {
    if (v.getId() == R.id.buttonLogin) {
        Intent moveIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(moveIntent);
    }
}

}
