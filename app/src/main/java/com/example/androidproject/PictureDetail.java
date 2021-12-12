package com.example.androidproject;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class PictureDetail extends FragmentActivity {
    private CircleIndicator indicator;
    private ArrayList<Integer> imageList;
    private static final int DP = 24;
    TextView title;
    TextView price;
    TextView year;
    TextView way;
    TextView size;
    TextView info;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_detail);

        title = findViewById(R.id.detailName);
        price = findViewById(R.id.price);
        year = findViewById(R.id.year);
        way = findViewById(R.id.way);
        size = findViewById(R.id.size);
        info = findViewById(R.id.info);

        b1 = findViewById(R.id.buy);
        b2 = findViewById(R.id.addCart);
        this.initializeData();

        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setClipToPadding(false);


        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));
        indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.isLogin) {
                    ContentValues addValues = new ContentValues();
                    addValues.put(MyContentProvider2.USER_ID, MainActivity.ID);
                    addValues.put(MyContentProvider2.Painting, ((TextView) findViewById(R.id.detailName)).getText().toString());
                    addValues.put(MyContentProvider2.Price, ((TextView) findViewById(R.id.price)).getText().toString().replace(",",""));
                    addValues.put(MyContentProvider2.Bought, 1);
                    getContentResolver().insert(MyContentProvider2.CONTENT_URI, addValues);
                    Toast.makeText(getBaseContext(), "구입 완료!", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    intent.putExtra("1",1);
                    startActivity(intent);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.isLogin) {
                    ContentValues addValues = new ContentValues();
                    addValues.put(MyContentProvider2.USER_ID, MainActivity.ID);
                    addValues.put(MyContentProvider2.Painting, ((TextView) findViewById(R.id.detailName)).getText().toString());
                    addValues.put(MyContentProvider2.Price, ((TextView) findViewById(R.id.price)).getText().toString().replace(",",""));
                    addValues.put(MyContentProvider2.Bought, 0);
                    getContentResolver().insert(MyContentProvider2.CONTENT_URI, addValues);
                    Toast.makeText(getBaseContext(), "장바구니에 추가 완료!", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    intent.putExtra("1",1);
                    startActivity(intent);
                }

            }
        });
    }

    public void initializeData()
    {
        Intent intent = getIntent();
        int image1 = intent.getIntExtra("image1",0);
        int image2 = intent.getIntExtra("image2",0);
        String strTitle = intent.getStringExtra("title");
        String strPrice = intent.getStringExtra("price");
        String[] detail = intent.getStringArrayExtra("detail");

        title.setText(strTitle);
        price.setText(strPrice);
        year.setText(detail[0]);
        way.setText(detail[1]);
        size.setText(detail[2]);
        info.setText(detail[3]);
        imageList = new ArrayList();

        imageList.add(image1);
        imageList.add(image2);

    }

}
