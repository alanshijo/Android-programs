package com.example.testexp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit1 = findViewById(R.id.ed1);
        EditText edit2 = findViewById(R.id.ed2);
        EditText edit3 = findViewById(R.id.passwd);
        Button sub = findViewById(R.id.btn);
        sub.setOnClickListener(view -> {
            String get1 = edit1.getText().toString();
            String get2 = edit2.getText().toString();
            String get3 = edit3.getText().toString();
            if(TextUtils.isEmpty(get1)) {
                edit1.setError("Field cannot be empty");
            }
            else if(TextUtils.isEmpty(get2)) {
                edit2.setError("Field cannot be empty");
            }
            else if((get2.length()!=10)){
                edit2.setError("Invalid phone number");
            }
            else if(get3.length()<6) {
                edit3.setError("Password must be greater than 6 characters");
            }
            else {
                Toast.makeText(getApplicationContext(),"Valid",Toast.LENGTH_SHORT).show();

                if(get1.equals("ajce") && get3.equals("1234567")){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}