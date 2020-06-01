package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class IlacMenusuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacmenusu);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<Medicine> medicines = new ArrayList<>();


        Medicine med2 = new Medicine("Parol", "12.30", "");


        medicines.add(med2);
        AdaptorMedicine adaptorMedicine = new AdaptorMedicine(medicines, this);

        listView.setAdapter(adaptorMedicine);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Medicine med = medicines.get(position);
                Log.e("CLICK", med.name);

            }
        });


    }

    public void clickDeleteItem(View view) {
        Medicine medicine = (Medicine) view.getTag();
        Log.e("Delete", medicine.name);

    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this, IlacEkleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToAnaMenu(View view) {
        Intent intent = new Intent(this, AnaMenuActivity.class);
        startActivity(intent);
    }
}


