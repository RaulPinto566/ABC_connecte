package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class VerEstatísticas extends AppCompatActivity {
    private DecimalFormat def = new DecimalFormat("##.##");
    private TextView rc, rf,cf, atq, dfs,rmttt,glstt,e9,e7,e6,c9,c7,c6,d9,d7,d6;
    private int RematesCertos,RematesFalhados,CortesFeitos,Ataques,Defesas,RematesTotais,GolosTotais;
    private double es9,es7,es6,c99,c77,c66,d99,d77,d66,total,resultado;
    private String key;
    private Button sair;
    private HashMap hash;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogadas");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hash = new HashMap();
        Intent intent = getIntent();
        key = intent.getStringExtra("Id_Jogo");
        setContentView(R.layout.activty_estatisticas);
        rc = findViewById(R.id.rc);
        rf = findViewById(R.id.rf);
        cf = findViewById(R.id.cf);
        atq = findViewById(R.id.atq);
        dfs = findViewById(R.id.dfs);
        rmttt = findViewById(R.id.rmttt);
        glstt = findViewById(R.id.glstt);
        e9 = findViewById(R.id.e9);
        e7 = findViewById(R.id.e7);
        e6 = findViewById(R.id.e6);
        c9 = findViewById(R.id.c9);
        c7 = findViewById(R.id.c7);
        c6 = findViewById(R.id.c6);
        d9 = findViewById(R.id.d9);
        d7 = findViewById(R.id.d7);
        d6 = findViewById(R.id.d6);
        sair = findViewById(R.id.sair3333);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        root.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    hash = (HashMap) dataSnapshot.getValue();
                    if ((hash.get("Ataque") != null) || (hash.get("Defesa")!=null)) {
                        if ( (hash.get("Id_Jogo").equals(key))) {
                            if ((Boolean) hash.get("Ataque")) {
                                Ataques++;

                                if ((Boolean) hash.get("Remate")) {
                                    total++;
                                    System.out.println(hash.get("Lado_Campo"));
                                    if (hash.get("Lado_Campo") == null) {
                                        System.out.println(hash.get("Lado_Campo") + "ola");
                                    }
                                    else {
                                        System.out.println(hash.get("Lado_Campo") + "ola2");
                                        if (((hash.get("Lado_Campo")).equals("esquerda")) && ((hash.get("Distancia")).equals("9") )) {
                                            es9++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("esquerda")) && ((hash.get("Distancia")).equals("7"))) {

                                            es7++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("esquerda")) && ((hash.get("Distancia")).equals("6"))) {
                                            es6++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")).equals("9"))) {
                                            c99++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")).equals("7"))) {
                                            c77++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")).equals("6"))) {
                                            c66++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")).equals("9"))) {
                                            d99++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")).equals("7"))) {
                                            d77++;
                                        }
                                        if ((( hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")).equals("6"))) {
                                            d66++;
                                        }
                                    }
                                }
                            }
                        }

                        if ((hash.get("Defesa") != null) && (hash.get("Remate") != null) && (hash.get("Falhado") != null)) {
                            if ((Boolean) hash.get("Defesa")) {
                                if ((Boolean) hash.get("Remate")) {
                                    if ((Boolean) hash.get("Falhado")) {
                                        CortesFeitos++;
                                    }
                                }
                                Defesas++;
                            }
                            if ((hash.get("Golo") != null)) {
                                if ((Boolean) hash.get("Golo")) {
                                    GolosTotais++;
                                }
                            }
                            if ((hash.get("Remate") != null) && (hash.get("Golo") != null)) {
                                if ((Boolean) hash.get("Remate")) {
                                    if ((Boolean) hash.get("Golo")) {
                                        RematesCertos++;
                                    } else {
                                        RematesFalhados++;
                                    }
                                    RematesTotais++;
                                }
                            }
                        }
                    }
                }
                guardar();
                }
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public  void guardar(){
        if(total==0){
            e9.setText(String.valueOf(0));
            e7.setText(String.valueOf(0));
            e6.setText(String.valueOf(0));
            c9.setText(String.valueOf(0));
            c7.setText(String.valueOf(0));
            c6.setText(String.valueOf(0));
            d9.setText(String.valueOf(0));
            d7.setText(String.valueOf(0));
            d6.setText(String.valueOf(0));
        }
        else {
System.out.println(es9/total);
            e9.setText(String.valueOf(def.format(es9/total)));
            e7.setText(String.valueOf(def.format(es7/total)));
            e6.setText(String.valueOf(def.format(es6/total)));
            c9.setText(String.valueOf(def.format(c99/total)));
            c7.setText(String.valueOf(def.format(c77/total)));
            c6.setText(String.valueOf(def.format(c66/total)));
            d9.setText(String.valueOf(def.format(d99/total)));
            d7.setText(String.valueOf(def.format(d77/total)));
            d6.setText(String.valueOf(def.format(d66/total)));
            rc.setText(String.valueOf(RematesCertos));
            rf.setText(String.valueOf(RematesFalhados));
            rmttt.setText(String.valueOf(RematesTotais));
            cf.setText(String.valueOf(CortesFeitos));
            atq.setText(String.valueOf(Ataques));
            dfs.setText(String.valueOf(Defesas));
            glstt.setText(String.valueOf(GolosTotais));
        }
    }
}
