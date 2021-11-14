package com.example.psikolog_gizem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.psikolog_gizem.R;


public class doktor_adapter extends ArrayAdapter<String> {
    Context context;
    String[] adsoyadlar;
    String[] epostalar;
    String[] hizmetler;

    public doktor_adapter(Context context, String[] adsoyad, String[] eposta, String[] hizmet){
        super(context,
                R.layout.psikolog_bilgileri,
                R.id.textView,
                adsoyad);
        this.context = context;
        this.adsoyadlar = adsoyad;
        this.epostalar = eposta;
        this.hizmetler = hizmet;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View psikolog_bilgileri = inflater.inflate(R.layout.psikolog_bilgileri, parent, false);

        TextView adsoyad = psikolog_bilgileri.findViewById(R.id.textView);
        TextView eposta = psikolog_bilgileri.findViewById(R.id.textView2);
        TextView hizmet = psikolog_bilgileri.findViewById(R.id.textView3);




        adsoyad.setText("\tAdı ve Soyadı: "+adsoyadlar[position]);
        eposta.setText("\tE-Posta: "+epostalar[position]);
        hizmet.setText("\tHizmet: "+hizmetler[position]);


        return psikolog_bilgileri;

    }
}
