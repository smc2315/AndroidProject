package com.example.androidproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    ImageView phone;
    ImageView email;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getFragmentManager().beginTransaction().replace(R.id.mainFragment, mainFragment, "main").commit();
        }
        phone = rootView.findViewById(R.id.phone);
        email = rootView.findViewById(R.id.email);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01049023485"));
                startActivity(intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });


        return rootView;

    }

    protected void sendEmail() {
        String[] TO = {"smc2315@naver.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "이메일");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "내용");
        try {
            startActivity(Intent.createChooser(emailIntent,
                    "이메일 보내기..."));

    } catch (android.content.ActivityNotFoundException ex) {

        }
    }
}
