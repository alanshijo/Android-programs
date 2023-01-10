package com.example.gemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mail = findViewById(R.id.gmailaddress);
        EditText pass = findViewById(R.id.gpassword);
        Button sign = findViewById(R.id.btn_signin);
        SharedPreferences pref = getSharedPreferences("signinfo", Context.MODE_PRIVATE);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();
                String pswd = pass.getText().toString();
                if (TextUtils.isEmpty(email)){
                    mail.setError("Field cannot be empty");
                }
                if (TextUtils.isEmpty(pswd)){
                    pass.setError("Field cannot be empty");
                }
                else if (email.contains("adminadmin@gmail.com") && pswd.contains("admin123admin")){
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putString("gmail", email);
                    ed.putString("gpasswd", pswd);
                    ed.apply();
                    Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),changepass.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}