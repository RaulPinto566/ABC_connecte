package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class JogoJogadas2 extends AppCompatActivity {
    private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,cortetrue,cortefalse,guardar,cancelar;
    private String distancia, lado,key,b,d,atleta;
    private Boolean corte;
    private HashMap hash ,has,ha,h,c;
    private int soma,k;
    private ArrayList adpt,nome,email,list,lst;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference reet = db.getReference().child("Atletas");
    private DatabaseReference root = db.getReference().child("Jogadas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference ruut = db.getReference().child("Jogo");
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        key =  bundle.getString(JogoJogadas.EXTRA_MESSAG).trim();
        b = bundle.getString(JogoJogadas.EXTRA_MESS).trim();
        adpt = new ArrayList();
        h = new HashMap();
        lst = new ArrayList();
        ha = new HashMap();
        email = new ArrayList();
        nome = new ArrayList();
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
        listviewData = findViewById(R.id.window_list5);
        ruut.child(b).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                d = snapshot.child("Equipa").getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        reet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    h = (HashMap) dataSnapshot.getValue();
                    email.add(h.get("Email"));
                    nome.add(h.get("Nome"));
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
                    ha = (HashMap) dataSnapshot.getValue();
                    if(ha.get("Nome_Equipa").toString().equals(d)) {
                        lst = ((ArrayList)ha.get("Atletas"));
                        for(int j =0;j<email.size();j++) {
                            k=0;
                            for (int i = 0; i < lst.size(); i++) {
                                if(email.get(j).equals(lst.get(i))){
                                    k++;
                                }
                            }
                            if(k!=0){
                                adpt.add("Nome:"+nome.get(j));
                                System.out.println(nome.get(j));
                            }
                        }
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
                ladoesq.setSelected(!ladoesq.isSelected());
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
                ladocentro.setSelected(!ladocentro.isSelected());
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
                ladodireito.setSelected(!ladodireito.isSelected());
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
                cortetrue.setSelected(!cortetrue.isSelected());
                if(cortefalse.isSelected()){
                    cortefalse.setSelected(false);
                }
                corte = true;
            }
        });
        cortefalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cortefalse.setSelected(!cortefalse.isSelected());
                if(cortetrue.isSelected()){
                    cortetrue.setSelected(false);
                }
                corte = false;
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriarJogadas();
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
    public void CriarJogadas (){
        onOptionsItemSelected();
        root.child(key).child("Booleanos").child("Corte").setValue(corte);
        root.child(key).child("Strings").child("Atleta_Marcador").setValue(atleta);
        root.child(key).child("Strings").child("Lado_Campo").setValue(lado);
        root.child(key).child("Strings").child("Distancia").setValue(distancia);
    }
    public void onOptionsItemSelected(){
        soma=0;
        for(int i=0;i<listviewData.getCount();i++){
            if(listviewData.isItemChecked(i)) {
                soma++;
                String word[]=listviewData.getItemAtPosition(i).toString().split("[:]");
                for(int j = 0;j<nome.size();j++)
                {
                    if(word[1].equals(nome.get(j))){
                        atleta = (String)email.get(j);
                    }
                }
            }
        }
    }
}
