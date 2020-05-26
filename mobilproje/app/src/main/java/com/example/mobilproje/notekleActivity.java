package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class notekleActivity extends AppCompatActivity {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notekle);
    }

    public void onclickGoToAnaMenu(View view) {
        Intent intent = new Intent(this,anamenuActivity.class);
        startActivity(intent);
    }
}
