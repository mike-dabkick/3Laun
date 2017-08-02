package com.dabkick.dabtv.a3laun;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import static com.dabkick.dabtv.a3laun.dispdev.testlist;

public class MainActivity extends Activity {

    private Handler mHandler;
    public void useHandler() {
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 500);
    }
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            ;;;;;
            mHandler.postDelayed(mRunnable, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //scheduleAlarm();
/*
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run () {
                //////
            }
        }, 0, 500);
*/



    /*    final Handler handler = new Handler();
        final Runnable r = new Runnable()
        {
            public void run() {
                ;;;
            }
        }
        handler.postDelayed
*/
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hdmiListActivity.class);
                startActivity(intent);
            }
        });

        dispdev.testlist();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    public void scheduleAlarm() {
        Intent intent = new Intent(getApplicationContext(), alarmrecv.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, alarmrecv.REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis();
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                AlarmManager.INTERVAL_HALF_HOUR, pIntent);
    }
}
