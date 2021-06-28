package com.dm.thanks.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Solicitation extends SQLiteOpenHelper {
    public Solicitation(Context context){
        super(context, "Solicitation", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE IF NOT EXISTS solicitations (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT NOT NULL," +
                "subtitle TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "objective DOUBLE NOT NULL," +
                "reached DOUBLE NOT NULL," +
                "payment_method_id INTEGER NOT NULL," +
                "FOREIGN KEY (payment_method_id) REFERENCES payment_methods (id) ON DELETE CASCADE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
