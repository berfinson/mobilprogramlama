package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class GirisActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    PrefHelper prefHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        prefHelper = PrefHelper.getInstance(this);
        
        String mail = prefHelper.getString("mail");

        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                try{
                String token = task.getResult().getToken();

                Log.e("token", token);
                prefHelper.showMessage(token);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        if(mail != null){
            Intent i = new Intent(getApplicationContext(), AnaMenuActivity.class);
            startActivity(i);
            finish();
        }




    }
    public void onclickGoToUyeOl(View view) {
        Intent intent = new Intent(this, KayitOlActivity.class);
        startActivity(intent);
    }

    public void onclickGotoLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
