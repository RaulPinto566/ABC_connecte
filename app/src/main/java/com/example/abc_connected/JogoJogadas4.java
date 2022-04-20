package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JogoJogadas4 extends AppCompatActivity {

    private Button cantosuperiordireito,cantoinferioresquerdo,cantosuperioresquerdo,cantoinferiordireito,centrobaixo,centrocima,centro,centroesquerdo,centrodireito,guardar,cancelar;
    private String dados,key;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogadas");
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baliza);
        Intent intent = getIntent();
        key =  intent.getStringExtra("Id_Jogada");
        cantosuperiordireito = findViewById(R.id.canto_superior_direito);
        centrobaixo = findViewById(R.id.centro_baixo);
        centrocima = findViewById(R.id.centro_cima);
        cantoinferioresquerdo = findViewById(R.id.canto_inferior_esquerdo);
        centro = findViewById(R.id.centro);
        centroesquerdo = findViewById(R.id.centro_esquerdo);
        cantosuperioresquerdo = findViewById(R.id.canto_superior_esquerdo);
        cantoinferiordireito = findViewById(R.id.canto_inferior_direito);
        centrodireito = findViewById(R.id.centro_direito);
        guardar = findViewById(R.id.guardar);
        cancelar = findViewById(R.id.guardar2);
        cantoinferiordireito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantoinferiordireito.setSelected(!cantoinferiordireito.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "cantoinferiordireito";
            }
        });
        cantoinferioresquerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantoinferioresquerdo.setSelected(!cantoinferioresquerdo.isSelected());
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "cantoinferioresquerdo";
            }
        });
        cantosuperiordireito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantosuperiordireito.setSelected(!cantosuperiordireito.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "cantosuperiordireito";
            }
        });
        cantosuperioresquerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantosuperioresquerdo.setSelected(!cantosuperioresquerdo.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "cantoinferioresquerdo";
            }
        });
        centro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centro.setSelected(!centro.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "centro";
            }
        });
        centrobaixo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centrobaixo.setSelected(!centrobaixo.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "centrobaixo";
            }
        });
        centrocima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centrocima.setSelected(!centrocima.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "centrocima";
            }
        });
        centrodireito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centrodireito.setSelected(!centrodireito.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centroesquerdo.isSelected()) {
                    centroesquerdo.setSelected(false);
                }
                dados = "centrodireito";
            }
        });
        centroesquerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centroesquerdo.setSelected(!centroesquerdo.isSelected());
                if (cantoinferioresquerdo.isSelected()) {
                    cantoinferioresquerdo.setSelected(false);
                }
                if (cantosuperiordireito.isSelected()) {
                    cantosuperiordireito.setSelected(false);
                }
                if (cantoinferiordireito.isSelected()) {
                    cantoinferiordireito.setSelected(false);
                }
                if (cantosuperioresquerdo.isSelected()) {
                    cantosuperioresquerdo.setSelected(false);
                }
                if (centro.isSelected()) {
                    centro.setSelected(false);
                }
                if (centrobaixo.isSelected()) {
                    centrobaixo.setSelected(false);
                }
                if (centrocima.isSelected()) {
                    centrocima.setSelected(false);
                }
                if (centrodireito.isSelected()) {
                    centrodireito.setSelected(false);
                }
                dados = "centroesquerdo";
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.child(key).child("Strings").child("Zona_Baliza").setValue(dados);
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
