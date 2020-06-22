package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class LoginActivity extends AppCompatActivity {
    PrefHelper prefHelper;

    EditText EditTextMail;
    EditText EditTextSifre;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        prefHelper = PrefHelper.getInstance(this);

        String mail =  prefHelper.getString("mail");
        String password =   prefHelper.getString("password");

        EditTextMail = findViewById(R.id.EditTextMail);
        EditTextSifre = findViewById(R.id.EditTextSifre);

        EditTextMail.setText(mail);
        EditTextSifre.setText(password);

        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                String token = task.getResult().getToken();

                Log.e("token", token);
               prefHelper.showMessage(token);
            }
        });




    }

    public void onclickGoToMain(View view) {

        String mail = EditTextMail.getText().toString();
        String sifre = EditTextSifre.getText().toString();

        String mailS =  prefHelper.getString("mail");
        String passwordS =  prefHelper.getString("password");
        if (mail.equalsIgnoreCase(mailS)&& sifre.equalsIgnoreCase(passwordS)) {
            Intent intent = new Intent(this, AnaMenuActivity.class);
            startActivity(intent);
        }
        else{
            prefHelper.showMessage("Mailiniz yanlış");
        }

    }

}
