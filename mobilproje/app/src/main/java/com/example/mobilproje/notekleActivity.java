package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
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

public class notekleActivity extends AppCompatActivity {
    Button kaydet;
    EditText editNote;
    Context context;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notekle);

        editNote = findViewById(R.id.editTextNotEkle);

    }


    public void GoToNotlar(View view) {

        note note = new note(editNote.getText().toString());

        AddAllAsync addAllAsync = new AddAllAsync();
        List<note> list = new ArrayList<>();
        list.add(note);
        addAllAsync.execute(list);

        Toast.makeText(this, "Yeni Not Eklendi", Toast.LENGTH_LONG).show();
        finish();


    }


    private class AddAllAsync extends AsyncTask<List<note>, Void, List<Long>> {

        @Override
        protected List<Long> doInBackground(List<note>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<note> newList = new ArrayList<>(lists[0]);


            List<Long> res = medDao.insertNotes(newList.toArray(new note[0]));
            return res;
        }
    }


}

