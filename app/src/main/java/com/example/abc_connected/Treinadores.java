package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class Treinadores extends AppCompatActivity {
    public FirebaseAuth mAuth;
    Button logout, call, up,EditarEquipa,CriarEquipa, treino, edittreino,CriarListaJogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinador);
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.button24);
        call = findViewById(R.id.button7);
        up = findViewById(R.id.button25);
        EditarEquipa = findViewById(R.id.EditarEquipa);
        CriarEquipa = findViewById(R.id.CriarEquipa);
        treino = findViewById(R.id.button10);
        edittreino = findViewById(R.id.button999);
        CriarListaJogo = findViewById(R.id.CriarJogada);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Treinadores.this, MainActivity.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            };
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCalendarIntent = new Intent(Treinadores.this, Vizz.class);

                startActivity(mainCalendarIntent);
            }
        });
        CriarListaJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityCriarListaJogo = new Intent(Treinadores.this,ListaJogo.class);
                startActivity(activityCriarListaJogo);
            }
        });
        CriarEquipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityCriarEquipa = new Intent(Treinadores.this,Criar_Equipa.class);
                startActivity(activityCriarEquipa);
            }
        });
        EditarEquipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityEditarEquipa = new Intent(Treinadores.this, EditarEquipa.class);
                startActivity(activityEditarEquipa);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCalendarIntent = new Intent(Treinadores.this, EditarTreinador.class);

                startActivity(mainCalendarIntent);
            }
        });

        treino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCalendarIntent = new Intent(Treinadores.this, CriarTreino.class);

                startActivity(mainCalendarIntent);
            }
        });

        edittreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCalendarIntent = new Intent(Treinadores.this, EditarTreino1.class);

                startActivity(mainCalendarIntent);
            }
        });

    }
}
