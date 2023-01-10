package my.android.griditems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] appname = {"India", "Germany", "USA"};
    int[] applogo = {R.drawable.india, R.drawable.germany, R.drawable.usa};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridActivity grida = new GridActivity(MainActivity.this, appname, applogo);
        gridView = findViewById(R.id.griditems);
        gridView.setAdapter(grida);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "App: "+appname[+i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}