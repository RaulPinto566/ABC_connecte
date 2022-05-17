package com.example.abc_connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {
    Button logout, adm, atl, trn,up, alrt, apagar;
    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mAuth = FirebaseAuth.getInstance();
        alrt = findViewById(R.id.alert);
        apagar = findViewById(R.id.button3);
        logout = findViewById(R.id.signOut2);
        adm = findViewById(R.id.adminbtn);
        atl = findViewById(R.id.atletabtn);
        trn = findViewById(R.id.treinbtn);
        up = findViewById(R.id.button8);

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(new Intent(Admin.this, Apagar.class));
                startActivity(intent);
            }
        });

        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(new Intent(Admin.this, Criar_Alerta.class));
                startActivity(intent);
            }
        });


        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Admin.this, CriarAdmin.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        atl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Admin.this, CriarAtleta.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        trn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Admin.this, CriarTreinador.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Admin.this, MainActivity.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            };
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainCalendarIntent = new Intent(Admin.this, EditarAdmin.class);

                startActivity(mainCalendarIntent);
            }
        });
    }
}