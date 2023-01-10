package com.example.implicittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit = findViewById(R.id.ed1);
        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edit.getText().toString();
                Intent newIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(txt));
                startActivity(newIntent);
            }
        });
    }
}

