package com.example.androidproje_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class ActivityAnasayfa extends AppCompatActivity {
    List<model> list;
    ListView listView;
    adapter adp;
    FloatingActionButton floatingActionButton_yenikisiolustur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        createliste();
        gec();
        kisibilgileriGoster();
        clickYenikisi();

        onStop();

    }

    void createliste() {
        list = new ArrayList<>();

        model m1 = new model(R.drawable.erkek, "recep arslan", R.drawable.evet);
        model m2 = new model(R.drawable.kadin, "Ayşe Fatma", R.drawable.evet);
        model m3 = new model(R.drawable.erkek, "Alperen Sekban", R.drawable.evet);
        model m4 = new model(R.drawable.kadin, "Elif Türk", R.drawable.hayir);
        model m5 = new model(R.drawable.erkek, "Burak Yılmaz", R.drawable.hayir);

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);

    }

    void gec() {

        listView = findViewById(R.id.anasayfalistviewid);
        adp = new adapter(list, this, this);
        listView.setAdapter(adp);


    }

    void clickYenikisi() {
        floatingActionButton_yenikisiolustur = findViewById(R.id.floatingActionButton);
        floatingActionButton_yenikisiolustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), yeniKisi.class);
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("degerimiz", "degerler " + data.getStringExtra("adsoyad") + "  " + resultCode);
        if (requestCode == 1) {

            String kisiYeniAdSoyad = data.getStringExtra("adsoyad");
            int kisiYeniCalismaDurumu = data.getIntExtra("calisma", 0);
            int KisiYeniCinsiyet = data.getIntExtra("cinsiyet", 0);
            ekle(KisiYeniCinsiyet, kisiYeniAdSoyad, kisiYeniCalismaDurumu);

        } else if (requestCode == 2) {

            if (data.getIntExtra("silinecek", -1) != -1) {
                Log.i("deneme,", "buradayım" + data.getIntExtra("silinecek", 0));
                list.remove(data.getIntExtra("silinecek", 0));
                listView.setAdapter(adp);
            }
            else;
        }

    }


    void ekle(int kisiCinsiyet, String kisiYeniAdSoyad, int kisiCalismaDurumu) {

        model m = new model(kisiCinsiyet, kisiYeniAdSoyad, kisiCalismaDurumu);
        list.add(m);
        listView.setAdapter(adp);


    }

    void kisibilgileriGoster() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(getApplicationContext(), bilgileriGoster.class);
                intent.putExtra("kisicinsiyetgoster", list.get(i).getCinsiyet());
                intent.putExtra("kisiCalismaDurumuGoster", list.get(i).getCalismaDurumu());
                intent.putExtra("kisiadisoyadigoster", list.get(i).getAdSoyd());
                intent.putExtra("thisid", i);
                Log.i("gosterz", ""+ list.get(i).getCalismaDurumu());

                startActivityForResult(intent, 2);
            }
        });
    }
}




