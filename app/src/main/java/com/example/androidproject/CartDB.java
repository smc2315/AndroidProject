package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CartDB extends SQLiteOpenHelper {
    static final String CART_DB = "cart.db";
    static final String CART_TABLE = "Cart";
    Context context = null;
    private static CartDB dbManager = null;
    static final String CREATE_DB = " CREATE TABLE " + CART_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " user_id TEXT NOT NULL, painting TEXT, price INTEGER, bought INTEGER);";
    public static CartDB getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new CartDB(context, CART_DB, null, 1);
        }
        return dbManager;
    }
    public CartDB(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
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
        return getWritableDatabase().insert(CART_TABLE, null, addValue);
    }
    public Cursor query(String [] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return getReadableDatabase().query(CART_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
    public int delete(String whereClause, String[] whereArgs) {
        return getWritableDatabase().delete(CART_TABLE, whereClause, whereArgs);
    }
}





