package com.example.basic_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText etUserName;
    EditText etPassword;
    Button btnlogin;
    CheckBox cbrememberme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp =getSharedPreferences("spUserSettings" ,MODE_PRIVATE);
        String FetchUsername = sp.getString("spkeyUsername","No data Found");
        String FetchPassword = sp.getString("spkeyPassword","No data found");


        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        cbrememberme = findViewById(R.id.cbrememberme);
        btnlogin = findViewById(R.id.btnlogin);
        etUserName.setText(FetchUsername);
        etPassword.setText(FetchPassword);
        btnlogin.setOnClickListener(Login.this);
    }

    @Override
    public void onClick(View view) {
        if(etPassword.getText().toString().equals("Admin"))
        {
            if(cbrememberme.isChecked())
            {
                SharedPreferences sp = getSharedPreferences("spUserSettings", MODE_PRIVATE);
                SharedPreferences.Editor spEditor = sp.edit();
                spEditor.putString("spkeyUsername",etUserName.getText().toString());
                spEditor.putString("spkeyPassword",etPassword.getText().toString());
                spEditor.apply();
            }
            Toast.makeText(Login.this,"Login Successful Welcome to the App", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(Login.this, MainActivity.class);
            String uname = etUserName.getText().toString();
            next.putExtra("LoggedInUsername",etUserName.getText().toString().equals(uname));
            Login.this.startActivity(next);

        }
        else
        {
            Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
        }
    }
}