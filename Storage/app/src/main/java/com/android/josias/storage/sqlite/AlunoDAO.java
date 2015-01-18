package com.android.josias.storage.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/**
 * Created by Josias on 16/01/2015.
 */
public class AlunoDAO {
    private DBConfig config;
    private SQLiteDatabase liteDB;

    public AlunoDAO(Context c){
        config = new DBConfig(c, DBConfig.NOME_DB, null, DBConfig.DB_VER);
    }

    /*
    * Insert padrão do Android, pouco mais complicado, porém prover resposta de inserção
    */
    public boolean insert(Aluno aluno){

        ContentValues cv = new ContentValues();
        cv.put(DBConfig.COL_ALUNOS_MAT, aluno.getMatricula());
        cv.put(DBConfig.COL_ALUNOS_NOME, aluno.getNome());

        liteDB = config.getWritableDatabase();

        boolean flag = liteDB.insert(DBConfig.TABELA_ALUNOS, null, cv) > 0;

        liteDB.close();
        config.close();

        return flag;
    }

    /*
    * SQL puro, mais fácil, porém não prover resposta de inserção - void
    */
    public void insert2(Aluno aluno){

        liteDB = config.getWritableDatabase();

        //Colunas definidas na mão
        //Se um dia mudar, terá que alterar na mão
        liteDB.execSQL("INSERT INTO " + DBConfig.TABELA_ALUNOS + " (Matricula, Nome) "
                + " Values ('" + aluno.getMatricula() + "', '" + aluno.getNome() + "');");

        liteDB.close();
        config.close();
    }

    public void update(String matriculaBusca, String novoNome){

        liteDB = config.getWritableDatabase();

        //Colunas definidas na mão
        //Se um dia mudar, terá que alterar na mão
        liteDB.execSQL("UPDATE " + DBConfig.TABELA_ALUNOS + " SET Nome = '" + novoNome + "' WHERE Matricula= '" + matriculaBusca + "'");

        liteDB.close();
        config.close();
    }

    public void delete(String matricula){

        liteDB = config.getWritableDatabase();

        //Colunas definidas na mão
        //Se um dia mudar, terá que alterar na mão
        liteDB.execSQL("DELETE FROM " + DBConfig.TABELA_ALUNOS + " WHERE Matricula = '" + matricula + "'");

        liteDB.close();
        config.close();
    }

    public ArrayList<Aluno> buscarTodos(){

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        liteDB = config.getReadableDatabase();

        Cursor c = liteDB.rawQuery("SELECT * FROM " +  DBConfig.TABELA_ALUNOS, null);

        while (c.moveToNext()) {
            Aluno u = new Aluno();
            u.setCod(c.getString(0));
            u.setMatricula(c.getString(1));
            u.setNome(c.getString(2));
            alunos.add(u);
        }

        liteDB.close();
        config.close();

        return alunos;
    }

    public ArrayList<Aluno> buscarPorNome(String matricula){

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        liteDB = config.getReadableDatabase();

        Cursor c = liteDB.rawQuery(" SELECT * FROM " + DBConfig.TABELA_ALUNOS +
                                    " WHERE " + DBConfig.COL_ALUNOS_MAT + " = " + matricula
                                    , null);

        while (c.moveToNext()) {
            Aluno u = new Aluno();
            u.setCod(c.getString(0));
            u.setMatricula(c.getString(1));
            u.setNome(c.getString(2));
            alunos.add(u);
        }

        liteDB.close();
        config.close();

        return alunos;
    }

}
