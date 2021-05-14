package com.example.appbg.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appbg.dto.UsuarioDTO;
import com.example.appbg.fabrica.FabricaUsuario;

import java.util.ArrayList;

public class DaoUsuario extends DaoBase {
    private static final String TABELA_USUARIO="tb_usuario";

    public DaoUsuario(@Nullable Context context){
        super(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS usuario");
        this.onCreate(db);
    }

    public Long  salvarUsuario(UsuarioDTO usuarioDTO) {
        ContentValues values = new ContentValues();
        values.put("Login",usuarioDTO.getLogin());
        values.put("Nome",usuarioDTO.getNome());
        values.put("Senha",usuarioDTO.getSenha());
        long nLinhas = getWritableDatabase().insert(TABELA_USUARIO,null,values);
        return nLinhas;
    }
        public ArrayList<UsuarioDTO> consultarTodos(){
            String sql ="SELECT * FROM " + TABELA_USUARIO;
            Cursor cursor = getReadableDatabase().rawQuery(sql,null);
            ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<>();
            while (cursor.moveToNext()){
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo(cursor.getLong(0));
                usuarioDTO.setLogin(cursor.getString(1));
                usuarioDTO.setNome(cursor.getString(2));
                usuarioDTO.setSenha(cursor.getString(3));
                listaUsuarios.add(usuarioDTO);
            }
                return listaUsuarios;

        }
}
