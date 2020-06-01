package com.example.mobilproje;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EczaneEkleActivity extends AppCompatActivity {
    Button BtnKaydet;
    EditText editKaydet;
    Context context;
    EditText editTelefon;
    EditText editName;
    EditText editAdres;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczaneekle);

        BtnKaydet = findViewById(R.id.BtnKaydet);
        editTelefon = findViewById(R.id.editTextTel);
        editName = findViewById(R.id.editTextEczane);
        editAdres = findViewById(R.id.edtAdress);

    }

    public void clickAddEczane(View view) {


        String name = editName.getText().toString();
        String telefon = editTelefon.getText().toString();
        String adres = editAdres.getText().toString();

        EczaneActivity eczane = new EczaneActivity(name,telefon,adres);
        AddAllAsync addAllAsync = new AddAllAsync();
        List<EczaneActivity> list = new ArrayList<>();
        list.add(eczane);
        addAllAsync.execute(list);

        Toast.makeText(this,"Yeni Eczane Eklendi", Toast.LENGTH_LONG).show();
        finish();

    }

    public  class  AddAllAsync extends AsyncTask<List<EczaneActivity>,Void,List<Long>> {

        @Override
        protected List<Long> doInBackground(List<EczaneActivity>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<EczaneActivity> newList = new ArrayList<>(lists[0]);


            List<Long> res =  medDao.insertEczanes(newList.toArray(new EczaneActivity[0]));
            return res;
        }
    }


}
