package com.example.herapsikoloji;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class psikolog_bildirim extends AppCompatActivity {

    private Button buttonBildir;
    private EditText bildirim_gir;
    private EditText multiline_bildirim;
    private NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_bildirim);

        buttonBildir=findViewById(R.id.buttonBildir);
        multiline_bildirim=findViewById(R.id.multiline_bildirim);
        multiline_bildirim=findViewById(R.id.multiline_bildirim);
        buttonBildir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                durumaBagli();

            }
        });
    }

    public void durumaBagli(){

        NotificationManager bildirimYoneticisi=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent=new Intent(psikolog_bildirim.this,bildirim_karsilama_ekrani.class);
        String bildirim_metni=multiline_bildirim.getText().toString();
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
           // builder.setSmallIcon(R.drawable.bildirim_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);

        }
        else{
            builder=new NotificationCompat.Builder(this);
            builder.setContentTitle("BAŞLIK");
            builder.setContentTitle("GÜNÜN SÖZÜ");
            //builder.setSmallIcon(R.drawable.bildirim_iconu);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        bildirimYoneticisi.notify(1,builder.build());
    }
}