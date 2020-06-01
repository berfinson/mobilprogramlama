package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuncelleActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);
    }

    public void onclickGuncelle(View view) {

        String username2 = PrefHelper.getInstance(this).getString("username");
        TextView edtuseername = findViewById(R.id.edtuseername);
        edtuseername.setText(username2);


        EditText edtusername = findViewById(R.id.newUsername);
        EditText edtmail = findViewById(R.id.newMail);

        String name = edtusername.getText().toString();
        String mail = edtmail.getText().toString();

        if(name.equalsIgnoreCase(username2)){

        }
        else{
            edtuseername.setText(name);
        }


    }

    public void onclickIptal(View view) {
        Intent intent = new Intent(this,profileActivity.class);
        startActivity(intent);

    }
}
