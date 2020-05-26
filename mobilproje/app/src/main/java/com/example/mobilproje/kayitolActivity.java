
package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kayitolActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);
    }

    public void onclickRegister(View view) {
        EditText edtUserName = findViewById(R.id.EditTextUsername);
        EditText edtMail = findViewById(R.id.EditTextMail);
        EditText edtPassword = findViewById(R.id.EditTextPassword);

        String username = edtUserName.getText().toString();
        String mail = edtMail.getText().toString();
        String password = edtPassword.getText().toString();

        //TODO check for validation
        //Give Error message if not validated

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("username",username).apply();
        preferences.edit().putString("password",password).apply();
        preferences.edit().putString("mail",mail).apply();

            Intent intent = new Intent(this,loginActivity.class);
            startActivity(intent);

    }
}
