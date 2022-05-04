package com.example.abc_connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Criar_Alerta extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    public void CriarAlerta (DatabaseReference root , String alerta)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Alerta", alerta);
        root.push().setValue(map);
    }

    public FirebaseAuth mAuth;
    Button criar;
    EditText alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_alerta);

        mAuth = FirebaseAuth.getInstance();
        criar = findViewById(R.id.criar33);
        alerta = findViewById(R.id.alr);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("Alerta");


        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String alrt  = alerta.getText().toString();
                CriarAlerta(root,alrt);

                Criar_Alerta.this.finish();
            }
        });




    }
}