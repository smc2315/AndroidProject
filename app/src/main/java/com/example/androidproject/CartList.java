package com.example.androidproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartList extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    Button b1, b2;
    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);


        ArrayList<Picture> boughtInfo = new ArrayList<>();

        String[] columns = new String[]{"user_id", "painting", "price", "bought"};

        Cursor c = getContentResolver().query(MyContentProvider2.CONTENT_URI, columns, null, null, null, null);
        while (c.moveToNext()) {
            if (MainActivity.ID.equals(c.getString(0)) && c.getInt(3) == 0) {
                boughtInfo.add(new Picture(c.getString(1), c.getInt(2)));
            }
        }

        BoughtAdapter myAdapter = new BoughtAdapter(boughtInfo);
        myRecyclerView.setAdapter(myAdapter);

        b1 = findViewById(R.id.buyFromCart);
        b2 = findViewById(R.id.resetCart);
        total = findViewById(R.id.total);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = getContentResolver().query(MyContentProvider2.CONTENT_URI, columns, null, null, null, null);
                while (c.moveToNext()) {
                    if (MainActivity.ID.equals(c.getString(0)) && c.getInt(3) == 0) {
                        ContentValues addValues = new ContentValues();
                        addValues.put(MyContentProvider2.USER_ID, c.getString(0));
                        addValues.put(MyContentProvider2.Painting, c.getString(1));
                        addValues.put(MyContentProvider2.Price, c.getInt(2));
                        addValues.put(MyContentProvider2.Bought, 1);
                        getContentResolver().insert(MyContentProvider2.CONTENT_URI, addValues);


                    }

                }
                getContentResolver().delete(MyContentProvider2.CONTENT_URI, MyContentProvider2.Bought + "=" + 0, null);
                Toast.makeText(getBaseContext(), "구매 완료!", Toast.LENGTH_LONG).show();
                total.setText(0+"원");
                myRecyclerView.removeAllViewsInLayout();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContentResolver().delete(MyContentProvider2.CONTENT_URI, MyContentProvider2.Bought + "=" + 0, null);
                myRecyclerView.removeAllViewsInLayout();
                total.setText(0+"원");
            }
        });
        int sum = 0;
        Cursor c2 = getContentResolver().query(MyContentProvider2.CONTENT_URI, columns, null, null, null, null);
        while (c2.moveToNext()) {

            if (MainActivity.ID.equals(c2.getString(0)) && c2.getInt(3) == 0) {

                sum += Integer.parseInt((c2.getString(2).substring(0,c2.getString(2).length()-2)));


            }


        }
        total.setText(sum+"원");
    }
}