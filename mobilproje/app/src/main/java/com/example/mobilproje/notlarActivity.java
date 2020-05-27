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

public class notlarActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);

         listView = findViewById(R.id.listView);
         context = this;




    }
    public void onclickGoToNotEkle(View view)  {

        Intent intent = new Intent(this,notekleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
      GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }


    public class GetAllAsync extends AsyncTask<Void, Void, List<note>> {

        @Override
        protected List<note> doInBackground(Void... voids) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();
            List<note> meds = medDao.getAllNotes();

            Log.e("MED", String.valueOf(meds.size()));
            return meds;
        }

        @Override
        protected void onPostExecute(final List<note> notes) {
            super.onPostExecute(notes);

            AdaptorNote adaptorMedicine = new AdaptorNote(notes, context);

            listView.setAdapter(adaptorMedicine);

        }
    }

}
