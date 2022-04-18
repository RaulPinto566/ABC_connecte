package com.example.abc_connected;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.model.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.internal.cache.DiskLruCache;

public class EditarEquipa5 extends AppCompatActivity {
    private ArrayList adpt,list,lst,ls;
    private String dat;
    private HashMap hash,has,ha;
    private ArrayAdapter adapter;
    private TextView nomeequipa;
    private Button button_guardar;
    private String data,nometreinador,nomequipa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Atletas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference reet = db.getReference().child("Treinadores");
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_editar_equipa1);
        nomeequipa = findViewById(R.id.textnomeequip);
        button_guardar = findViewById(R.id.sair);
        nomequipa = getIntent().getStringExtra(EditarEquipa1.extra);
        adpt = new ArrayList();
        list = new ArrayList();
        hash = new HashMap();
        data = (String) FirebaseAuth.getInstance().getCurrentUser().getEmail();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    raat.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                has = (HashMap) dataSnapshot.getValue();
                                dat = (String)has.get("Key");
                                ls = (ArrayList) has.get("Atletas");
                                if (has.get("Nome_Equipa").toString().equals(nomequipa)) {
                                    lst = (ArrayList)has.get("Atletas");
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    if(data.equals((String)hash.get("Email"))){
                        nometreinador = (String)hash.get("Nome");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nometreinador = nomeequipa.getText().toString().trim();
                ha = new HashMap();
                ha.put("Nome_Equipa",nomequipa);
                ha.put("Treinador",nometreinador);
                ha.put("Atletas", lst);
                raat.child(dat).updateChildren(ha);
                finish();
            }
        });
    }
}
