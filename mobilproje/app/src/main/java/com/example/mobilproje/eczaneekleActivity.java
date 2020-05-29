package com.example.mobilproje;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class eczaneekleActivity extends AppCompatActivity {
    Button kaydet;
    EditText editKaydet;
    Context context;
    TextView txtTelefon;
    EditText editName;
    EditText editAdres;

    @SuppressLint("WrongViewCast")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczaneekle);

        editKaydet = findViewById(R.id.edtKaydet);
    }
/*
    public void clickAddEczane(View view) {


        String name = editName.getText().toString();
        String telefon = txtTelefon.getText().toString();
        String adres = editAdres.getText().toString();

        eczane eczane = new eczane(name,telefon,adres);
        AddAllAsync addAllAsync = new AddAllAsync();
        List<eczane> list = new ArrayList<>();
        list.add(eczane);
        addAllAsync.execute(list);

        Toast.makeText(this,"Yeni ilaç Eklendi", Toast.LENGTH_LONG).show();
        finish();

    }

 */
  /*  public  class  AddAllAsync extends AsyncTask<List<eczane>,Void,List<Long>> {

        @Override
        protected List<Long> doInBackground(List<eczane>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<eczane> newList = new ArrayList<>(lists[0]);


            List<Long> res =  medDao.insertEczanes(newList.toArray(new eczane[0]));
            return res;
        }
    } */


}
