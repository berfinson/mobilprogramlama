package com.example.mobilproje;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IlacEkleActivity extends AppCompatActivity {

    Button btnSaatSec;
    TextView txtDate;
    Context context = this;
    EditText editName;
    ImageView imageView;

    String url = "https://i.ytimg.com/vi/K_M655e4gIo/maxresdefault.jpg";

    PrefHelper prefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilacekle);


        prefHelper = PrefHelper.getInstance(this);

        btnSaatSec = (Button) findViewById(R.id.button_saat_sec);
        editName = findViewById(R.id.edtName);
        imageView = findViewById(R.id.imgview);

        txtDate = findViewById(R.id.txtDate);
        btnSaatSec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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

        String date = txtDate.getText().toString();

        Medicine med = new Medicine(name, date, url);
        AddAllAsync addAllAsync = new AddAllAsync();
        List<Medicine> list = new ArrayList<>();
        list.add(med);
        addAllAsync.execute(list);

        prefHelper.showMessage("ilaç eklendi");
        finish();


    }

    public void selectimage(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

    }

    public static final int PICK_IMAGE = 1;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            url = data.getData().toString();
            Log.e("Med", url);
            Glide.with(context).load(url).into(imageView);
        }
    }

    public class AddAllAsync extends AsyncTask<List<Medicine>, Void, List<Long>> {

        @Override
        protected List<Long> doInBackground(List<Medicine>... lists) {

            MedDao medDao = MedDatabase.getInstance(context).medDao();

            ArrayList<Medicine> newList = new ArrayList<>(lists[0]);


            List<Long> res = medDao.insertAll(newList.toArray(new Medicine[0]));
            return res;
        }
    }


}
