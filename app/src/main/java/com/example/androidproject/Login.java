package com.example.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Login extends AppCompatActivity {
    Button b1,b2;
    EditText id, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        b1 = findViewById(R.id.signup);
        b2 = findViewById(R.id.login);
        id = findViewById(R.id.main_id);
        pwd = findViewById(R.id.main_password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginCheck(id.getText().toString(),pwd.getText().toString())){
                    Toast.makeText(getBaseContext(),"Login Success! Welcome "+id.getText().toString(),Toast.LENGTH_LONG).show();
                    MainActivity.isLogin =true;
                    MainActivity.ID = id.getText().toString();
                    Intent intent = getIntent();
                    if(intent.getIntExtra("1",0) ==1)
                        finish();
                    else{
                        Intent main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(main);
                    }

                }
                else{
                    Toast.makeText(getBaseContext(),"Check your ID or password!",Toast.LENGTH_LONG).show();
                    id.setText("");
                    id.setHint("ID");
                    pwd.setText("");
                    pwd.setHint("password");
                }
            }
        });


    }
    public Boolean loginCheck(String cid,String cpwd){
        String[] columns = new String[]{"_id", "user_id", "password","phone_number"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);
        Boolean idCheck = false;
        Boolean pwdCheck = false;
        while(c.moveToNext()){
            String checkId = c.getString(1);
            String checkPwd = c.getString(2);
            if(checkId.equals(cid)){
                idCheck = true;
            }
            if(checkPwd.equals(cpwd)){
                pwdCheck = true;
            }
        }
        if(idCheck&&pwdCheck)
            return true;
        else
            return false;
    }
}