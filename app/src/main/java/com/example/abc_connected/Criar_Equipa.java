package com.example.abc_connected;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.model.Model;
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
    private ArrayList adpt,list;
    private HashMap hash;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Atletas");
    private DatabaseReference raat = db.getReference().child("Equipas");
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_criar_equipa);
        listviewData = findViewById(R.id.window_list);
        button_guardar = findViewById(R.id.button_guardar);
        adpt = new ArrayList();
        list = new ArrayList();
        hash = new HashMap();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    adpt.add("Nome:"+hash.get("Nome")+"\n"+"Escalao:"+hash.get("Escalao"));
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
                CriarEquipa(raat,list,"Treinador");
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
    public void CriarEquipa (DatabaseReference root, ArrayList list,String treinador)
    {
        HashMap map = new HashMap();
        map.put("Treinador",treinador);
        map.put("Atletas", list);
        root.push().setValue(map);
    }
}
