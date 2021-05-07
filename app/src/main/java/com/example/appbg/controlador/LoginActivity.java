package com.example.appbg.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbg.R;

public class LoginActivity extends AppCompatActivity {
    EditText editTextLogin;
    EditText editTextSenha;
    Button buttonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        abrirTelaMenu();
    }

    private void abrirTelaMenu() {
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verificar se o usuário e a senha são iguais.
                if (editTextLogin.getText().toString().equals("a") &&
                        editTextSenha.getText().toString().equals("a")) {
                    Toast.makeText(LoginActivity.this, "Bem-Vindo", Toast.LENGTH_SHORT).show();
                    Intent telaMenu = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(telaMenu);

                } else {
                    Toast.makeText(LoginActivity.this, "Campos são diferentes", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private boolean verifcarCampoVazio(){
        boolean vazio;
        if(editTextLogin.getText().toString().isEmpty()){
            Toast.makeText(this, "O campo login não pode ser vazio", Toast.LENGTH_SHORT).show();
            vazio=false;
        }
        else if(editTextSenha.getText().toString().isEmpty()){
            Toast.makeText(this, "O campo senhão não pode estar vazio", Toast.LENGTH_SHORT).show();
            vazio = false;
        }else{
            vazio=true;
        }
        return vazio;
    }
}