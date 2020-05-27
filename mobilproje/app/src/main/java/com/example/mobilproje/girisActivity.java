package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class girisActivity extends AppCompatActivity {
    SharedPreferences preferences;//preferences referansı
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        //TODO check preferences if there is username and password send user to main screen
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());//preferences objesi
        editor = preferences.edit();
        if(preferences.getBoolean("login", false)){
            Intent i = new Intent(getApplicationContext(),anamenuActivity.class);
            startActivity(i);
            finish();
        }



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
