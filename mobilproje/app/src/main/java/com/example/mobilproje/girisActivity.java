package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class girisActivity<findView> extends AppCompatActivity {
    EditText EditTextSifre, EditTextMail;
    Button BtnGiris;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
    }

    public void onclickhandler(View view) {
        EditText EditTextMail = findViewById(R.id.EditTextMail);
        String mail = EditTextMail.getText().toString();
        EditText EditTextSifre = findViewById(R.id.EditTextSifre);
        String sifre = EditTextSifre.getText().toString();

    }

    public void onclickGoToIlaclar(View view) {
        Intent intent = new Intent(this, ilacmenusuActivity.class);
        startActivity(intent);

    }
    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this,notlarActivity.class);
        startActivity(intent);;
    }

    public void onclickGoToMain(View view) {
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }

    public void onclickGoToAnaMenu(View view) {
        setContentView(R.layout.activity_anamenu);
    }


    public void onclickGoToUyeOl(View view) {
        setContentView(R.layout.activity_kayitol);
    }
    public void onclickGoToNotEkle(View view)  {
        Intent intent = new Intent(this,notekleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToIlacEkle(View view) {
        Intent intent = new Intent(this,ilacekleActivity.class);
        startActivity(intent);
    }
}
