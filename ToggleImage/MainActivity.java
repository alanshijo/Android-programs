package my.android.frame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView first = findViewById(R.id.ios);
        ImageView second = findViewById(R.id.android);
        first.setOnClickListener(view -> {
            second.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);
        });
        second.setOnClickListener(view -> {
            first.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);
        });
    }
}