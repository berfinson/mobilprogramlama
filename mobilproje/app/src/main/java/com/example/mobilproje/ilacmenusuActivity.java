package com.example.mobilproje;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ilacmenusuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacmenusu);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<medicine> medicines = new ArrayList<>();


        medicine med2 = new medicine("Parol", "12.30", "");


        medicines.add(med2);
        AdaptorMedicine adaptorMedicine = new AdaptorMedicine(medicines, this);

        listView.setAdapter(adaptorMedicine);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                medicine med = medicines.get(position);
                Log.e("CLICK", med.name);

            }
        });


    }

    public void clickDeleteItem(View view) {
        medicine medicine = (medicine) view.getTag();
        Log.e("Delete", medicine.name);

    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this, ilacekleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToAnaMenu(View view) {
        Intent intent = new Intent(this, anamenuActivity.class);
        startActivity(intent);
    }
}


