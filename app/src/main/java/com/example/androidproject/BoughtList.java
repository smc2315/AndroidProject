package com.example.androidproject;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BoughtList extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bought_list);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);


        ArrayList<Picture> boughtInfo = new ArrayList<>();

        String[] columns = new String[]{"user_id", "painting","price","bought"};

        Cursor c = getContentResolver().query(MyContentProvider2.CONTENT_URI, columns, null, null, null, null);
        while(c.moveToNext()){
            if(MainActivity.ID.equals(c.getString(0))&&c.getInt(3)==1)
            {
                boughtInfo.add(new Picture(c.getString(1),c.getInt(2)));
            }
        }

        BoughtAdapter myAdapter = new BoughtAdapter(boughtInfo);
        myRecyclerView.setAdapter(myAdapter);

    }
}
