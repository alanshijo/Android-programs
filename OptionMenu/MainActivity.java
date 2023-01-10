package com.test.menuoption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_menuOne:
                Toast.makeText(getApplicationContext(), "Menu 1 Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_menuTwo:
                Toast.makeText(getApplicationContext(), "Menu 2 Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_menuThree:
                Toast.makeText(getApplicationContext(), "Menu 3 Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}