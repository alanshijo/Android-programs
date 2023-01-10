package com.example.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l = findViewById(R.id.list);
        String[] names = {
                "Arun Babu",
                "Abhimon",
                "Sandra George",
                "Rajumon P",
                "Roni Tom"
        };
        int[] icons = {
                R.drawable.user,
                R.drawable.user,
                R.drawable.user,
                R.drawable.user,
                R.drawable.user
        };
        ArrayList<HashMap<String, Object>> arr = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("studName", names[i]);
            map.put("studIcon", icons[i]);
            arr.add(map);
        }

        String[] from = {"studName", "studIcon"};
        int to[] = {R.id.text1, R.id.image1};

        SimpleAdapter adapter = new SimpleAdapter(this, arr, R.layout.list_items, from, to);
        l.setAdapter(adapter);
    }
}