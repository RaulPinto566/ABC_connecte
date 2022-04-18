package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.Backend.Sistema;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class JogoJogadas extends AppCompatActivity {

    public FirebaseAuth mAuth;
    private Button ataqueButton,estatisticasButton,defesaButton,remateButton,faltaButton,balizaButton,falhadoButton,abandonarButton,periodoButton;
    private Boolean ataque,defesa,remate,falta,baliza,falhado;
    private String periodo="1";
    private Sistema pap;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadas);
        ataqueButton = findViewById(R.id.ataqueButton);
        defesaButton = findViewById(R.id.defesaButton);
        remateButton = findViewById(R.id.remateButton);
        faltaButton = findViewById(R.id.faltaButton);
        balizaButton = findViewById(R.id.balizaButton);
        falhadoButton = findViewById(R.id.falhadoButton);
        abandonarButton = findViewById(R.id.abandonarButton);
        periodoButton = findViewById(R.id.periodoButton);
        estatisticasButton = findViewById(R.id.estatisticasButton);
        ataqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ataqueButton.setSelected(!ataqueButton.isSelected());
                ataque = ataqueButton.isSelected();
                if (defesaButton.isSelected()) {
                    defesaButton.setSelected(false);
                    defesa = false;
                }
                Abrir();
                merdas();
            }
        });
        defesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defesaButton.setSelected(!defesaButton.isSelected());
                defesa = defesaButton.isSelected();
                if (ataqueButton.isSelected()) {
                    ataqueButton.setSelected(false);
                    ataque = false;
                }
                Abrir();
                merdas();
            }
        });
        remateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remateButton.setSelected(!remateButton.isSelected());
                remate = remateButton.isSelected();
                if (faltaButton.isSelected()) {
                    faltaButton.setSelected(false);
                    falta = false;
                }
                Abrir();
                merdas();
            }
        });
        faltaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faltaButton.setSelected(!faltaButton.isSelected());
                falta = faltaButton.isSelected();
                if (remateButton.isSelected()) {
                    remateButton.setSelected(false);
                    remate = false;
                }
                Abrir();
                merdas();
            }
        });
        balizaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balizaButton.setSelected(!balizaButton.isSelected());
                baliza = balizaButton.isSelected();
                if (falhadoButton.isSelected()) {
                    faltaButton.setSelected(false);
                    falta = false;
                }
                Abrir();
                merdas();
            }
        });
        falhadoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                falhadoButton.setSelected(!falhadoButton.isSelected());
                falhado = falhadoButton.isSelected();
                if (balizaButton.isSelected()) {
                    balizaButton.setSelected(false);
                    baliza = false;
                }
                Abrir();
                merdas();
            }
        });
        abandonarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        periodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periodo = "2";
            }
        });
        estatisticasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public void Abrir(){
        if ((ataque && remate && baliza)||(defesa&&remate&&baliza)) {
            Intent intent = new Intent(JogoJogadas.this, JogoJogadas1.class);
            startActivity(intent);
        } else {
            if ((ataque && remate && falhado)||(defesa&&remate&&falhado)) {
                Intent intent = new Intent(JogoJogadas.this, JogoJogadas2.class);
                startActivity(intent);
            } else {
                if ((defesa && falta)||(ataque&&falta&&baliza)||(ataque&&falta&&falhado)){
                    Intent intent = new Intent(JogoJogadas.this, JogoJogadas3.class);
                    startActivity(intent);
                }
            }
        }
    }
    public void merdas(){
        if(remate){
            balizaButton.setText("Baliza");
            falhadoButton.setText("Falhado");
        }
        if(ataque&&falta){
            balizaButton.setText("Realizada");
            falhadoButton.setText("Sofrida");
        }

    }
}