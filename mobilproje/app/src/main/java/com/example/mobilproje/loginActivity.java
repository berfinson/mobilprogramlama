package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mail = preferences.getString("mail","s");
        String password = preferences.getString("password","s");

        EditText EditTextMail = findViewById(R.id.EditTextMail);

        EditText EditTextSifre = findViewById(R.id.EditTextSifre);

        EditTextMail.setText(mail);
        EditTextSifre.setText(password);
        Log.e("MED",mail);
        Log.e("MED",password);


    }

    public void onclickGoToMain(View view) {
        EditText EditTextMail = findViewById(R.id.EditTextMail);
        String mail = EditTextMail.getText().toString();
        EditText EditTextSifre = findViewById(R.id.EditTextSifre);
        String sifre = EditTextSifre.getText().toString();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mailS = preferences.getString("mail","s");
        String passwordS = preferences.getString("password","s");
        if (mail.equalsIgnoreCase(mailS)&& sifre.equalsIgnoreCase(passwordS)) {
            Intent intent = new Intent(this,anamenuActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Mail adresi yanlış",Toast.LENGTH_LONG).show();
        }
    }
}
