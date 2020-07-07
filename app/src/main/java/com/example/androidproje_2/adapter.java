package com.example.androidproje_2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class adapter extends BaseAdapter {
    List<model> liste;
    Context context;
    Activity activity;



    public adapter(List<model> liste, Context context, Activity activity) {
        this.liste = liste;
        this.context = context;
        this.activity = activity;

    }

    @Override
    public int getCount() {

        return liste.size();
    }

    @Override
    public Object getItem(int i) {

        return liste.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Log.i("iler", " " + i);
        view = LayoutInflater.from(context).inflate(R.layout.layoutistview, viewGroup, false);
        final TextView ad = view.findViewById(R.id.name);
        final ImageView imgcinsiyet = view.findViewById(R.id.cinsiyet);
        final ImageView imgisdurum = view.findViewById(R.id.fotois);
        final ImageView ımageview = view.findViewById(R.id.fotois);
        final String isimS = liste.get(i).getAdSoyd();
        final int imgcinsiyetS = liste.get(i).getCinsiyet();
        final int imgisdurumS = liste.get(i).getCalismaDurumu();
        imgcinsiyet.setImageResource(imgcinsiyetS);
        imgisdurum.setImageResource(imgisdurumS);
        ad.setText(isimS);
        ımageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (imgisdurum.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.evet).getConstantState())) {
                    imgisdurum.setImageResource(R.drawable.hayir);
                    liste.get(i).setCalismaDurumu(R.drawable.hayir);

                } else {
                    imgisdurum.setImageResource(R.drawable.evet);
                    liste.get(i).setCalismaDurumu(R.drawable.evet);
                }

            }
        });

        return view;
    }
}
