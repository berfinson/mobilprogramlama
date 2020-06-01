
package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kayitolActivity extends AppCompatActivity {
    private String emailRegistration;
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
            showMessage("Mail giriniz");
            return;
        }
        if (!mail.matches(emailPattern)) {
            showMessage("Geçersiz mail adresi");
            return;
        }
        if (username.isEmpty()) {
            showMessage("kullanıcı adı giriniz");
            return;
        }

        prefHelper.saveString("username", username);
        prefHelper.saveString("password", password);
        prefHelper.saveString("mail", mail);


        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);

    }

    public void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
}
