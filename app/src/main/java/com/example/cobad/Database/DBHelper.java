package com.example.cobad.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE userIMT(name TEXT PRIMARY KEY , BirthDate TEXT, IMT TEXT,Status TEXT,Gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists userIMT");
//        onCreate(DB);
    }

    //input user
    public boolean insertuserdata(String name,String BirthDate, Integer IMT, String Status,String Gender){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("BirthDate",BirthDate);
        contentValues.put("IMT",IMT);
        contentValues.put("Status",Status);
        contentValues.put("Gender",Gender);

        long result=DB.insert("UserIMT", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from UserIMT where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("UserIMT", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from UserIMT", null);
        return cursor;

    }
}
