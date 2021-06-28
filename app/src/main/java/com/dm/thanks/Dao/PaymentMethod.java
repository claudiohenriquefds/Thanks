package com.dm.thanks.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaymentMethod extends SQLiteOpenHelper {
    public PaymentMethod(Context context){
        super(context, "PaymentMethod", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE IF NOT EXISTS payment_methods (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "type INTEGER NOT NULL," +
                "reference TEXT NOT NULL UNIQUE," +
                "user_id INTEGER NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
