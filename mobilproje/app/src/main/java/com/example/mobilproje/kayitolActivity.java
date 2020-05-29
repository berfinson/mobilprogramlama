
package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

  ///      if (!emailRegistration.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
  ///          edtMail.setError("Invalid Email Address");

  ///      }

        PrefHelper.getInstance(this).saveString("username",username);
        PrefHelper.getInstance(this).saveString("password",password);
        PrefHelper.getInstance(this).saveString("mail",mail);

            Intent intent = new Intent(this,loginActivity.class);
            startActivity(intent);

    }
}
