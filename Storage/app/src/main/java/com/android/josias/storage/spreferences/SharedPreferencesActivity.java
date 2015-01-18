package com.android.josias.storage.spreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;
import com.android.josias.storage.core.Constants;

public class SharedPreferencesActivity extends ActionBarActivity {

    private EditText etMatricula, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void saveSP(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.SP_MATRICULA,etMatricula.getText().toString());
        editor.putString(Constants.SP_NOME,etNome.getText().toString());

        editor.commit();
        Toast.makeText(this, "Infos salvas!", Toast.LENGTH_SHORT).show();
    }

    public void getSP(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String matricula = pref.getString(Constants.SP_MATRICULA,null);
        String nome = pref.getString(Constants.SP_NOME,null);

        if (matricula != null && nome != null){
            Toast.makeText(this, matricula + " - " + nome, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "matricula ou nome nulos", Toast.LENGTH_SHORT).show();
        }
    }

}
