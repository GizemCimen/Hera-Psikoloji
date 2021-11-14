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

public class hizmet_adapter extends ArrayAdapter<String> {
    Context context;
    String[] adlar;
    String[] aciklamalar;

    public hizmet_adapter(Context context, String[] ad, String[] aciklama){
        super(context,
                R.layout.hizmet_bilgileri,
                R.id.textView,
                ad);
        this.context = context;
        this.adlar = ad;
        this.aciklamalar = aciklama;

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View hizmet_bilgileri = inflater.inflate(R.layout.hizmet_bilgileri, parent, false);

        TextView ad = hizmet_bilgileri.findViewById(R.id.txt_hizmet_adi_goster);
        TextView aciklama = hizmet_bilgileri.findViewById(R.id.txt_hizmet_aciklama_goster);





        ad.setText("\tHizmet adı: "+adlar[position]);
        aciklama.setText("\tHizmet açıklaması: "+aciklamalar[position]);



        return hizmet_bilgileri;

    }
}
