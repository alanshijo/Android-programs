package exam.sqlite.company;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db_conn extends SQLiteOpenHelper {
    public Db_conn(@Nullable Context context) {
        super(context, "db_company", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tbl_data(cid text primary key, cname text, clocation text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tbl_data");
    }
    public Boolean insertData(String cid, String cname, String clocation){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("cid", cid);
        cv.put("cname", cname);
        cv.put("clocation", clocation);
        long result = db.insert("tbl_data", null, cv);
        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateData(String cid, String cname, String clocation){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cname", cname);
        cv.put("clocation", clocation);
        Cursor cr = db.rawQuery("select * from tbl_data where cid=?", new String[]{cid});
        if (cr.getCount() > 0) {
            long result = db.update("tbl_data", cv, "cid=?", new String[]{cid});
            if (result == -1) {
                return false;
            }else{
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from tbl_data", null);
        return cr;
    }

    public Boolean deleteData(String cid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cid", cid);
        Cursor cr = db.rawQuery("select * from tbl_data where cid=?", new String[]{cid});
        if (cr.getCount() > 0){
            long result = db.delete("tbl_data", "cid=?", new String[]{cid});
            if (result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}
