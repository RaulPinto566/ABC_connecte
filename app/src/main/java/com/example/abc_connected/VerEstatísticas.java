package com.example.abc_connected;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    private TextInputLayout rc, rf,cf, atq, dfs,rmttt,glstt,e9,e7,e6,c9,c7,c6,d9,d7,d6;
    private Button sair;
    private HashMap hash;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogadas");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hash = new HashMap();
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
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                        hash = (HashMap) dataSnapshot1.getChildren();
                        if()
                        {

                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}
