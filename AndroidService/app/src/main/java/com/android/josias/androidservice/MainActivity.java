package com.android.josias.androidservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.android.josias.androidservice.services.LocationService;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, LocationService.class);
        startService(i);
    }

    @Override
    protected void onDestroy() {

        Intent i = new Intent(MainActivity.this, LocationService.class);
        stopService(i);

        super.onDestroy();
    }
}
