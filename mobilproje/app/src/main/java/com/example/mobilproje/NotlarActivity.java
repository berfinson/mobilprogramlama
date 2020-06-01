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

public class NotlarActivity extends AppCompatActivity {
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

        Intent intent = new Intent(this, NotEkleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
      GetAllAsync getAllAsync = new GetAllAsync();
        getAllAsync.execute();
    }


    public class GetAllAsync extends AsyncTask<Void, Void, List<NotActivity>> {

        @Override
        protected List<NotActivity> doInBackground(Void... voids) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();
            List<NotActivity> meds = medDao.getAllNotes();

            Log.e("MED", String.valueOf(meds.size()));
            return meds;
        }

        @Override
        protected void onPostExecute(final List<NotActivity> notes) {
            super.onPostExecute(notes);

            AdaptorNote adaptorMedicine = new AdaptorNote(notes, context);

            listView.setAdapter(adaptorMedicine);

        }
    }

}
