package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuncelleActivity extends AppCompatActivity {
    PrefHelper prefHelper;

    EditText edtUserName;
    EditText edtMail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);


        prefHelper = PrefHelper.getInstance(this);

        edtUserName = findViewById(R.id.edtUserName);
        edtMail = findViewById(R.id.edtMail);

        String username2 = prefHelper.getString("username");
        String mail = prefHelper.getString("mail");

        edtUserName.setText(username2);
        edtMail.setText(mail);

    }


    public void onclickGuncelle(View view) {


        String name = edtUserName.getText().toString();
        String mail = edtMail.getText().toString();


        prefHelper.saveString("mail", mail);
        prefHelper.saveString("username", name);


        prefHelper.showMessage("Güncelleme tamamlandı");
        finish();


    }

    public void onclickIptal(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }
}
