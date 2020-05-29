package com.example.mobilproje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptorEczane extends BaseAdapter {
    List<eczane> datas;
    Context context;

    public AdaptorEczane(List<eczane> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
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
        View view = layoutInflaterv.inflate(R.layout.listitem_eczane, null);
        TextView txt = view.findViewById(R.id.txtEczane);
        TextView txtadress = view.findViewById(R.id.txtAdress);
        TextView txttelefon = view.findViewById(R.id.txtTelefon);


        eczane eczane = datas.get(position);

        txtadress.setText(eczane.adres);
        txt.setText(eczane.name);
        txttelefon.setText(eczane.telefon);


        return view;
    }
}
