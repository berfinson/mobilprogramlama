package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        String mail =   PrefHelper.getInstance(this).getString("mail");
        String password =   PrefHelper.getInstance(this).getString("password");

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

        String mailS =  PrefHelper.getInstance(this).getString("mail");
        String passwordS =  PrefHelper.getInstance(this).getString("password");
        if (mail.equalsIgnoreCase(mailS)&& sifre.equalsIgnoreCase(passwordS)) {
            Intent intent = new Intent(this, AnaMenuActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Mail adresi yanlış",Toast.LENGTH_LONG).show();
        }
    }
}
