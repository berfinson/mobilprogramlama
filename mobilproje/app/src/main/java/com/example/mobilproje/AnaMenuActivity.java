package com.example.mobilproje;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AnaMenuActivity extends AppCompatActivity {

    Context context;
    ListView listView;

    TextView txtusername;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_anamenu);
        listView = findViewById(R.id.listView);
        GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("username", null);
        txtusername = findViewById(R.id.txtusername);
        txtusername.setText(username);

    }

    @Override
    protected void onResume() {
        super.onResume();
        GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }

    public void onclickGoToIlaclar(View view) {
        Intent intent = new Intent(this, IlacEkleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToNotlar(View view) {
        Intent intent = new Intent(this, NotlarActivity.class);
        startActivity(intent);
    }

    public void onclickGoToIlacEkle(View view) {
        Intent intent = new Intent(this, IlacEkleActivity.class);
        startActivity(intent);
    }

    public void onclickGoToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void gotoEczane(View view) {
        Intent intent = new Intent(this, EczaneListActivity.class);
        startActivity(intent);
    }

    public void GoToRun(View view) {

            Intent intent = new Intent(this, RunActivity.class);
            startActivity(intent);


    }


    ///ASyn

    public class GetAllAsync extends AsyncTask<Void, Void, List<Medicine>> {

        @Override
        protected List<Medicine> doInBackground(Void... voids) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();
            List<Medicine> meds = medDao.getAllMedicines();

            Log.e("MED", String.valueOf(meds.size()));
            return meds;
        }

        @Override
        protected void onPostExecute(final List<Medicine> medicines) {
            super.onPostExecute(medicines);

            AdaptorMedicine adaptorMedicine = new AdaptorMedicine(medicines, context);

            listView.setAdapter(adaptorMedicine);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Medicine med = medicines.get(position);
                    Log.e("CLICK", med.name);

                }
            });
        }
    }


}
