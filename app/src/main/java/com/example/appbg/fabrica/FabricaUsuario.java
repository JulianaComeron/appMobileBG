package com.example.appbg.fabrica;

import android.content.ContentValues;
import android.database.Cursor;
import com.example.appbg.dto.UsuarioDTO;

public class FabricaUsuario {
    public static UsuarioDTO criarUsuario (Cursor cursor) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setCodigo(Long.parseLong(cursor.getString(0)));
        usuarioDTO.setNome(cursor.getString(2));
        usuarioDTO.setLogin(cursor.getString(1));
        usuarioDTO.setSenha(cursor.getString(3));

        return usuarioDTO;

    }

    public static ContentValues criarUsuarioCv (UsuarioDTO usuarioDTO) {
        ContentValues usuarioCv = new ContentValues();

        usuarioCv.put("nome", usuarioDTO.getNome());
        usuarioCv.put("login", usuarioDTO.getLogin());
        usuarioCv.put("senha", usuarioDTO.getSenha());

        return usuarioCv;
    }
}
