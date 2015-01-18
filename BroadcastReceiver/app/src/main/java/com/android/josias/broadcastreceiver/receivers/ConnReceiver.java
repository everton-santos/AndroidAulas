package com.android.josias.broadcastreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ConnReceiver extends BroadcastReceiver {
    public ConnReceiver() {
    }

    /*
    *   O SEGREDO ESTÁ NO ANDROID MANIFEST
    *   intent-filter
    *   permissões
    */
    @Override
    public void onReceive(Context context, Intent intent) {

        /*
        * Codificação indicada pela google - http://developer.android.com/training/monitoring-device-state/connectivity-monitoring.html
        * Contudo nunca consegui fazer funcionar
        */
        /*ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork.isConnected();

        Log.i("teste", "" + isConnected);*/

        /*
        * Codificação antiga - deprecated
        * Funciona :)
        */
        NetworkInfo info = (NetworkInfo)intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
        boolean isWiFi = info.getType() == ConnectivityManager.TYPE_WIFI;

        if (info.isConnected()){
            Log.i("teste", "CONECTADO! - Wifi? " + isWiFi);
        }else{
            Log.i("teste", "DESCONECTADO!");
        }
    }

}
