package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class ListaJogo extends AppCompatActivity {
    public static final String EXTRA_MESSAG = "com.example.abc_connected.JogoJogadas1";
    private ArrayList adpt;
    private int soma;
    public static final String nmqp = "";
    private String data, nometreinador, nome_equipa;
    private HashMap hash, has;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference raat = db.getReference().child("Jogo");

    @Override
    protected void onCreate(Bundle savedinstance) {
        super.onCreate(savedinstance);
        setContentView(R.layout.activity_criar_equipa);
        listviewData = findViewById(R.id.window_list);
        button_guardar = findViewById(R.id.button_guardar);
        adpt = new ArrayList();
        hash = new HashMap();
        has = new HashMap();
        raat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    has = (HashMap) dataSnapshot.getValue();
                    adpt.add((String)"Competicao:"+has.get("Competicao")+"\n"+"Equipa:"+has.get("Equipa")+"\n"+"Id_Jogo:"+has.get("Id_jogo"));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, adpt);
        listviewData.setAdapter(adapter);
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected();
                if (soma != 1) {
                    button_guardar.setError("Selecione apenas uma equipa.");
                } else {
                    Intent intent = new Intent(ListaJogo.this, JogoJogadas.class);
                    for (int i = 0; i < listviewData.getCount(); i++) {
                        if (listviewData.isItemChecked(i)) {
                            String word[]=listviewData.getItemAtPosition(i).toString().split("[:\n]");
                            nome_equipa = word[5];
                        }
                    }
                    intent.putExtra(nmqp, nome_equipa);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void onOptionsItemSelected() {
        soma = 0;
        for (int i = 0; i < listviewData.getCount(); i++) {
            if (listviewData.isItemChecked(i)) {
                soma++;
            }
        }
    }
}