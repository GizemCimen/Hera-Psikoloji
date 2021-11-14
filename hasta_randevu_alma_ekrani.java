package com.example.psikolog_gizem.hasta;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.doktor_adapter;
import com.example.psikolog_gizem.adapter.randevu_doktor_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.randevular;
import com.example.psikolog_gizem.yonetici.yonetici_psikolog_listeleme_ekrani;

import java.util.ArrayList;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class hasta_randevu_alma_ekrani extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Button button_hizmet_sec;
    private TextView textView_hizmet_gor;
    private TextView textView_hasta_e_posta;
    private Button button_randevu_kaydet;
    private Spinner spinner_doktor_list;
    private ArrayList<doktorlar> doktorlarArrayList;
    private ArrayAdapter<String> veriAdaptoru;
    private EditText randevu_tarih;
    private EditText randevu_saat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_randevu_alma_ekrani);
        String gelenn=getIntent().getStringExtra("name");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("RANDEVU OLUŞTUR");

    button_hizmet_sec=findViewById(R.id.button_hizmet_sec);
    textView_hizmet_gor=findViewById(R.id.textView_hizmet_gor);
    textView_hasta_e_posta=findViewById(R.id.textView_hasta_e_posta);
    button_randevu_kaydet=findViewById(R.id.button_randevu_kaydet);
    spinner_doktor_list=findViewById(R.id.spinner_doktor_list);
    randevu_tarih=findViewById(R.id.randevu_tarih);
    randevu_saat=findViewById(R.id.randevu_saat);


        final VeriTabani veriTabani=new VeriTabani(hasta_randevu_alma_ekrani.this);
        doktorlarArrayList = veriTabani.butunDoktorlarıGetir();
        int length = doktorlarArrayList.size();
        String[] adsoyad = new String[length];
        for (int i = 0; i < length; i++) {
            adsoyad[i] = doktorlarArrayList.get(i).getdoktor_adi_soyadi();

        }
        randevu_doktor_adapter psikologAdapter = new randevu_doktor_adapter(this, adsoyad);
        spinner_doktor_list.setAdapter(psikologAdapter);

        spinner_doktor_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textView_hasta_e_posta.setText("Kullanıcı Adı: "+gelenn);

        randevu_tarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int yil=calendar.get(Calendar.YEAR);
                int ay=calendar.get(Calendar.MONTH);
                int gun=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker;
                datePicker=new DatePickerDialog(hasta_randevu_alma_ekrani.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        randevu_tarih.setText(i2+"/"+i1+"/"+i);
                    }
                },yil,ay,gun);
                datePicker.setTitle("Tarih Seçiniz");
                datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Seç",datePicker);
                datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",datePicker);
                datePicker.show();
            }
        });

        randevu_saat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int saat=calendar.get(Calendar.HOUR_OF_DAY);
                int dakika=calendar.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker=new TimePickerDialog(hasta_randevu_alma_ekrani.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        randevu_saat.setText(i+":"+i1);
                    }
                },saat,dakika,true);
                timePicker.setTitle("Saat Seçiniz");
                timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Seç",timePicker);
                timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",timePicker);
                timePicker.show();

            }
        });




        button_randevu_kaydet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String kullanici=textView_hasta_e_posta.getText().toString();
            String hizmet=textView_hizmet_gor.getText().toString();
            String doktorx=spinner_doktor_list.getSelectedItem().toString();
            String tarih=randevu_tarih.getText().toString();
            String saat=randevu_saat.getText().toString();
            if( textView_hizmet_gor.getText().toString().trim().equals("") ||
                    randevu_tarih.getText().toString().trim().equals("") ||
                    randevu_saat.getText().toString().trim().equals("")  ){
                Toast.makeText(getApplicationContext(),"Boş Alan Bırakılamaz !!", Toast.LENGTH_LONG).show();
                }
            else{
                randevular randevu=new randevular(kullanici,doktorx,hizmet,tarih,saat);
                veriTabani.RandevuEkle(randevu);
                Toast.makeText(getApplicationContext(), "RANDEVU BAŞARIYLA SİSTEME EKLENDİ !", Toast.LENGTH_LONG).show();
                Intent geri=new Intent(hasta_randevu_alma_ekrani.this,hasta_karsilama_ekrani.class);
                startActivity(geri);
                finish();
                ArrayList<randevular> addedDoctor = veriTabani.butunRandevularıGetir();
                for (randevular aDoktor : addedDoctor
                ) {
                    System.out.printf("HASTA: %s\nDOKTOR: %s\nHİZMET: %s\nTARİH: %s\nSAAT: %s",
                            aDoktor.getrandevu_hastasi(), aDoktor.getrandevu_doktoru(), aDoktor.getrandevu_hizmet(),
                            aDoktor.getrandevu_tarihi(),aDoktor.getrandevu_saati());
                    System.out.println("\n\n*********************\n\n");
                }

            }

        }
    });



    }
    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public void ShowPopup(View v){
        PopupMenu popupMenu=new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.show();
    }

    public boolean onMenuItemClick(MenuItem item){
    switch (item.getItemId()){
        case R.id.cift_ve_aile:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: Çift ve Aile Terapisi");
            return true;
        case R.id.cocuk_psikologu:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: Çocuk Psikoloğu");
            return true;
        case R.id.bireysel_psikoterapi:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: Bireysel Psikoterapi");
            return true;
        case R.id.cinsel_terapi:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: Cinsel Terapi");
            return false;
        case R.id.emdr_terapi:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: EMDR Terapi");
            return true;
        case R.id.online_terapi:
            textView_hizmet_gor.setText("");
            textView_hizmet_gor.setText("Hizmet: Online Terapi");
            return true;
        default:
            return false;

    }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}