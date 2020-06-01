

package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EczaneListActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczanelist);


        listView = findViewById(R.id.listView);
        context = this;


    }

    public void onclickEczaneEkle(View view) {
        Intent intent = new Intent(this, EczaneEkleActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }
    public class GetAllAsync extends AsyncTask<Void, Void, List<EczaneActivity>> {

        @Override
        protected List<EczaneActivity> doInBackground(Void... voids) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();
            List<EczaneActivity> meds = medDao.getAllEczanes();

            Log.e("MED", String.valueOf(meds.size()));
            return meds;
        }

        @Override
        protected void onPostExecute(final List<EczaneActivity> eczanes) {
            super.onPostExecute(eczanes);

            AdaptorEczane adaptorEczane = new AdaptorEczane(eczanes, context);

            listView.setAdapter(adaptorEczane);

        }
    }

}
