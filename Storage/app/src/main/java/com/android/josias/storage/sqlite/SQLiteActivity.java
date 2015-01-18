package com.android.josias.storage.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.android.josias.storage.R;


public class SQLiteActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }

    public void openCadastrar(View v){
        Intent i = new Intent(this, CadastrarSQLiteActivity.class);
        startActivity(i);
    }

    public void openAtualizar(View v){
        Intent i = new Intent(this, AtualizarSQLiteActivity.class);
        startActivity(i);
    }

    public void openApagar(View v){
        Intent i = new Intent(this, ApagarSQLiteActivity.class);
        startActivity(i);
    }

    public void openBuscar(View v){
        Intent i = new Intent(this, BuscarSQLiteActivity.class);
        startActivity(i);
    }

}
