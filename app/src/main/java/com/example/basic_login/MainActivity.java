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
        setContentView(R.layout.activity_main);
        tvUsername = findViewById(R.id.tvUsername);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String data = "welcome" + bundle.getString("data");
            tvUsername.setText(data);
        }


    }
}
