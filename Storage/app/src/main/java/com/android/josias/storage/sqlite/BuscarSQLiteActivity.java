package com.android.josias.storage.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.josias.storage.R;

import java.util.ArrayList;

public class BuscarSQLiteActivity extends ActionBarActivity {

    private TextView tvResult;
    private EditText etMatricula, etNome;

    private AlunoDAO adao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_sqlite);

        tvResult = (TextView)findViewById(R.id.tvResult);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);

        adao = new AlunoDAO(this);
    }

    public void buscar(View v){

        tvResult.setText("");
        StringBuffer result = new StringBuffer();
        result.append("Resultado busca criteriosa:\n\n");

        String mat = etMatricula.getText().toString();

        ArrayList<Aluno> alunos = adao.buscarPorNome(mat);

        for (Aluno a: alunos){
            result.append(a.getCod() + " - " + a.getMatricula() + " - " + a.getNome() + "\n");
        }

        tvResult.setText(result.toString());

    }

    public void buscarTodos(View v){

        tvResult.setText("");
        StringBuffer result = new StringBuffer();
        result.append("Resultado do buscar todos:\n\n");

        ArrayList<Aluno> alunos = adao.buscarTodos();

        for (Aluno a: alunos){
            result.append(a.getCod() + " - " +a.getMatricula() + " - " + a.getNome() + "\n");
        }

        tvResult.setText(result.toString());
    }
}
