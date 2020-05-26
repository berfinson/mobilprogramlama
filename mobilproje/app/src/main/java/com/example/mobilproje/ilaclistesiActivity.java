package com.example.mobilproje;

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


public class ilaclistesiActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacmenusu);
        LinearLayout panel = findViewById(R.id.listpanel);
        for (int i=0;i<50;i++){

        TextView txt = new TextView(this);
        txt.setText("ilac"+i);
        panel.addView(txt);}

        ListView listView = findViewById(R.id.listView);
        final ArrayList<medicine> medicines = new ArrayList<>();

         medicine med1 = new medicine();
         med1.setName("Novalgin");


         medicine med2 = new medicine("Parol", "12.30", "");

            medicines.add(med1);
            medicines.add(med2);
            AdaptorMedicine adaptorMedicine = new AdaptorMedicine(medicines, this);

            listView.setAdapter(adaptorMedicine);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    medicine med = medicines.get(position);
                    Log.e("CLICK", med.getName());

                }
            });


        }

        public void clickDeleteItem(View view) {
            medicine medicine = (medicine) view.getTag();
            Log.e("Delete", medicine.getName());

        }
    }


