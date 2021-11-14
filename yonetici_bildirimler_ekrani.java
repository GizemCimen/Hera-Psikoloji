package com.example.psikolog_gizem.yonetici;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.hasta.bildirim_karsilama_ekrani;


public class yonetici_bildirimler_ekrani extends AppCompatActivity {
    private Button buttonBildir_yonetici;
    private EditText multiline_bildirim_yonetici;
    private NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_bildirimler_ekrani);

        buttonBildir_yonetici=findViewById(R.id.buttonBildir_yonetici);
        multiline_bildirim_yonetici=findViewById(R.id.multiline_bildirim_yonetici);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BİLDİRİM");
        buttonBildir_yonetici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                durumaBagli();
            }

        });


    }
    public void durumaBagli(){

        NotificationManager bildirimYoneticisi=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent=new Intent(yonetici_bildirimler_ekrani.this, bildirim_karsilama_ekrani.class);
        String bildirim_metni=multiline_bildirim_yonetici.getText().toString();
        intent.putExtra("bildirim",bildirim_metni);
        PendingIntent gidilecekIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String KanalID="kanal ID";
            String KanalAd="kanal AD";
            String KanalTanım="kanal TANIM";
            int KanalOnceligi=NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel kanal=bildirimYoneticisi.getNotificationChannel(KanalID);
            if(kanal==null){
                kanal=new NotificationChannel(KanalID,KanalAd,KanalOnceligi);
                kanal.setDescription(KanalTanım);
                bildirimYoneticisi.createNotificationChannel(kanal);
            }
            builder=new NotificationCompat.Builder(this,KanalID);
            builder.setContentTitle("BAŞLIK");
            builder.setContentTitle("GÜNÜN SÖZÜ");
            builder.setSmallIcon(R.drawable.bildirim_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);

        }
        else{
            builder=new NotificationCompat.Builder(this);
            builder.setContentTitle("BAŞLIK");
            builder.setContentTitle("GÜNÜN SÖZÜ");
            builder.setSmallIcon(R.drawable.bildirim_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        bildirimYoneticisi.notify(1,builder.build());
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