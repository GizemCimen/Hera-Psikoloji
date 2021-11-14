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

public class randevu_adapter extends ArrayAdapter<String> {
    Context context;
    String[] hastalar;
    String[] doktorlar;
    String[] hizmetler;
    String[] tarihler;
    String[] saatler;

    public randevu_adapter(Context context, String[] hasta, String[] doktor, String[] hizmet,String[] tarih,String[] saat){
        super(context,
                R.layout.randevu_bilgileri,
                R.id.textView,
                hasta);
        this.context = context;
        this.hastalar = hasta;
        this.doktorlar = doktor;
        this.hizmetler = hizmet;
        this.tarihler = tarih;
        this.saatler = saat;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View randevu_bilgileri = inflater.inflate(R.layout.randevu_bilgileri, parent, false);

        TextView hasta = randevu_bilgileri.findViewById(R.id.textView_randevu_hasta);
        TextView doktor = randevu_bilgileri.findViewById(R.id.textView_randevu_doktoru);
        TextView hizmet = randevu_bilgileri.findViewById(R.id.textView_randevu_hizmeti);
        TextView tarih = randevu_bilgileri.findViewById(R.id.textView_randevu_tarihi);
        TextView saat = randevu_bilgileri.findViewById(R.id.textView_randevu_saati);




        hasta.setText("\tHasta : "+hastalar[position]);
        doktor.setText("\tDoktor: "+doktorlar[position]);
        hizmet.setText("\tHizmet: "+hizmetler[position]);
        tarih.setText("\tTarih: "+tarihler[position]);
        saat.setText("\tSaat: "+saatler[position]);


        return randevu_bilgileri;

    }

}
