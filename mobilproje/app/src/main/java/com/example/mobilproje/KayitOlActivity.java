
package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KayitOlActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtMail;
    EditText edtPassword;

    PrefHelper prefHelper;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        edtUserName = findViewById(R.id.EditTextUsername);
        edtMail = findViewById(R.id.EditTextMail);
        edtPassword = findViewById(R.id.EditTextPassword);

        prefHelper = PrefHelper.getInstance(this);
    }

    public void onclickRegister(View view) {


        String username = edtUserName.getText().toString();
        String mail = edtMail.getText().toString().trim();
        String password = edtPassword.getText().toString();

        //TODO check for validation
        //Give Error message if not validated
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (mail.isEmpty()) {
            prefHelper.showMessage("Mail giriniz");
            return;
        }
        if (!mail.matches(emailPattern)) {
            prefHelper.showMessage("Geçersiz mail adresi");
            return;
        }
        if (username.isEmpty()) {
            prefHelper.showMessage("kullanıcı adı giriniz");
            return;
        }

        prefHelper.saveString("username", username);
        prefHelper.saveString("password", password);
        prefHelper.saveString("mail", mail);


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }


}
