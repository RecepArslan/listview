package com.example.androidproje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class yeniKisi extends AppCompatActivity {
    RadioGroup radio_group_cinsiyet, radio_group_calismaDurumu;
    // RadioButton cinsiyetbtn,isdurumubtn;
    EditText editText_yeniAdSoyad;
    Button btn_yeniKisiOlustur;
    RadioButton radiobtn_cinsiyetSecim, radiobtn_calismadurumusecim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_kisi);
        tanimla();
        clickbutton();

    }

    void tanimla() {
        radio_group_cinsiyet = findViewById(R.id.yenikisicinsiyet);
        radio_group_calismaDurumu = findViewById(R.id.yenikisicalismadurumu);
        editText_yeniAdSoyad = findViewById(R.id.yenikisi_isim_edittext);
        btn_yeniKisiOlustur = findViewById(R.id.yenikisi_ekle_btn);


    }

    void clickbutton() {

        btn_yeniKisiOlustur.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("deneme","adf");
                model temp = yenikisiolustur();
                if(temp!=null) {
                    Intent intent = new Intent(getApplicationContext(), ActivityAnasayfa.class);
                    intent.putExtra("adsoyad", yenikisiolustur().adSoyd);
                    intent.putExtra("cinsiyet", yenikisiolustur().cinsiyet);
                    intent.putExtra("calisma", yenikisiolustur().calismaDurumu);
                    Log.i("deneme","adf2")
                    ;
                    setResult(1, intent);
                    finish();

                }
                else  Toast.makeText(getApplicationContext(),R.string.eksikbilgi,Toast.LENGTH_LONG).show();
            }
        });


    }

    model yenikisiolustur() {
        if (kontrol()) {
            String adsoyad = editText_yeniAdSoyad.getText().toString();
            radiobtn_cinsiyetSecim = findViewById(radio_group_cinsiyet.getCheckedRadioButtonId());
            String cinsiyetS = radiobtn_cinsiyetSecim.getText().toString();
            radiobtn_calismadurumusecim = findViewById(radio_group_calismaDurumu.getCheckedRadioButtonId());
            String isdurumuS = radiobtn_calismadurumusecim.getText().toString();
            int cinsiyetint;
            int isdurumInt;
            if (cinsiyetS.equals("kadın")) {
                cinsiyetint = R.drawable.kadin;
            } else {
                cinsiyetint = R.drawable.erkek;
            }
            if (isdurumuS.equals("calisiyor")) {
                isdurumInt = R.drawable.evet;
            } else {
                isdurumInt = R.drawable.hayir;
            }

            model temp = new model(cinsiyetint, adsoyad, isdurumInt);

            return temp;
        } else {

            return null;

        }
    }

    boolean kontrol() {

        //hiçbiri seçilmediğinde -1 dönderir
        if (radio_group_cinsiyet.getCheckedRadioButtonId() == -1) return false;
        else if (radio_group_calismaDurumu.getCheckedRadioButtonId() == -1) return false;
        else if (editText_yeniAdSoyad.getText().toString().equals("")) return false;
        else return true;
    }

}