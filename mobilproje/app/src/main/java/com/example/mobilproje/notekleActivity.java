package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class notekleActivity extends AppCompatActivity {
    Button kaydet;
    EditText editNote;
    Context context;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notekle);

        editNote = findViewById(R.id.editTextNotEkle);

    }


    public void GoToNotlar(View view) {
        Intent intent = new Intent(this,notlarActivity.class);
        startActivity(intent);

    }


    }

