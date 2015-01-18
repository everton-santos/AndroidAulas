package com.android.josias.storage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Josias on 16/01/2015.
 */
public class DBConfig extends SQLiteOpenHelper {

    public static final int DB_VER = 1;
    public static final String NOME_DB = "DBALUNOS";
    public static final String TABELA_ALUNOS = "ALUNOS";
    public static final String COL_ALUNOS_ID = "Id";
    public static final String COL_ALUNOS_MAT = "Matricula";
    public static final String COL_ALUNOS_NOME = "Nome";

    private static final String CRIAR_TABELA_ALUNOS =
            "CREATE TABLE " + TABELA_ALUNOS + " (" + COL_ALUNOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    COL_ALUNOS_MAT + "  TEXT," +
                    COL_ALUNOS_NOME + " TEXT);";

    public DBConfig(Context context, String name, CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA_ALUNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //O QUE FAZER PARA ATUALIZAÇÃO
        //ALTER TABLE
        //DROP TABLE
        db.execSQL("DROP TABLE IF EXIST " + TABELA_ALUNOS + ";");
        onCreate(db);
    }

}