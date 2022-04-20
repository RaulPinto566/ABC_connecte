package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.Backend.Sistema;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class JogoJogadas extends AppCompatActivity {
    public static final String EXTRA_MESSAG = "com.example.abc_connected.JogoJogadas1";
    public static final String EXTRA_MESS = "com.example.abc_connected.JogoJogadas1";
    public FirebaseAuth mAuth;
    private Button ataqueButton,estatisticasButton,defesaButton,remateButton,faltaButton,balizaButton,falhadoButton,abandonarButton,periodoButton;
    private Boolean ataque=false,defesa=false,remate=false,falta=false,baliza=false,falhado=false;
    private String periodo ="1",key,ky;
    private DatabaseReference keyref;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogadas");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        ky =  bundle.getString(ListaJogo.nmqp);
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
            CriarJogadas();
            Intent intent = new Intent(JogoJogadas.this, JogoJogadas1.class);
            intent.putExtra(EXTRA_MESSAG,key);
            intent.putExtra(EXTRA_MESS,ky);
            startActivity(intent);
        } else {
            if ((ataque && remate && falhado)||(defesa&&remate&&falhado)) {
                CriarJogadas();
                Intent intent = new Intent(JogoJogadas.this, JogoJogadas2.class);
                intent.putExtra(EXTRA_MESSAG,key);
                intent.putExtra(EXTRA_MESS,ky);
                startActivity(intent);
            } else {
                if ((defesa && falta)||(ataque&&falta&&baliza)||(ataque&&falta&&falhado)){
                    CriarJogadas();
                    Intent intent = new Intent(JogoJogadas.this, JogoJogadas3.class);
                    intent.putExtra(EXTRA_MESSAG,key);
                    intent.putExtra(EXTRA_MESS,ky);
                    startActivity(intent);
                }
            }
        }
    }
    public void CriarJogadas (){
        keyref = root.push();
        key = keyref.getKey();
        HashMap map = new HashMap();
        map.put("Ataque" ,ataque);
        map.put("Defesa",defesa);
        map.put("Falta",falta);
        map.put("Falhado",falhado);
        map.put("Sofrida",falhado);
        map.put("Cometida",baliza);
        map.put("Remate",remate);
        map.put("Baliza",baliza);
        HashMap mep = new HashMap();
        mep.put("Periodo",periodo);
        mep.put("Id_Jogada",key);
        mep.put("Id_Jogo",ky);
        keyref.child("Booleanos").setValue(map);
        keyref.child("Strings").setValue(mep);
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