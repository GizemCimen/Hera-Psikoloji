package com.example.psikolog_gizem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.psikolog_gizem.R;

public class randevu_doktor_adapter extends ArrayAdapter<String> {

    Context context;
    String[] adsoyadlar;

    public randevu_doktor_adapter(Context context, String[] adsoyad) {
        super(context,
                R.layout.randevu_doktor_list,
                R.id.textView4,
                adsoyad);
        this.context = context;
        this.adsoyadlar = adsoyad;


    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View randevu_doktor_list = inflater.inflate(R.layout.randevu_doktor_list, parent, false);

        TextView adsoyad = randevu_doktor_list.findViewById(R.id.textView4);
        adsoyad.setText(adsoyadlar[position]);
            return randevu_doktor_list;

    }
}