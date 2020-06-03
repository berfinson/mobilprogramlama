package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GirisActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    PrefHelper prefHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        prefHelper = PrefHelper.getInstance(this);
        
        String mail = prefHelper.getString("mail");


        if(mail != null){
            Intent i = new Intent(getApplicationContext(), AnaMenuActivity.class);
            startActivity(i);
            finish();
        }




    }
    public void onclickGoToUyeOl(View view) {
        Intent intent = new Intent(this, KayitOlActivity.class);
        startActivity(intent);
    }

    public void onclickGotoLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
