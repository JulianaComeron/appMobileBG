package com.example.appbg.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appbg.dominio.Usuario;
import com.example.appbg.fabrica.FabricaUsuario;

public class RepositorioUsuario  extends RepositorioBase {
    private static final String TABELA_USUARIO="tb_usuario";

    public RepositorioUsuario(@Nullable Context context){
        super(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS usuario");
        this.onCreate(db);
    }

    public boolean  salvarUsuario(Usuario usuario) {
        boolean salvo = salvar(TABELA_USUARIO, FabricaUsuario.criarUsuarioCv(usuario));
        Log.d("salvarUsuario",usuario.toString());
        return salvo;
    }
}
