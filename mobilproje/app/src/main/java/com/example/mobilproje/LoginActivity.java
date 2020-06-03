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
    PrefHelper prefHelper;

    EditText EditTextMail;
    EditText EditTextSifre;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        prefHelper = PrefHelper.getInstance(this);

        String mail =  prefHelper.getString("mail");
        String password =   prefHelper.getString("password");

        EditTextMail = findViewById(R.id.EditTextMail);
        EditTextSifre = findViewById(R.id.EditTextSifre);

        EditTextMail.setText(mail);
        EditTextSifre.setText(password);
        Log.e("MED",mail);
        Log.e("MED",password);

    }

    public void onclickGoToMain(View view) {

        String mail = EditTextMail.getText().toString();
        String sifre = EditTextSifre.getText().toString();

        String mailS =  prefHelper.getString("mail");
        String passwordS =  prefHelper.getString("password");
        if (mail.equalsIgnoreCase(mailS)&& sifre.equalsIgnoreCase(passwordS)) {
            Intent intent = new Intent(this, AnaMenuActivity.class);
            startActivity(intent);
        }
        else{
            prefHelper.showMessage("Mailiniz yanlış");
        }
    }
}
