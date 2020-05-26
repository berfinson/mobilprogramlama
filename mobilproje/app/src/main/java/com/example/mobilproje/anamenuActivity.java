package com.example.mobilproje;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class anamenuActivity extends AppCompatActivity {

    Context context;
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_anamenu);
        listView = findViewById(R.id.listView);
        GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }

    public void onclickGoToIlaclar(View view) {
        Intent intent = new Intent(this, ilacekleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this, notlarActivity.class);
        startActivity(intent);
    }

    public void onclickGoToIlacEkle(View view) {
        Intent intent = new Intent(this, ilacekleActivity.class);
        startActivity(intent);
    }


    ///ASyn

    public class GetAllAsync extends AsyncTask<Void, Void, List<medicine>> {

        @Override
        protected List<medicine> doInBackground(Void... voids) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();
            List<medicine> meds = medDao.getAllMedicines();

            Log.e("MED", String.valueOf(meds.size()));
            return meds;
        }

        @Override
        protected void onPostExecute(final List<medicine> medicines) {
            super.onPostExecute(medicines);

            AdaptorMedicine adaptorMedicine = new AdaptorMedicine(medicines, context);

            listView.setAdapter(adaptorMedicine);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    medicine med = medicines.get(position);
                    Log.e("CLICK", med.name);

                }
            });
        }
    }



}
