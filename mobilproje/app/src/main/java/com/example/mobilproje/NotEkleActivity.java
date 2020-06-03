package com.example.mobilproje;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        Note note = new Note(editNote.getText().toString());

        AddAllAsync addAllAsync = new AddAllAsync();
        List<Note> list = new ArrayList<>();
        list.add(note);
        addAllAsync.execute(list);

        prefHelper.showMessage("Yeni Not Eklendi");
        finish();


    }


    private class AddAllAsync extends AsyncTask<List<Note>, Void, List<Long>> {

        @Override
        protected List<Long> doInBackground(List<Note>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<Note> newList = new ArrayList<>(lists[0]);


            List<Long> res = medDao.insertNotes(newList.toArray(new Note[0]));
            return res;
        }
    }


}

