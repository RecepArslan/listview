package com.example.androidproje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class bilgileriGoster extends AppCompatActivity {
    TextView adsoyad, cinsiyet, isdurumu;
    Button btn;
    int sil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgileri_goster);
        tanimla();
        bilgilerial();
        kisiSil();

    }

    void bilgilerial() {
        Bundle bundle = getIntent().getExtras();
        String adString = bundle.getString("kisiadisoyadigoster");
        int cinsiyetInt = bundle.getInt("kisicinsiyetgoster");
       final int isDurumuInt = bundle.getInt("kisiCalismaDurumuGoster");
        Log.i("goster", "" + isDurumuInt);
        sil = bundle.getInt("thisid");
        Log.i("bak", cinsiyetInt + "");
        Log.i("bak", "" + isDurumuInt);
        Log.i("bak", "" + R.drawable.erkek);
        Log.i("bak", "" + R.drawable.kadin);
        Log.i("bak", "" + R.drawable.evet);
        Log.i("bak", "" + R.drawable.hayir);
        if (cinsiyetInt == R.drawable.erkek) cinsiyet.setText("CİNSİYET: ERKEK");
        else cinsiyet.setText("CİNSİYET: kadın");
        if (isDurumuInt == R.drawable.evet) isdurumu.setText("ÇALIŞMA DURUMU: ÇALIŞIYOR");
        else isdurumu.setText("ÇALIŞMA DURUMU: ÇALIŞMIYOR");
        adsoyad.setText(adString);
        Log.i("gosterim", "" + R.drawable.evet + "   " + R.drawable.hayir + "   " + isDurumuInt);


    }

    void tanimla() {
        adsoyad = findViewById(R.id.bilgileriGoster_textview_ad);
        cinsiyet = findViewById(R.id.bilgileriGoster_textview_cinsiyet);
        isdurumu = findViewById(R.id.bilgileriGoster_textview_Calisma);
        btn = findViewById(R.id.bilgileriGoster_btn_sil);

    }

    // @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent(this, ActivityAnasayfa.class);
        setResult(3, intent);
        finish();
        return super.onKeyDown(keyCode, event);

    }

    void kisiSil() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityAnasayfa.class);
                intent.putExtra("silinecek", sil);
                Log.i("deneme", sil + "");
                setResult(2, intent);
                finish();
            }
        });


    }
}