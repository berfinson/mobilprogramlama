package com.example.mobilproje;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class anamenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamenu);
        //Metin İlhan test
    }

    public void onclickGoToIlaclar(View view) {
        Intent intent = new Intent(this, ilacmenusuActivity.class);
        startActivity(intent);
    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this,notlarActivity.class);
        startActivity(intent);
    }

    public void onclickGoToIlacEkle(View view) {
        Intent intent = new Intent(this,ilacekleActivity.class);
        startActivity(intent);
    }
}
