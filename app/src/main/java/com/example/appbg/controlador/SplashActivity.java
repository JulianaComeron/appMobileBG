package com.example.appbg.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appbg.R;
import com.example.appbg.controlador.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final int TEMPO = 2200; //EM MILLESEGUNDOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inicializarTelaLogin();
    }

    private void inicializarTelaLogin(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent telaLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(telaLogin);
            }
        },TEMPO);

    }
}