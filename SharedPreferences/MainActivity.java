package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1 = findViewById(R.id.edit1);
        Button bt1 = findViewById(R.id.btn1);
        Button bt2 = findViewById(R.id.btn2);
        Button bt3 = findViewById(R.id.btn3);
        TextView t1 = findViewById(R.id.display);
        SharedPreferences pref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edi = pref.edit();
                String edit = ed1.getText().toString();
                edi.putString("namekey",edit);
                edi.apply();
                Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pref.contains("namekey")) {
                    t1.setText(pref.getString("namekey", ""));
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                t1.setText("");
            }
        });
    }
}