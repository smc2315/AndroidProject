package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static Boolean isLogin = false;
    public static String ID = "";

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentShop fragmentShop = new FragmentShop();
    private FragmentMyPage fragmentMyPage = new FragmentMyPage();
    private FragmentMyPageNotLogin fragmentMyPageNotLogin = new FragmentMyPageNotLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new MainActivity.ItemSelectedListener());
    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.main:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

                    break;
                case R.id.shopItem:
                    transaction.replace(R.id.frameLayout, fragmentShop).commitAllowingStateLoss();

                    break;
                case R.id.mypageItem:
                    if(!isLogin){
                        transaction.replace(R.id.frameLayout, fragmentMyPageNotLogin).commitAllowingStateLoss();
                    }
                    else {
                        transaction.replace(R.id.frameLayout, fragmentMyPage).commitAllowingStateLoss();
                    }
                    break;

            }
            return true;
        }
    }
}