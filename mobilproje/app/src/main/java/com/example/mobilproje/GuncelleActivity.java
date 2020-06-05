package com.example.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import static com.example.mobilproje.IlacEkleActivity.PICK_IMAGE;

public class GuncelleActivity extends AppCompatActivity {
    PrefHelper prefHelper;
    ImageView slcimg;
    Context context = this;
    String url = "https://i.ytimg.com/vi/K_M655e4gIo/maxresdefault.jpg";
    EditText edtUserName;
    EditText edtMail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);


        prefHelper = PrefHelper.getInstance(this);

        edtUserName = findViewById(R.id.edtUserName);
        edtMail = findViewById(R.id.edtMail);
        slcimg = findViewById(R.id.imgview);
        String username2 = prefHelper.getString("username");
        String mail = prefHelper.getString("mail");

        edtUserName.setText(username2);
        edtMail.setText(mail);
        /*
        Bitmap image=(Bitmap)data.getExtras().get("data");//Çekilen resim id olarak bitmap şeklinde alındı ve imageview'e atandı
        slcimg= (ImageView) findViewById(R.id.slcimg);
        slcimg.setImageBitmap(image);
        */

    }


    public void onclickGuncelle(View view) {


        String name = edtUserName.getText().toString();
        String mail = edtMail.getText().toString();


        prefHelper.saveString("mail", mail);
        prefHelper.saveString("username", name);


        prefHelper.showMessage("Güncelleme tamamlandı");
        finish();


    }

    public void onclickIptal(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }

    public void slcimg(View view) {
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
            Glide.with(context).load(url).into(slcimg);
        }
    }
}

