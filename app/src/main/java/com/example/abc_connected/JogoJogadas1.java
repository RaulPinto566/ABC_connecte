package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JogoJogadas1 extends AppCompatActivity {
    private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,golotrue,golofalse,guardar,cancelar;
    private String distancia , lado;
    private Boolean golo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esquerda);
        distanci6 = findViewById(R.id.button6e);
        distancia7 = findViewById(R.id.button11e);
        distancia9 = findViewById(R.id.button12e);
        ladoesq = findViewById(R.id.button14e);
        ladocentro = findViewById(R.id.button15e);
        ladodireito = findViewById(R.id.button13e);
        golotrue = findViewById(R.id.button17e);
        golofalse = findViewById(R.id.button18e);
        guardar = findViewById(R.id.guardar5e);
        cancelar = findViewById(R.id.guardar6e);
        distanci6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distanci6.setSelected(!distanci6.isSelected());
                if(distancia7.isSelected()){
                    distancia7.setSelected(false);
                }
                if(distancia9.isSelected()){
                    distancia9.setSelected(false);
                }
                distancia = "6";
            }
        });
        distancia7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distancia7.setSelected(!distancia7.isSelected());
                if(distanci6.isSelected()){
                    distanci6.setSelected(false);
                }
                if(distancia9.isSelected()){
                    distancia9.setSelected(false);
                }
                distancia = "7";
            }
        });
        distancia9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distancia9.setSelected(!distancia9.isSelected());
                if(distancia7.isSelected()){
                    distancia7.setSelected(false);
                }
                if(distanci6.isSelected()){
                    distanci6.setSelected(false);
                }
                distancia = "9";
            }
        });
        ladoesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ladoesq.setSelected(ladoesq.isSelected());
                if(ladodireito.isSelected()){
                    ladodireito.setSelected(false);
                }
                if(ladocentro.isSelected()){
                    ladocentro.setSelected(false);
                }
                lado = "esquerda";
            }
        });
        ladocentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ladocentro.setSelected(ladocentro.isSelected());
                if(ladodireito.isSelected()){
                    ladodireito.setSelected(false);
                }
                if(ladoesq.isSelected()){
                    ladoesq.setSelected(false);
                }
                lado = "centro";
            }
        });
        ladodireito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ladodireito.setSelected(ladodireito.isSelected());
                if(ladocentro.isSelected()){
                    ladocentro.setSelected(false);
                }
                if(ladocentro.isSelected()){
                    ladocentro.setSelected(false);
                }
                lado = "direito";
            }
        });
        golotrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golotrue.setSelected(golotrue.isSelected());
                if(golofalse.isSelected()){
                    golofalse.setSelected(false);
                }
                golo = true;
            }
        });
        golofalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golofalse.setSelected(golofalse.isSelected());
                if(golotrue.isSelected()){
                    golotrue.setSelected(false);
                }
                golo = false;
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(golo){
                    Intent intent = new Intent(JogoJogadas1.this, JogoJogadas4.class);
                    startActivity(intent);
                }
                finish();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
