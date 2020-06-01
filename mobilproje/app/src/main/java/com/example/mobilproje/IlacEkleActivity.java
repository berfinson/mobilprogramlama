package com.example.mobilproje;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IlacEkleActivity extends AppCompatActivity {

    Button btnSaatSec;
    TextView txtDate;
    Context context = this;
    EditText editName;
    EditText editUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacekle);

        btnSaatSec = (Button) findViewById(R.id.button_saat_sec);
        editName =  findViewById(R.id.edtName);
        editUrl =  findViewById(R.id.edtUrl);
        txtDate =  findViewById(R.id.txtDate);
        btnSaatSec.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View v){
                final Calendar takvim = Calendar.getInstance();
                int saat = takvim.get(Calendar.HOUR_OF_DAY);
                int dakika = takvim.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(context,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                txtDate.setText(hourOfDay + ":" + minute);
                            }
                        }, saat, dakika, true);

                tpd.setButton(TimePickerDialog.BUTTON_POSITIVE, "Seç", tpd);
                tpd.setButton(TimePickerDialog.BUTTON_NEGATIVE, "İptal", tpd);
                tpd.show();
            }
        });
    }

    public void onclickGoToAnaMenu(View view) {
        finish();
    }

    public void clickAddMedicine(View view) {

        String name = editName.getText().toString();
        String url = editUrl.getText().toString();
        String date = txtDate.getText().toString();

        Medicine med = new Medicine(name,date,url);
        AddAllAsync addAllAsync = new AddAllAsync();
         List<Medicine> list = new ArrayList<>();
         list.add(med);
        addAllAsync.execute(list);

        Toast.makeText(this,"Yeni ilaç Eklendi",Toast.LENGTH_LONG).show();
        finish();


    }

    public  class  AddAllAsync extends AsyncTask<List<Medicine>,Void,List<Long>> {

        @Override
        protected List<Long> doInBackground(List<Medicine>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<Medicine> newList = new ArrayList<>(lists[0]);


          List<Long> res =  medDao.insertAll(newList.toArray(new Medicine[0]));
            return res;
        }
    }


}
