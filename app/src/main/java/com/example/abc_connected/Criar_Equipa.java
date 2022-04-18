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

public class Criar_Equipa extends AppCompatActivity {
    private ArrayList adpt,nome,email,list;
    private HashMap hash;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private TextView nomeequipa;
    private Button button_guardar;
    private String data,nometreinador,nomequipa,key;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference keyref;
    private DatabaseReference root = db.getReference().child("Atletas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    private DatabaseReference reet = db.getReference().child("Treinadores");
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_criar_equipa);
        listviewData = findViewById(R.id.window_list);
        button_guardar = findViewById(R.id.button_guardar);
        nomeequipa = findViewById(R.id.textinput);
        adpt = new ArrayList();
        list = new ArrayList();
        hash = new HashMap();
        email = new ArrayList();
        nome = new ArrayList();
        data = (String) FirebaseAuth.getInstance().getCurrentUser().getEmail();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    email.add(hash.get("Email"));
                    nome.add(hash.get("Nome"));
                    adpt.add("Nome:"+hash.get("Nome")+"\n"+"Escalao:"+hash.get("Escalao"));
                }
                adapter.notifyDataSetChanged();
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
                        nometreinador = (String)hash.get("Email");
                    }
                }
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
                nomequipa = nomeequipa .getText().toString().trim();
                CriarEquipa(raat,list,nometreinador,nomequipa);
                finish();
            }
        });
    }
    public void onOptionsItemSelected(){
        for(int i=0;i<listviewData.getCount();i++){
                if(listviewData.isItemChecked(i)) {
                    String word[]=listviewData.getItemAtPosition(i).toString().split("[:\n]");
                    for(int j = 0;j<nome.size();j++)
                    {
                        if(word[1].equals(nome.get(j))){
                            list.add(email.get(j));
                        }
                    }
                }
            }
    }
    public void CriarEquipa (DatabaseReference root, ArrayList lista,String treinador,String nome_equipa)
    {
        keyref = root.push();
        key = keyref.getKey();
        HashMap map = new HashMap();
        map.put("Nome_Equipa",nome_equipa);
        map.put("Treinador",treinador);
        map.put("Atletas", lista);
        map.put("Key",key);
        keyref.setValue(map);
    }
}
