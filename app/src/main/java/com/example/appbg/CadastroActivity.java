package com.example.appbg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbg.dao.DaoUsuario;
import com.example.appbg.dto.UsuarioDTO;

public class CadastroActivity extends AppCompatActivity {
Button buttonSalvarUsuario;
EditText editTextNome;
EditText editTextLogin;
EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        editTextNome = findViewById(R.id.editTextNome);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);

        buttonSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioDTO usuarioDTO = new UsuarioDTO(editTextLogin.getText().toString(),
                        editTextNome.getText().toString(),
                        editTextSenha.getText().toString());
                DaoUsuario daousuario = new DaoUsuario(getApplicationContext());
                try {
                    if (daousuario.salvarUsuario(usuarioDTO) > 0) {
                        Toast.makeText(getApplicationContext(), "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                        Log.d("Erro-ao-inserir", ex.toString());
                        Toast.makeText(getApplicationContext(), "Erro ao inserir:" + editTextLogin.toString(), Toast.LENGTH_SHORT).show();
                    }


            }
        });

    }
}