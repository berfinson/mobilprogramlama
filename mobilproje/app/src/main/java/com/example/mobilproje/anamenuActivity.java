package com.example.mobilproje;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class anamenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamenu);
    }
    public void onclickGoToIlaclar(View view) {
        setContentView(R.layout.activity_ilacmenusu);

    }
    public void onclickGoToNotlar(View view) {
        setContentView(R.layout.activity_notlar);

    }
}
