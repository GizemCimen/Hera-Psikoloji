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

public class hasta_adapter extends ArrayAdapter<String> {
    Context context;
    String[] adlar;
    String[] soyadlar;
    String[] telefonlar;
    String[] epostalar;

    public hasta_adapter(Context context, String[] ad, String[] soyad, String[] telefon,String[] eposta){
        super(context,
                R.layout.hasta_bilgileri,
                R.id.textView,
                ad);
        this.context = context;
        this.adlar = ad;
        this.soyadlar = soyad;
        this.telefonlar = telefon;
        this.epostalar = eposta;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View hasta_bilgileri = inflater.inflate(R.layout.hasta_bilgileri, parent, false);

        TextView ad = hasta_bilgileri.findViewById(R.id.textView_ad);
        TextView soyad = hasta_bilgileri.findViewById(R.id.textView_soyad);
        TextView telefon = hasta_bilgileri.findViewById(R.id.textView_telefon);
        TextView eposta = hasta_bilgileri.findViewById(R.id.textView_eposta);

        ad.setText("\tAdı: "+adlar[position]);
        soyad.setText("\tSoyadı : "+soyadlar[position]);
        telefon.setText("\tTelefon: "+telefonlar[position]);
        eposta.setText("\tE-Posta: "+epostalar[position]);


        return hasta_bilgileri;

    }

}
