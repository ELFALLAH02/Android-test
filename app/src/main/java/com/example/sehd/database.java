package com.example.sehd;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.text.Selection;


import java.util.ArrayList;

public abstract class database  extends SQLiteOpenHelper {


    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table admin(id integer primary key autoincrement,Username TEXT,email TEXT,pass TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.
    }
    public void addintodatabase(String username,String email,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val =new ContentValues();
        val.put("username" ,username);
        val.put("email" ,email);
        val.put("pass" ,pass);
        db.insert("admin",null,val);
        db.close();

    }
    @SuppressLint("Range")
    public ArrayList<String> read_it()
    {
        SQLiteDatabase bd=this.getReadableDatabase();
        Cursor cur= bd.rawQuery("select * from admin",null);
        ArrayList<String> AL =new ArrayList<String>();
        cur.moveToFirst();
        while(cur.isAfterLast()==false){
            String username,email,pass;
            @SuppressLint("Range") int id = cur.getInt(cur.getColumnIndex("id"));
            username = cur.getString(cur.getColumnIndex("Username"));
            email = cur.getString(cur.getColumnIndex("email"));
            pass = cur.getString(cur.getColumnIndex("pass"));
            AL.add(String.valueOf(id)+"|"+username +"|"+email+"|"+pass);
            cur.moveToNext();

        }

        return AL;
    }
}