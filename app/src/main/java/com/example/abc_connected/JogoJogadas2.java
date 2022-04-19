package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JogoJogadas2 extends AppCompatActivity {
    private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,cortetrue,cortefalse,guardar,cancelar;
    private String distancia, lado;
    private Boolean corte;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remate);
        distanci6 = findViewById(R.id.button6d);
        distancia7 = findViewById(R.id.button11d);
        distancia9 = findViewById(R.id.button12d);
        ladoesq = findViewById(R.id.button14d);
        ladocentro = findViewById(R.id.button15d);
        ladodireito = findViewById(R.id.button13d);
        cortetrue = findViewById(R.id.button16d);
        cortefalse = findViewById(R.id.button5d);
        guardar = findViewById(R.id.guardar5d);
        cancelar = findViewById(R.id.guardar6d);

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
                if(ladoesq.isSelected()){
                    ladoesq.setSelected(false);
                }
                lado = "direito";
            }
        });
        cortetrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cortetrue.setSelected(cortetrue.isSelected());
                if(cortefalse.isSelected()){
                    cortefalse.setSelected(false);
                }
                corte = true;
            }
        });
        cortefalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cortefalse.setSelected(cortefalse.isSelected());
                if(cortetrue.isSelected()){
                    cortetrue.setSelected(false);
                }
                corte = false;
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
