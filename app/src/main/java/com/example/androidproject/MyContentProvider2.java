package com.example.androidproject;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider2 extends ContentProvider {
    static final String PROVIDER_NAME ="com.example.androidproject.MyContentProvider2";
    static final String URL = "content://" + PROVIDER_NAME + "/cart";
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String USER_ID = "user_id";
    static final String Painting = "painting";
    static final String Price = "price";
    static final String Bought = "bought";
    public CartDB dbManager2;
    public MyContentProvider2() {
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return dbManager2.delete(selection, selectionArgs);
    }
    @Override
    public String getType(Uri uri) {
        return null;
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowid = dbManager2.insert(values);
        return null;
    }
    @Override
    public boolean onCreate() {
        dbManager2 = CartDB.getInstance(getContext());
        return true;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return dbManager2.query(projection, selection, selectionArgs, null, null, sortOrder);
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
