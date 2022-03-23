package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.calendario.MainActivityCalendar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {

    Button logout, calendarButton, lista_de_dispositivos, sessao, historico;
    public FirebaseAuth mAuth;
    public FirebaseUser currentUser;
    private DatabaseReference reff;
    private String existe_pausa = "0";
    private double rad = 0, o_in;
    private long duracao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.signOut);
        calendarButton = findViewById(R.id.calendar);


        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        String u = currentUser.getUid();


        DataSnapshot snapshot;
        reff = FirebaseDatabase.getInstance().getReference().child("Dados").child(currentUser.getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dados : snapshot.getChildren()) {
                    System.out.println("Estes sao as sessoes "+ dados.getKey());
                    if (dados.getKey().equals("Pausa")) {
                        existe_pausa = "1";
                        System.out.println("valor existe pausa " + existe_pausa);
                        DatabaseReference reff2 = reff.child("Pausa");
                        rad = Double.parseDouble(dados.child("rad").getValue().toString());
                        duracao = Long.parseLong(dados.child("duracao").getValue().toString());
                        System.out.println("Cheguei a pausa radicao: " + rad + ", ha e a duracao e: " + duracao);
                    }
                    else if(dados.getKey().equals("Iniciada")){
                        existe_pausa = "2";
                        DatabaseReference reff2 = reff.child("Iniciada");
                        o_in = Double.parseDouble(dados.getValue().toString());
                       // duracao = Long.parseLong(dados.child("duracao").getValue().toString());
                    }
           //         double valor = Double.parseDouble(dados.child("rad").getValue().toString());
             //       System.out.println("O valor na firebase " +valor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Menu.this, MainActivity.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            };
        });

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent mainCalendarIntent = new Intent(Menu.this, MainActivityCalendar.class);

                startActivity(mainCalendarIntent);


            }
        });


    }
}