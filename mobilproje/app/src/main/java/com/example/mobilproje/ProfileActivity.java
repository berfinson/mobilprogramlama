package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity<context> extends AppCompatActivity {

    Context context;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_profile);


    }

    public void onclickGuncel(View view) {

        Intent intent = new Intent(this, GuncelleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String username = PrefHelper.getInstance(this).getString("username");
        TextView txtuser = findViewById(R.id.txtuser);
        txtuser.setText(username);

        String username2 = PrefHelper.getInstance(this).getString("username");
        TextView edtuseername = findViewById(R.id.edtuseername);
        edtuseername.setText(username2);

        String mail = PrefHelper.getInstance(this).getString("mail");
        TextView edtmailadress = findViewById(R.id.edtmailadress);
        edtmailadress.setText(mail);
    }
}