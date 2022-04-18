package com.example.abc_connected;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class CriarJogo extends AppCompatActivity {
    private int soma;
    private Button guardarButton;
    private ArrayList adpt,list;
    private HashMap hash;
    private ListView listviewData;
    private EditText localjogo,equipaadv,competicao,jornada;
    private ArrayAdapter adapter;
    private TextView equipa;
    private String nometreinador,nmequipa,key;
    private DatabaseReference keyref;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogo");
    private DatabaseReference raat = db.getReference().child("Equipas");
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_criar_jogo);
        localjogo = findViewById(R.id.localjogo);
        equipaadv = findViewById(R.id.equipaadv);
        competicao = findViewById(R.id.competicao);
        jornada = findViewById(R.id.jornada);
        listviewData = findViewById(R.id.window_list2);
        adpt = new ArrayList<>();
        hash = new HashMap();
        list = new ArrayList<>();
        equipa = findViewById(R.id.textView19);
        guardarButton = findViewById(R.id.guardarButton);
        nometreinador = (String) FirebaseAuth.getInstance().getCurrentUser().getEmail();
        raat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    hash = (HashMap) dataSnapshot.getValue();
                    if(hash.get("Treinador").toString().equals(nometreinador)) {
                        adpt.add((String)hash.get("Nome_Equipa"));
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
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected();
                if(soma!=1){
                    guardarButton.setError("Selecione apenas uma equipa.");
                }
                else{
                    for(int i=0;i<listviewData.getCount();i++){
                        if(listviewData.isItemChecked(i)) {
                            nmequipa = listviewData.getItemAtPosition(i).toString();
                        }
                    }
                    CriarJogo(root,nmequipa,equipaadv.getText().toString().trim(),localjogo.getText().toString().trim(),competicao.getText().toString().trim(),jornada.getText().toString().trim());
                    finish();
                }
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
    public void CriarJogo (DatabaseReference root, String equipa, String equipa_adv, String local, String competicao,String n_jornada)
    {
        keyref = root.push();
        key = keyref.getKey();
        HashMap map = new HashMap();
        map.put("Id_jogo",key);
        map.put("Equipa", equipa);
        map.put("Equipa_Adv", equipa_adv);
        map.put("Local", local);
        map.put("Competicao", competicao);
        map.put("N_Jornada", n_jornada);
        keyref.setValue(map);
    }
}