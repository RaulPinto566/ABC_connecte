package com.example.abc_connected;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class CriarJogo extends AppCompatActivity {

    private Button guardarButton;
    private ArrayList adpt,list;
    private HashMap hash;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private TextView equipa;
    private String nmequipa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Jogo");


    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.criar_jogo);
        listviewData = findViewById(R.id.window_list2);
        adpt = new ArrayList<>();
        hash = new HashMap();
        list = new ArrayList<>();
        equipa = findViewById(R.id.textView19);
        guardarButton = findViewById(R.id.guardarButton);
        root.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    adpt.add("Equipa: "+hash.get("Equipa"));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected();
                CriarJogo();
                finish();
            }
        });

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);
        listviewData.setAdapter(adapter);
    }


    public void onOptionsItemSelected(){
        for(int i=0;i<listviewData.getCount();i++){
            if(listviewData.isItemChecked(i)) {
                String word[]=listviewData.getItemAtPosition(i).toString().split("[:\n]");
                list.add(word[1]);
            }
        }
        nmequipa = equipa .getText().toString().trim();
    }
}
