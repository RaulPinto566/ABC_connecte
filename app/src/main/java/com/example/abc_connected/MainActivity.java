package com.example.abc_connected;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.Backend.Atleta;
import com.example.abc_connected.Backend.Sistema;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public Integer REQUEST_EXIT = 9;
    public FirebaseAuth mAuth;
    public FirebaseUser currentUser;
    Button signUpButton;
    Button signInButton;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.welcomeSignUpButton);
        signInButton = findViewById(R.id.welcomeSignInButton);
        signInButton.setVisibility(INVISIBLE);
        signUpButton.setVisibility(INVISIBLE);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("Atletas");
        CriarAtleta(root,"","","Junior","Raul Pinto","","","","","");
       if (mAuth.getCurrentUser() != null) {
            mAuth.getCurrentUser().reload().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    currentUser = mAuth.getCurrentUser();
                     if (currentUser != null && currentUser.isEmailVerified()) {
                        System.out.println("Email Verified : " + currentUser.isEmailVerified());
                        Intent MainActivity = new Intent(MainActivity.this, Menu.class);
                        startActivity(MainActivity);
                        MainActivity.this.finish();
                    }
                }
            });
        } else {
            signInButton.setVisibility(VISIBLE);
            signUpButton.setVisibility(VISIBLE);
            System.out.println("user not available");
        }
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);

                startActivity(signUpIntent);
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = new Intent(MainActivity.this, SignInActivity.class);

                startActivity(signInIntent);
            }
        });
    }
    public void CriarAtleta (DatabaseReference root ,String username , String password , String escalao, String nome, String email, String numero, String idade, String genero, String posicao)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Username",username);
        map.put("Password", password);
        map.put("Nome", nome);
        map.put("Email", email);
        map.put("Numero", numero);
        map.put("Idade", idade);
        map.put("Genero", genero);
        map.put("Posicao",posicao);
        map.put("Escalao",escalao);
        root.push().setValue(map);
    }
    public void CriarEquipa (DatabaseReference root, ArrayList<String> list, String treinador)
    {
        HashMap map = new HashMap();
        map.put("Treinador",treinador);
        map.put("Atletas", list);
        root.child("Pila1").setValue(map);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EXIT) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }
}