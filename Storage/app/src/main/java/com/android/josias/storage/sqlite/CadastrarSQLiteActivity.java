package com.android.josias.storage.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;

public class CadastrarSQLiteActivity extends ActionBarActivity {

    private EditText etMatricula, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_sqlite);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void salvar(View v){

        String mat = etMatricula.getText().toString();
        String nome = etNome.getText().toString();

        Aluno aluno = new Aluno(mat, nome);

        AlunoDAO adao = new AlunoDAO(this);
        boolean result = adao.insert(aluno);
        if (result){
            Toast.makeText(this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Erro no cadastro", Toast.LENGTH_SHORT).show();
        }
    }
}
