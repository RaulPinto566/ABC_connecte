package com.example.abc_connected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditarTreinador extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseUser usere;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    Button criar;
    EditText user;
    EditText nome;
    EditText idade;
    EditText genero;
    EditText numero;
    EditText posicao;
    TextView errorView;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_treinador);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference();


        criar = findViewById(R.id.criar);
        user = findViewById(R.id.user);
        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        genero = findViewById(R.id.genero);
        numero = findViewById(R.id.numero);
        posicao = findViewById(R.id.pos);
        numero = findViewById(R.id.numero);
        errorView = findViewById(R.id.signInErrorView);

        mAuth = FirebaseAuth.getInstance();

        usere = mAuth.getCurrentUser();

        final String[] zenabo = new String[1];


        root.child("Treinadores").orderByChild("Email").equalTo(usere.getEmail().trim()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot: snapshot.getChildren()){

                    zenabo[0] = childSnapshot.getKey();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                root.child("Treinadores").child(zenabo[0]).child("Genero").setValue(genero.getText().toString());
                root.child("Treinadores").child(zenabo[0]).child("Idade").setValue(idade.getText().toString());
                root.child("Treinadores").child(zenabo[0]).child("Nome").setValue(nome.getText().toString());
                root.child("Treinadores").child(zenabo[0]).child("Numero").setValue(numero.getText().toString());
                root.child("Treinadores").child(zenabo[0]).child("Posicao").setValue(posicao.getText().toString());
                root.child("Treinadores").child(zenabo[0]).child("Username").setValue(user.getText().toString());

            }
        });
    }
}