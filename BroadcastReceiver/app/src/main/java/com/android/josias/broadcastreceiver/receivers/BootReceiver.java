package com.android.josias.broadcastreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    /*
    *   O SEGREDO ESTÁ NO ANDROID MANIFEST
    *   intent-filter
    *   permissões
    */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("teste", "TESTE BOOT");
    }

}

