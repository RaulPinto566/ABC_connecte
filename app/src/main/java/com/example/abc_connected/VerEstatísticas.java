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

import java.util.ArrayList;
import java.util.HashMap;

public class VerEstatísticas extends AppCompatActivity {
    private TextView rc, rf,cf, atq, dfs,rmttt,glstt,e9,e7,e6,c9,c7,c6,d9,d7,d6;
    private int RematesCertos,RematesFalhados,CortesFeitos,Ataques,Defesas,RematesTotais,GolosTotais,total,es9,es7,es6,c99,c77,c66,d99,d77,d66;
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
                    if ((null != hash.get("Ataque")) && (hash.get("Id_Jogo").equals(key))) {
                        if ((Boolean) hash.get("Ataque")) {
                            Ataques++;
                            if ((Boolean) hash.get("Remate")) {
                                total++;
                                if ((((String) hash.get("Lado_Campo")).equals("esquerdo")) && ((hash.get("Distancia")) == "9")) {
                                    es9++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("esquerdo")) && ((hash.get("Distancia")) == "7")) {
                                    es7++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("esquerdo")) && ((hash.get("Distancia")) == "6")) {
                                    es6++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")) == "9")) {
                                    c99++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")) == "7")) {
                                    c77++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("centro")) && ((hash.get("Distancia")) == "6")) {
                                    c66++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")) == "9")) {
                                    d99++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")) == "7")) {
                                    d77++;
                                }
                                if ((((String) hash.get("Lado_Campo")).equals("direito")) && ((hash.get("Distancia")) == "6")) {
                                    d66++;
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
            e9.setText(String.valueOf((double) (Math.round((es9 / total) * 10) / 10)));
            e7.setText(String.valueOf((double) (Math.round((es7 / total) * 10) / 10)));
            e6.setText(String.valueOf((double) (Math.round((es6 / total) * 10) / 10)));
            c9.setText(String.valueOf((double) (Math.round((c99 / total) * 10) / 10)));
            c7.setText(String.valueOf((double) (Math.round((c77 / total) * 10) / 10)));
            c6.setText(String.valueOf((double) (Math.round((c66 / total) * 10) / 10)));
            d9.setText(String.valueOf((double) (Math.round((d99 / total) * 10) / 10)));
            d7.setText(String.valueOf((double) (Math.round((d77 / total) * 10) / 10)));
            d6.setText(String.valueOf((double) (Math.round((d66 / total) * 10) / 10)));
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
