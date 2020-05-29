package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuncelleActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);
    }

    public void onclickGuncelle(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username3 = preferences.getString("username",null);
        TextView newusername = findViewById(R.id.newUsername);
        newusername.setText(username3);


    }

    public void onclickIptal(View view) {
        Intent intent = new Intent(this,profileActivity.class);
        startActivity(intent);

    }
}
