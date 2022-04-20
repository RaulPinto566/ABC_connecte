package com.example.abc_connected;

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

public class JogoJogadas3 extends AppCompatActivity {

      private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,guardar,cancelar;
      private ListView window_list6;
      private int soma;
      private ArrayAdapter adapter;
      private ArrayList adpt,list,email,nome,lst;
      private HashMap hash,h,ha;
      private String distancia,lado,b,key,d,atleta;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference reet = db.getReference().child("Atletas");
    private DatabaseReference root = db.getReference().child("Jogadas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference ruut = db.getReference().child("Jogo");
      @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
          Bundle bundle = getIntent().getExtras();
          key =  bundle.getString(JogoJogadas.EXTRA_MESSAG).trim();
          b = bundle.getString(JogoJogadas.EXTRA_MESS).trim();
            setContentView(R.layout.direita);
            distanci6 = findViewById(R.id.button6c);
            distancia7 = findViewById(R.id.button11c);
            distancia9 = findViewById(R.id.button12c);
            ladoesq = findViewById(R.id.button14c);
            ladocentro = findViewById(R.id.button15c);
            ladodireito = findViewById(R.id.button13c);
            guardar = findViewById(R.id.guardar5c);
            cancelar = findViewById(R.id.guardar6c);
            window_list6 = findViewById(R.id.window_list6);
            adpt = new ArrayList();
            list = new ArrayList();
            hash = new HashMap();
            email = new ArrayList();
            nome = new ArrayList();
            h = new HashMap();
            ha = new HashMap();
            lst = new ArrayList();
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
                              for (int i = 0; i < lst.size(); i++) {
                                  if(email.get(j).equals(lst.get(i))){
                                      adpt.add("Nome:"+nome.get(j));
                                  }
                              }
                              adapter.notifyDataSetChanged();
                          }
                      }
                  }
              }
              @Override
              public void onCancelled(@NonNull DatabaseError error) {
              }
          });
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);
            window_list6.setAdapter(adapter);

            distanci6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distanci6.setSelected(!distanci6.isSelected());

                    if (distancia7.isSelected()) {
                        distancia7.setSelected(false);
                    }

                    if (distancia9.isSelected()) {
                        distancia9.setSelected(false);
                    }
                    distancia = "6";
                }

            });
            distancia7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distancia7.setSelected(!distancia7.isSelected());
                    if (distanci6.isSelected()){
                        distanci6.setSelected(false);
                    }
                    if (distancia9.isSelected()){
                        distancia9.setSelected(false);
                    }
                    distancia = "7";
                }
            });
            distancia9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distancia9.setSelected(!distancia9.isSelected());

                    if (distanci6.isSelected()){
                        distanci6.setSelected(false);
                    }
                    if (distancia7.isSelected()){
                        distancia7.setSelected(false);
                    }
                    distancia = "9";
                }
            });
            ladoesq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladoesq.setSelected(!ladoesq.isSelected());
                    if (ladocentro.isSelected()){
                        ladocentro.setSelected(false);
                    }
                    if (ladodireito.isSelected()){
                        ladodireito.setSelected(false);
                    }
                    lado = "esquerdo";

                }
            });
            ladocentro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladocentro.setSelected(!ladocentro.isSelected());
                    if (ladoesq.isSelected()){
                        ladoesq.setSelected(false);
                    }
                    if (ladodireito.isSelected()){
                        ladodireito.setSelected(false);
                    }
                    lado = "centro";

                }
            });
            ladodireito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladodireito.setSelected(!ladodireito.isSelected());
                    if (ladoesq.isSelected()){
                        ladoesq.setSelected(false);
                    }
                    if (ladocentro.isSelected()){
                        ladocentro.setSelected(false);
                    }
                    lado = "direito";
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
        root.child(key).child("Strings").child("Atleta_Marcador").setValue(atleta);
        root.child(key).child("Strings").child("Lado_Campo").setValue(lado);
        root.child(key).child("Strings").child("Distancia").setValue(distancia);
    }
    public void onOptionsItemSelected(){
        soma=0;
        for(int i=0;i<window_list6.getCount();i++){
            if(window_list6.isItemChecked(i)) {
                soma++;
                String word[]=window_list6.getItemAtPosition(i).toString().split("[:]");
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
