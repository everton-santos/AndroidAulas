package com.android.josias.storage.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;

public class AtualizarSQLiteActivity extends ActionBarActivity {

    private EditText etMatricula, etNovoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_sqlite);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNovoNome = (EditText)findViewById(R.id.etNovoNome);
    }

    public void atualizar(View v){

        String mat = etMatricula.getText().toString();
        String newNome = etNovoNome.getText().toString();

        AlunoDAO adao = new AlunoDAO(this);
        adao.update(mat, newNome);

        Toast.makeText(this, "Atualização realizada!", Toast.LENGTH_SHORT).show();
    }

}
