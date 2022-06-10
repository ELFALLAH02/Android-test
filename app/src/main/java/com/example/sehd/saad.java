package com.example.sehd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class saad  extends SQLiteOpenHelper {
    public saad(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase saad1) {
        saad1.execSQL("Create table saad2(idsaad integer primary key Autoincrement,lable_name TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  void add_element(String lab){
        SQLiteDatabase dB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("liable_name", lab);
        dB.insert("saad2",null,cv);
        dB.close();

    }

}
