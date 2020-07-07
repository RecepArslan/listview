package com.example.androidproje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      final  Intent intent=new Intent(this,ActivityAnasayfa.class);
        final Activity activity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                startActivity(intent);
                activity.finish();


            }

        };
        timer.schedule(task,2000,1000);


    }

}