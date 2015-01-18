package com.android.josias.storage.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;

public class ApagarSQLiteActivity extends ActionBarActivity {

    private EditText etMatricula, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apagar_sqlite);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void apagar(View v){

        String mat = etMatricula.getText().toString();

        AlunoDAO adao = new AlunoDAO(this);
        adao.delete(mat);

        Toast.makeText(this, "Apagado!", Toast.LENGTH_SHORT).show();
    }
}