package com.example.mobilproje;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ilacekleActivity extends AppCompatActivity {

    Button btnSaatSec;
    EditText etSaat;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacekle);

        btnSaatSec = (Button) findViewById(R.id.button_saat_sec);
        etSaat = (EditText) findViewById(R.id.edittext_saat);
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

                                etSaat.setText(hourOfDay + ":" + minute);
                            }
                        }, saat, dakika, true);

                tpd.setButton(TimePickerDialog.BUTTON_POSITIVE, "Seç", tpd);
                tpd.setButton(TimePickerDialog.BUTTON_NEGATIVE, "İptal", tpd);
                tpd.show();
            }
        });
    }

    public void onclickGoToAnaMenu(View view) {
        Intent intent = new Intent(this, ilacmenusuActivity.class);
        startActivity(intent);
    }
}
