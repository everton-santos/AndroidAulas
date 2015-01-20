package com.android.josias.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    /*
    * Exemplo BR TimerTick
    */
    private BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                Log.i("teste", "rodou 1m");
            }
        };

        registerReceiver(br, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(br);
        super.onDestroy();
    }

    public void startMyBR(View v){
        Intent intent = new Intent();
        intent.setAction("com.android.josias.broadcastreceiver.MYRECEIVER");
        sendBroadcast(intent);
    }
}
