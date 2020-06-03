package com.example.mobilproje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdaptorNote extends BaseAdapter {
    List<Note> datas;
    Context context;

    TextView txt;
    TextView txtDate;

    public AdaptorNote(List<Note> datas, Context context) {
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
        View view = layoutInflaterv.inflate(R.layout.listeitem_note, null);
        txt = view.findViewById(R.id.txtName);
        txtDate = view.findViewById(R.id.txtDate);


        Note note = datas.get(position);



        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(Long.parseLong(note.date));

        txtDate.setText(sdf.format(resultdate));
        txt.setText(note.description);


        return view;
    }
}




