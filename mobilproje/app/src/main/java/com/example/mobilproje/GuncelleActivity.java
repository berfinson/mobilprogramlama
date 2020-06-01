package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuncelleActivity extends AppCompatActivity {
    PrefHelper prefHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);


        String username2 = prefHelper.getString("username");
        String mail = prefHelper.getString("mail");
        EditText newUsername = findViewById(R.id.newUsername);
        newUsername.setText(username2);


        EditText edtmail = findViewById(R.id.newMail);
        edtmail.setText(mail);

    }




    public void onclickGuncelle(View view) {
        EditText newUsername = findViewById(R.id.newUsername);
        EditText edtmail = findViewById(R.id.newMail);


        String name = newUsername.getText().toString();
        String mail = edtmail.getText().toString();

        prefHelper.saveString("mail",mail);
        prefHelper.saveString("username",name);

        Toast.makeText(this,"Verileriniz Güncellendi",Toast.LENGTH_LONG).show();
        finish();



    }

    public void onclickIptal(View view) {
        Intent intent = new Intent(this,profileActivity.class);
        startActivity(intent);

    }
}
