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

    PrefHelper prefHelper;

    TextView txtuser;
    TextView edtuseername;
    TextView edtmailadress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_profile);

        prefHelper = PrefHelper.getInstance(this);
    }

    public void onclickGuncel(View view) {

        Intent intent = new Intent(this, GuncelleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String username = prefHelper.getString("username");
        txtuser = findViewById(R.id.txtuser);
        txtuser.setText(username);

        String username2 = prefHelper.getString("username");
        edtuseername = findViewById(R.id.edtuseername);
        edtuseername.setText(username2);

        String mail = prefHelper.getString("mail");
        edtmailadress = findViewById(R.id.edtmailadress);
        edtmailadress.setText(mail);
    }
}