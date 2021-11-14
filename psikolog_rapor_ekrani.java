package com.example.psikolog_gizem.psikolog;

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

public class psikolog_rapor_ekrani extends AppCompatActivity {

    private Button kaydet;
    private EditText rapor_yaz;
    private NotificationCompat.Builder builder;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_rapor_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HASTA RAPORU");

        kaydet=findViewById(R.id.kaydet);
        rapor_yaz=findViewById(R.id.rapor_yaz);
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                durumaBagli();
                //Intent yonlen=new Intent(psikolog_rapor_ekrani.this,hasta_raporu.class);
            }
        });
    }
    public void durumaBagli(){

        NotificationManager raporYoneticisi=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent=new Intent(psikolog_rapor_ekrani.this, hasta_raporu.class);
        String rapor_metni=rapor_yaz.getText().toString();
        intent.putExtra("rapor",rapor_metni);
        PendingIntent gidilecekIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            String KanalID = "kanal ID";
            String KanalAd = "kanal AD";
            String KanalTanım = "kanal TANIM";
            int KanalOnceligi = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel kanal = raporYoneticisi.getNotificationChannel(KanalID);
            if (kanal == null) {
                kanal = new NotificationChannel(KanalID, KanalAd, KanalOnceligi);
                kanal.setDescription(KanalTanım);
                raporYoneticisi.createNotificationChannel(kanal);
            }
            builder = new NotificationCompat.Builder(this, KanalID);
            builder.setContentTitle("BAŞLIK");
            builder.setContentTitle("RAPORUNUZ");
            builder.setSmallIcon(R.drawable.rapor_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);

        }
        else{
            builder=new NotificationCompat.Builder(this);
            builder.setContentTitle("BAŞLIK");
            builder.setContentTitle("RAPORUNUZ");
            builder.setSmallIcon(R.drawable.rapor_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        raporYoneticisi.notify(1,builder.build());
        finish();
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