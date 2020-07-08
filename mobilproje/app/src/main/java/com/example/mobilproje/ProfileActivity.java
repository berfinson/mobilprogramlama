package com.example.mobilproje;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.BitSet;

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

    public void onclickGoToIlaclar(View view) {
        Intent intent = new Intent(this, IlacEkleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this, NotEkleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToBack(View view) {
        finish();
    }

    public void onclickExit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Çıkış Yapmak İstiyor Musunuz?")
                .setCancelable(false)
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }

    public void GoToRun(View view) {
        Intent intent = new Intent(this, RunActivity.class);
        startActivity(intent);
    }
}