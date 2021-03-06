package com.example.appbg.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public abstract class DaoBase extends SQLiteOpenHelper {
   private static final int DATABASE_VERSION=1;
   public static final String DATABASE_NAME="dbmobilebg";
   private Context context;

    public DaoBase(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        criarTabelaUsuario(db);

    }

    public void criarTabelaUsuario(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE usuario(";
        sql += "codigo INTERGER PRIMARY KEY AUTOINCREMENT,";
        sql += "nome TEXT,";
        sql += "login TEXT,";
        sql += "senha TEXT";
        sql += ")";

        db.execSQL(sql);
    }

    protected boolean salvar (String nomeTabela, ContentValues objeto){
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.insert(nomeTabela,null,objeto);
            sucesso= true;
        } catch (Exception e) {
            sucesso=false;
            Log.e("Erro ao salvar" + objeto, e.toString());
            }
        db.close();
        return sucesso;

    };
}
