package com.example.mobilproje;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class NotEkleActivity extends AppCompatActivity {
    Button kaydet;
    EditText editNote;
    Context context;

    PrefHelper prefHelper;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notekle);

        prefHelper = PrefHelper.getInstance(this);

        editNote = findViewById(R.id.editTextNotEkle);

    }


    public void GoToNotlar(View view) {

        NotActivity note = new NotActivity(editNote.getText().toString());

        AddAllAsync addAllAsync = new AddAllAsync();
        List<NotActivity> list = new ArrayList<>();
        list.add(note);
        addAllAsync.execute(list);

        prefHelper.showMessage("Yeni Not Eklendi");
        finish();


    }


    private class AddAllAsync extends AsyncTask<List<NotActivity>, Void, List<Long>> {

        @Override
        protected List<Long> doInBackground(List<NotActivity>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<NotActivity> newList = new ArrayList<>(lists[0]);


            List<Long> res = medDao.insertNotes(newList.toArray(new NotActivity[0]));
            return res;
        }
    }


}

