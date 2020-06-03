package com.example.mobilproje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptorEczane extends BaseAdapter {
    List<Eczane> datas;
    Context context;

    TextView txtname;
    TextView txtadress;
    TextView txttelefon;
    public AdaptorEczane(List<Eczane> datas, Context context) {
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
        View view = layoutInflaterv.inflate(R.layout.listitem_eczane, null);
        txtname = view.findViewById(R.id.txtEczane);
        txtadress = view.findViewById(R.id.txtAdress);
        txttelefon = view.findViewById(R.id.txtTelefon);


        Eczane eczane = datas.get(position);

        txtadress.setText(eczane.adres);
        txtname.setText(eczane.name);
        txttelefon.setText(eczane.telefon);


        return view;
    }
}
