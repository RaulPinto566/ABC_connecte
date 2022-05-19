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

public class EditarEquipa2 extends AppCompatActivity {
    private ArrayList adpt,list,lst,ls,email,nome,escalao;
    private String dat;
    private int soma;
    private HashMap hash,has,ha,h;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar;
    private String data,nometreinador,nomequipa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Atletas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference reet = db.getReference().child("Treinadores");
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_criar_equipa);
        listviewData = findViewById(R.id.window_list);
        button_guardar = findViewById(R.id.button_guardar);
        nomequipa = getIntent().getStringExtra(EditarEquipa1.extra);
        adpt = new ArrayList();
        list = new ArrayList();
        hash = new HashMap();
        nome = new ArrayList();
        email = new ArrayList();
        escalao = new ArrayList();
        data = (String) FirebaseAuth.getInstance().getCurrentUser().getEmail();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    email.add(hash.get("Email"));
                    nome.add(hash.get("Nome"));
                    escalao.add(hash.get("Escalao"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        raat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                for(DataSnapshot dataSnapshot1 : snapshot1.getChildren()) {
                    has = (HashMap) dataSnapshot1.getValue();
ls = (ArrayList) has.get("Atletas");
                    if (has.get("Nome_Equipa").toString().equals(nomequipa)) {
                        dat = (String)has.get("Key");
                        lst = (ArrayList)has.get("Atletas");
                        for(int j = 0;j<nome.size();j++) {
                            soma=0;
                            for (int i = 0; i < (lst.size()); i++) {
                                if (email.get(j).toString().equals(lst.get(i))) {
                                    soma++;
                                }
                            }
                            if(soma == 0){
                                adpt.add("Nome:" + nome.get(j) + "\n" + "Escalao:" + escalao.get(j));
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
        reet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    h = (HashMap) dataSnapshot.getValue();
                    if(data.equals((String)h.get("Email"))){
                        nometreinador = (String)h.get("Email");
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
                onOptionsItemSelected();
                for(int j =0;j<nome.size();j++) {
                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i).equals(nome.get(j).toString())){
                            ls.add(email.get(j));
                        }
                    }
                }
                ha = new HashMap();
                ha.put("Nome_Equipa",nomequipa);
                ha.put("Treinador",nometreinador);
                ha.put("Atletas", ls);
                raat.child(dat).updateChildren(ha);
                finish();
            }
        });
    }
    public void onOptionsItemSelected(){
        for(int i=0;i<listviewData.getCount();i++){
            if(listviewData.isItemChecked(i)) {
                String word[]=listviewData.getItemAtPosition(i).toString().split("[:\n]");
                list.add(word[1]);
            }
        }
    }
}
