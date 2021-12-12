package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper {
    static final String USER_DB = "Users.db";
    static final String USER_TABLE = "Users";
    Context context = null;
    private static UserDB dbManager = null;
    static final String CREATE_DB = " CREATE TABLE " + USER_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " user_id TEXT NOT NULL, password TEXT NOT NULL,phone_number TEXT, painting TEXT, price INTEGER, bought INTEGER);";
    public static UserDB getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new UserDB(context, USER_DB, null, 1);
        }
        return dbManager;
    }
    public UserDB(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        this.context = context;
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int
            newV) {
    }
    public long insert(ContentValues addValue) {
        return getWritableDatabase().insert(USER_TABLE, null, addValue);
    }
    public Cursor query(String [] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return getReadableDatabase().query(USER_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
    public int delete(String whereClause, String[] whereArgs) {
        return getWritableDatabase().delete(USER_TABLE, whereClause, whereArgs);
    }
}





