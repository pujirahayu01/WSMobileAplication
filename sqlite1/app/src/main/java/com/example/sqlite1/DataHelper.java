package com.example.sqlite1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;


    public DataHelper(Context context) {
        super(context,DATABASE_NAME, null ,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table biodata(no integer primary key, nama text null,tgl text null, jk text null, alamat text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (no,nama,tgl,jk,alamat) VALUES ('1','Puji Rahayu','2001-06-17', 'Perempuan','Jember');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int arg2) {

    }


}
