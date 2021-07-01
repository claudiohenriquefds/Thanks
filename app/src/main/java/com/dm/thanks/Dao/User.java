package com.dm.thanks.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User extends SQLiteOpenHelper {

    public User(Context context){
        super(context, "User", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL UNIQUE," +
                "password TEXT NOT NULL," +
                "level_access INTEGER NOT NULL DEFAULT 1)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS users";
        db.execSQL(sql);
    }

    public Boolean checkEmailExists(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ?", new String[]{email});
        if(cursor.getCount() > 0){
            return true;
        }

        return false;
    }

    public Boolean checkUserPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
        if(cursor.getCount() > 0){
            return true;
        }

        return false;
    }

    public Boolean add(String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);

        if(result == -1){
            return false;
        }

        return true;
    }

    public com.dm.thanks.Model.User get(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
        cursor.moveToFirst();
        return new com.dm.thanks.Model.User(
                cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("name")),
                cursor.getString(cursor.getColumnIndex("email")),
                cursor.getInt(cursor.getColumnIndex("level_access"))
        );
    }

    public void createAdmin(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id from users where email = ? and password = ?", new String[]{"admin@thanks.com", "admin123"});
        if(cursor.getCount() <= 0){
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "Admin");
            contentValues.put("email", "admin@thanks.com");
            contentValues.put("password", "admin");
            contentValues.put("level_access", 2);
            db.insert("users", null, contentValues);
        }
    }
}
