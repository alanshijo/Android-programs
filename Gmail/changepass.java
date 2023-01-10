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
import android.widget.TextView;
import android.widget.Toast;

public class changepass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepass);
        TextView logout = findViewById(R.id.btn_logout);
        EditText oldp = findViewById(R.id.oldpass);
        EditText newp = findViewById(R.id.newpass);
        EditText confirm = findViewById(R.id.confirmpass);
        Button uppass = findViewById(R.id.updatepass);
        SharedPreferences pref = getSharedPreferences("signinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(out);
                Toast.makeText(changepass.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
            }
        });
        uppass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldpass = oldp.getText().toString();
                if (TextUtils.isEmpty(oldpass)){
                    oldp.setError("Field cannot be empty");
                }
                String newpass = newp.getText().toString();
                if (TextUtils.isEmpty(newpass)){
                    newp.setError("Field cannot be empty");
                }
                String confirmpass = confirm.getText().toString();
                if (TextUtils.isEmpty(confirmpass)){
                    confirm.setError("Field cannot be empty");
                }
                if (newpass.length()<6){
                    newp.setError("Password must be 6 characters long");
                }
                if (confirmpass.length()<6){
                    confirm.setError("Password must be 6 characters long");
                }
                if (!newpass.matches(confirmpass)){
                    confirm.setError("Passwords doesnot match");
                }
//                else{
//                    if (pref.contains("gmail")){
//
//                    }
//                }
            }
        });
    }
}