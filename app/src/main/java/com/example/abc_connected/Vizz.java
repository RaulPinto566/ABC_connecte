package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.firebase.ui.database.FirebaseArray;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Vizz extends AppCompatActivity {

    private ArrayList adpt,list,lista;
    private TextView nomeequipa;
    private int soma;
    public static final String nmqp="";
    private String data,nometreinador,nome_equipa;
    private HashMap hash,has;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar,adicionaratleta,retiraratleta,trocartreinador,trocarnomeequipa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("treinos");
    private DatabaseReference raat = db.getReference().child("treinos");
    private DatabaseReference reet = db.getReference().child("Ateleta");

    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_vizz2);
        listviewData = findViewById(R.id.window_list12);

        adicionaratleta =findViewById(R.id.adicionaratleta);
        retiraratleta = findViewById(R.id.retiraratleta);
        trocartreinador = findViewById(R.id.trocartreinador);
        trocarnomeequipa = findViewById(R.id.trocarnomeequipa);
        adpt = new ArrayList();
        list = new ArrayList();
        lista = new ArrayList();
        hash = new HashMap();
        has = new HashMap();
        data = (String) FirebaseAuth.getInstance().getCurrentUser().getEmail();
        reet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    if(data.equals((String)hash.get("Nome"))){
                        nometreinador = (String)hash.get("Nome");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        raat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    has = (HashMap) dataSnapshot.getValue();

                        adpt.add("Data: " + has.get("Data") + "  Hora: " + has.get("Hora") + "\n" + "Local: " + has.get("Local") + "  Equipa: " + has.get("Equipa"));

                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);
        listviewData.setAdapter(adapter);

    }
    public void onOptionsItemSelected(){
        soma=0;
        for(int i=0;i<listviewData.getCount();i++){
            if(listviewData.isItemChecked(i)) {
                soma++;
            }
        }
    }


    }

