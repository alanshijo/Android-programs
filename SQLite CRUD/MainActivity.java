package exam.sqlite.company;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText id = findViewById(R.id.eid);
        EditText name = findViewById(R.id.ename);
        EditText loc = findViewById(R.id.elocation);
        Button insert = findViewById(R.id.insertbtn);
        Button update = findViewById(R.id.updatebtn);
        Button view = findViewById(R.id.viewbtn);
        Button delete = findViewById(R.id.deletebtn);
        Db_conn dc = new Db_conn(this);
        insert.setOnClickListener(view1 -> {
            String cid = id.getText().toString();
            String cname = name.getText().toString();
            String clocation = loc.getText().toString();
            Boolean b = dc.insertData(cid, cname, clocation);
            if (b == true){
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(view12 -> {
            String cid = id.getText().toString();
            String cname = name.getText().toString();
            String clocation = loc.getText().toString();
            Boolean b = dc.updateData(cid, cname, clocation);
            if (b == true) {
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Updation failed", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(view14 -> {
            Cursor cr = dc.getData();
            if (cr.getCount() == 0){
                Toast.makeText(MainActivity.this, "Data is empty", Toast.LENGTH_SHORT).show();
            }else {
                StringBuffer bf = new StringBuffer();
                while (cr.moveToNext()){
                    bf.append("ID: "+cr.getString(0)+"\n");
                    bf.append("Name: "+cr.getString(1)+"\n");
                    bf.append("Location: "+cr.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Company's data");
                builder.setMessage(bf);
                builder.show();
            }
        });

        delete.setOnClickListener(view13 -> {
            String cid = id.getText().toString();
            Boolean b = dc.deleteData(cid);
            if (b == true){
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Deletion failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}