package com.dabkick.dabtv.a3laun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mike on 8/1/2017.
 */

public class alarmrecv extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.dabkick.dabtv.3Laun.alarm";

    // Triggered by the Alarm periodically (starts the service to run task)
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, TmrTest.class);
        i.putExtra("foo", "bar");
        context.startService(i);
    }
}
