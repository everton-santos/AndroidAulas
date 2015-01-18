package com.android.josias.storage.spreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.android.josias.storage.R;

public class SharedPreferencesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
    }

    public void saveSP(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("","");
        editor.putString("","");
        editor.putString("","");

        editor.commit();
    }

    public void getSP(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.getString("",null);
    }

}
