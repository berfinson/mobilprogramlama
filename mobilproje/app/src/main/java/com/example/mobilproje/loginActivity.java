package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void onclickGoToMain(View view) {
        EditText EditTextMail = findViewById(R.id.EditTextMail);
        String mail = EditTextMail.getText().toString();
        EditText EditTextSifre = findViewById(R.id.EditTextSifre);
        String sifre = EditTextSifre.getText().toString();


        if (mail.equalsIgnoreCase("tt")&& sifre.equalsIgnoreCase("123")) {
            Intent intent = new Intent(this,anamenuActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Mail adresi yanlış",Toast.LENGTH_LONG).show();
        }
    }
}
