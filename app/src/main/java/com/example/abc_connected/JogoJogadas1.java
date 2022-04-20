package com.example.abc_connected;

import android.content.Intent;
import android.icu.text.SymbolTable;
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

public class JogoJogadas1 extends AppCompatActivity {
    public static final String EXTRA_MESSA = "com.example.abc_connected.JogoJogadas4";
    private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,golotrue,golofalse,guardar,cancelar;
    private String distancia , lado,key,b,d,atleta_assistencia,atleta_marcador;
    private HashMap hash ,has,ha,h,c;
    private int soma,k;
    private ArrayList adpt,nome,email,list,lst;
    private ListView listviewData,listviewDat;
    private ArrayAdapter adapter;
    private Boolean golo;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference reet = db.getReference().child("Atletas");
    private DatabaseReference root = db.getReference().child("Jogadas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference ruut = db.getReference().child("Jogo");
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        adpt = new ArrayList();
        h = new HashMap();
        lst = new ArrayList();
        ha = new HashMap();
        email = new ArrayList();
        nome = new ArrayList();
        key =  bundle.getString(JogoJogadas.EXTRA_MESSAG).trim();
        b = bundle.getString(JogoJogadas.EXTRA_MESS).trim();
        setContentView(R.layout.esquerda);
        listviewData = findViewById(R.id.window_list3);
        listviewDat = findViewById(R.id.window_list4);
        distanci6 = findViewById(R.id.button6e);
        distancia7 = findViewById(R.id.button11e);
        distancia9 = findViewById(R.id.button12e);
        ladoesq = findViewById(R.id.button14e);
        ladocentro = findViewById(R.id.button15e);
        ladodireito = findViewById(R.id.button13e);
        golotrue = findViewById(R.id.button17e);
        golofalse = findViewById(R.id.button18e);
        guardar = findViewById(R.id.guardar5e);
        cancelar = findViewById(R.id.guardar6e);
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
        listviewDat.setAdapter(adapter);
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
                if(ladocentro.isSelected()){
                    ladocentro.setSelected(false);
                }
                lado = "direito";
            }
        });
        golotrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golotrue.setSelected(!golotrue.isSelected());
                if(golofalse.isSelected()){
                    golofalse.setSelected(false);
                }
                golo = true;
            }
        });
        golofalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golofalse.setSelected(!golofalse.isSelected());
                if(golotrue.isSelected()){
                    golotrue.setSelected(false);
                }
                golo = false;
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriarJogadas();
                if(golo){
                    Intent intent = new Intent(JogoJogadas1.this, JogoJogadas4.class);
                    intent.putExtra(EXTRA_MESSA,key);
                    startActivity(intent);
                }
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
        root.child(key).child("Booleanos").child("Golo").setValue(golo);
        root.child(key).child("Strings").child("Atleta_Marcador").setValue(atleta_marcador);
        root.child(key).child("Strings").child("Atleta_Assistencia").setValue(atleta_assistencia);
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
                        atleta_marcador = (String)email.get(j);
                    }
                }
            }
        }
        for(int i=0;i<listviewDat.getCount();i++){
            if(listviewDat.isItemChecked(i)) {
                String wor[]=listviewDat.getItemAtPosition(i).toString().split("[:]");
                for(int j = 0;j<nome.size();j++)
                {
                    if(wor[1].equals(nome.get(j))){
                        atleta_assistencia = (String)email.get(j);
                    }
                }
            }
        }
    }
}
