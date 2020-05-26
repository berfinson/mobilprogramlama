package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class girisActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        //TODO check preferences if there is username and password send user to main screen

    }
    public void onclickGoToUyeOl(View view) {
        Intent intent = new Intent(this,kayitolActivity.class);
        startActivity(intent);
    }

    public void onclickGotoLogin(View view) {
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
}
