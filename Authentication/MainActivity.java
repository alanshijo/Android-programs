package com.example.loganotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ob1=(EditText) findViewById(R.id.a);
        EditText ob2=(EditText) findViewById(R.id.b);
        Button ob3=(Button) findViewById(R.id.c);
        ob3.setOnClickListener(view -> {
            String uname=ob1.getText().toString();
            String passwd=ob2.getText().toString();
            if(uname.equals("admin") && passwd.equals("admin123"))
            {
                Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show();
                Intent newint = new Intent(this,MainActivity2.class);
                startActivity(newint);
            }
            else
            {
                Toast.makeText(this,"Login failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}