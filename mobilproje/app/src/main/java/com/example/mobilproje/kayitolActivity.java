
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
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(edtMail.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
        }else {
            if (edtMail.getText().toString().trim().matches(emailPattern)) {
                Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        PrefHelper.getInstance(this).saveString("username",username);
        PrefHelper.getInstance(this).saveString("password",password);
        PrefHelper.getInstance(this).saveString("mail",mail);

            Intent intent = new Intent(this,loginActivity.class);
            startActivity(intent);

    }
}
