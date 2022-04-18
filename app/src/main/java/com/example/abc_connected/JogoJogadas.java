package com.example.abc_connected;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.Backend.Sistema;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class JogoJogadas extends AppCompatActivity {

    public FirebaseAuth mAuth;
    Button ataqueButton;
    Button defesaButton;
    Button remateButton;
    Button faltaButton;
    Button balizaButton;
    Button falhadoButton;
    Button abandonarButton;
    Button periodoButton;
    Button estatisticasButton;
    private Sistema pap;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadas);
        ataqueButton = findViewById(R.id.ataqueButton);
        defesaButton = findViewById(R.id.defesaButton);
        remateButton = findViewById(R.id.remateButton);
        faltaButton = findViewById(R.id.faltaButton);
        balizaButton = findViewById(R.id.balizaButton);
        falhadoButton = findViewById(R.id.falhadoButton);
        abandonarButton = findViewById(R.id.abandonarButton);
        periodoButton = findViewById(R.id.periodoButton);
        estatisticasButton = findViewById(R.id.estatisticasButton);




    }

}
