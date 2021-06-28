package com.dm.thanks.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Transaction extends SQLiteOpenHelper {
    public Transaction(Context context){
        super(context, "Transaction", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE IF NOT EXISTS transactions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "value DOUBLE NOT NULL," +
                "status INTEGER NOT NULL," +
                "user_id TEXT NOT NULL," +
                "solicitation_id INTEGER NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE," +
                "FOREIGN KEY (solicitation_id) REFERENCES solicitations (id) ON DELETE CASCADE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
