package com.example.androidproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    Button b1,b2,b3;
    EditText idText,pass1,pass2,phone;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        final Boolean[] allChecked = {false};
        b1 = findViewById(R.id.check_id);
        b2 = findViewById(R.id.signup_signup);
        b3 = findViewById(R.id.cancel);
        idText = findViewById(R.id.signup_id);
        pass1 = findViewById(R.id.signup_password);
        pass2 = findViewById(R.id.signup_password_check);
        phone = findViewById(R.id.signup_phone);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkId(idText.getText().toString())){
                    Toast.makeText(getBaseContext(), "ID available", Toast.LENGTH_LONG).show();
                    allChecked[0] = true;
                }
                else {
                    Toast.makeText(getBaseContext(), "Unavailable ID", Toast.LENGTH_LONG).show();

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(idText.getText())) {
                    Toast.makeText(getBaseContext(), "Insert your ID!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass1.getText()) || TextUtils.isEmpty(pass2.getText())) {
                    Toast.makeText(getBaseContext(), "Insert your password!", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(phone.getText())) {
                    Toast.makeText(getBaseContext(), "Insert your phone number!", Toast.LENGTH_LONG).show();
                } else {
                    if (checkPassword(pass1.getText().toString(), pass2.getText().toString()) && allChecked[0]) {
                        Toast.makeText(getBaseContext(), "Sign up complete!", Toast.LENGTH_LONG).show();
                        addUser(v);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else if (!allChecked[0]) {
                        Toast.makeText(getBaseContext(), "check your ID!", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getBaseContext(), "check your password", Toast.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addUser(View view){
        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.USER_ID, ((EditText)findViewById(R.id.signup_id)).getText().toString());
        addValues.put(MyContentProvider.Password, ((EditText)findViewById(R.id.signup_password)).getText().toString());
        addValues.put(MyContentProvider.Phone, ((EditText)findViewById(R.id.signup_phone)).getText().toString());
        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(), "Sign up successful", Toast.LENGTH_LONG).show();
    }
    public Boolean checkId(String id){
        String[] columns = new String[]{"_id", "user_id", "password","phone_number"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);
        Boolean check = false;
        while(c.moveToNext()){
                String checkId = c.getString(1);
                if(checkId.equals(id)){
                    check = true;
                    break;
                }
            }
        return !check;

    }
    public Boolean checkPassword(String pwd1, String pwd2){
        return pwd1.equals(pwd2);
    }


}
