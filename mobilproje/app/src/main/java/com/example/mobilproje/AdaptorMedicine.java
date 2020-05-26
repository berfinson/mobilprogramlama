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
import java.util.List;

public class AdaptorMedicine extends BaseAdapter {
    List<medicine> datas;
    Context context;

    public AdaptorMedicine(List<medicine> datas, Context context) {
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
        View view = layoutInflaterv.inflate(R.layout.listeitem, null);
        TextView txt = view.findViewById(R.id.txtName);
        TextView txtDate = view.findViewById(R.id.txtDate);
        ImageView imageView = view.findViewById(R.id.img);


        medicine medicine = datas.get(position);

        Glide.with(context).load(medicine.image).into(imageView);
        txtDate.setText(medicine.date);
        txt.setText(medicine.name);


        return view;
    }
}




