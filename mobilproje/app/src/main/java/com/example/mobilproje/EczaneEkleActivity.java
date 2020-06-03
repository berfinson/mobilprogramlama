package com.example.mobilproje;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    PrefHelper prefHelper;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczaneekle);

        prefHelper = PrefHelper.getInstance(this);

        BtnKaydet = findViewById(R.id.BtnKaydet);
        editTelefon = findViewById(R.id.editTextTel);
        editName = findViewById(R.id.editTextEczane);
        editAdres = findViewById(R.id.edtAdress);

    }

    public void clickAddEczane(View view) {


        String name = editName.getText().toString();
        String telefon = editTelefon.getText().toString();
        String adres = editAdres.getText().toString();

        Eczane eczane = new Eczane(name,telefon,adres);
        AddAllAsync addAllAsync = new AddAllAsync();
        List<Eczane> list = new ArrayList<>();
        list.add(eczane);
        addAllAsync.execute(list);

        prefHelper.showMessage("yeni eczane eklendi");
        finish();

    }

    public  class  AddAllAsync extends AsyncTask<List<Eczane>,Void,List<Long>> {

        @Override
        protected List<Long> doInBackground(List<Eczane>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<Eczane> newList = new ArrayList<>(lists[0]);


            List<Long> res =  medDao.insertEczanes(newList.toArray(new Eczane[0]));
            return res;
        }
    }


}
