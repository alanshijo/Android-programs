package my.android.exceptionhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1 = findViewById(R.id.edit1);
        EditText et2 = findViewById(R.id.edit2);
        Button butt = findViewById(R.id.calbtn);
        butt.setOnClickListener(view -> {
            int x = Integer.parseInt(et1.getText().toString());
            int y = Integer.parseInt(et2.getText().toString());
            try{
                int c = x / y;
                Toast.makeText(getApplicationContext(), "Result :"+c, Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "error0", Toast.LENGTH_SHORT).show();
            }
        });

    }
}