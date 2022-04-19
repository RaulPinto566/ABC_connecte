package com.example.abc_connected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class CriarTreino extends AppCompatActivity {

    private ArrayList adpt,list,lista;
    private TextView nomeequipa;
    private int soma;
    public static final String nmqp="";
    private String data,nometreinador,nome_equipa;
    private HashMap hash,has;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar;
    EditText locall;
    EditText dataa;
    EditText horaa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("treinos");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference reet = db.getReference().child("Treinadores");

    public void CriarTreino (DatabaseReference root, String equipa,  String local, String data,String hora)
    {
        HashMap map = new HashMap();
        map.put("Equipa", equipa);
        map.put("Local", local);
        map.put("Data", data);
        map.put("Hora", hora);
        root.push().setValue(map);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_treino);
        listviewData = findViewById(R.id.window_list2);
        button_guardar = findViewById(R.id.criar22);
        locall = findViewById(R.id.local);
        horaa = findViewById(R.id.hora);
        dataa = findViewById(R.id.data);

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
                    if(data.equals((String)hash.get("Email"))){
                        nometreinador = (String)hash.get("Email");
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
                    if(has.get("Treinador").toString().equals(nometreinador)) {
                        adpt.add((String)has.get("Nome_Equipa"));
                    }
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);
        listviewData.setAdapter(adapter);
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected();
                if(soma!=1){
                    button_guardar.setError("Selecione apenas uma equipa.");
                }
                else{

                    for(int i=0;i<listviewData.getCount();i++){
                        if(listviewData.isItemChecked(i)) {
                            nome_equipa = listviewData.getItemAtPosition(i).toString();
                        }
                    }

                }

                String equi = nome_equipa;
                String lo = locall.getText().toString().trim();
                String hor = horaa.getText().toString().trim();
                String dat = dataa.getText().toString().trim();

                System.out.println(nome_equipa);

                CriarTreino(root,equi,lo,dat,hor);
            }
        });

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
