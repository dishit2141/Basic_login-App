package com.example.basic_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle receivedBundle = getIntent().getExtras();
        String Username = receivedBundle.getString("LoggedInUsername");
        setContentView(R.layout.activity_main);
        tvUsername = findViewById(R.id.tvUsername);
        tvUsername.setText(new StringBuilder().append("Welcome ").append(Username).toString());

    }
}