package com.example.abc_connected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class Apagar extends AppCompatActivity {
    private ArrayList adpt,list,lista;
    private TextView nomeequipa;
    private int soma;
    public static final String nmqp="";
    private String data,nome_equipa, nometreinador, alerta;
    private HashMap hash,has, haslh;
    private ListView listviewData;
    private ArrayAdapter adapter;
    private Button button_guardar,adicionaratleta,retiraratleta,trocartreinador,trocarnomeequipa;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("treinos");
    private DatabaseReference raat = db.getReference().child("Alerta");
    private DatabaseReference reet = db.getReference().child("Ateleta");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apagar);
        listviewData = findViewById(R.id.window_list666);
button_guardar = findViewById(R.id.button_guardar545);

        adpt = new ArrayList();
        has = new HashMap();


        raat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    has = (HashMap) dataSnapshot.getValue();

                    adpt.add("Alerta:" + has.get("Alerta"));



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
                System.out.println(alerta);
                raat.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            haslh = (HashMap) dataSnapshot.getValue();

                            if (alerta.equals(haslh.get("Alerta"))){
                                dataSnapshot.getRef().removeValue();
                                finish();

                            }
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });



    }
    public void onOptionsItemSelected(){
        soma=0;
        for(int i=0;i<listviewData.getCount();i++){
            if(listviewData.isItemChecked(i)) {
                String word[] = listviewData.getItemAtPosition(i).toString().split("[:]");
                  alerta = word[1];

                }
            }
        }
    }





