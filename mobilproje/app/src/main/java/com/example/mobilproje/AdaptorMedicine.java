package com.example.mobilproje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptorMedicine extends BaseAdapter {
    ArrayList<medicine> datas;
    Context context;

    public AdaptorMedicine(ArrayList<medicine> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflaterv = LayoutInflater.from(context);
        View view = layoutInflaterv.inflate(R.layout.activity_ilacmenusu, null);
        TextView txt = view.findViewById(R.id.txt);
        TextView txtDate = view.findViewById(R.id.txtDate);
        ImageView imageView = view.findViewById(R.id.img);


        Glide.with(context).load("http://goo.gl/gEgYUd").into(imageView);
        medicine medicine = datas.get(position);
        View buton = view.findViewById(R.id.btn);
        buton.setTag(medicine);
        txtDate.setText(medicine.getDate());
        txt.setText(medicine.getName());


        return view;
    }
}




