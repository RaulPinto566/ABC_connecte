package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EditarEquipa1 extends AppCompatActivity {
    public static final String extra="";
    private Button adicionaratleta,retiraratleta,trocartreinador,trocarnomeequipa,sair;
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_editar_equipa);
        adicionaratleta =findViewById(R.id.adicionaratleta);
        retiraratleta = findViewById(R.id.retiraratleta);
        trocartreinador = findViewById(R.id.trocartreinador);
        trocarnomeequipa = findViewById(R.id.trocarnomeequipa);
        sair = findViewById(R.id.sair);
        adicionaratleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarEquipa1.this,EditarEquipa2.class);
                intent.putExtra(extra,getIntent().getStringExtra(EditarEquipa.nmqp));
                startActivity(intent);
            }
        });
        retiraratleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarEquipa1.this,EditarEquipa3.class);
                intent.putExtra(extra,getIntent().getStringExtra(EditarEquipa.nmqp));
                startActivity(intent);
            }
        });
        trocarnomeequipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarEquipa1.this,EditarEquipa4.class);
                intent.putExtra(extra,getIntent().getStringExtra(EditarEquipa.nmqp));
                startActivity(intent);
            }
        });
        trocartreinador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarEquipa1.this,EditarEquipa5.class);
                intent.putExtra(extra,getIntent().getStringExtra(EditarEquipa.nmqp));
                startActivity(intent);
            }
        });
       sair.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
    }
}

