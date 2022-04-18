package com.example.abc_connected;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ArrayList adpt;
    private HashMap hash;
    private ArrayList adpt2;
    private HashMap hash2;
    private ArrayAdapter adapter;

    public Integer REQUEST_EXIT = 9;
    public FirebaseAuth mAuth;
    public FirebaseUser currentUser;
    Button signInButton;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private FirebaseDatabase db2 = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        signInButton = findViewById(R.id.welcomeSignInButton);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("Atletas");

        FirebaseDatabase db2 = FirebaseDatabase.getInstance();
        DatabaseReference root2 = db2.getReference().child("Treinadores");

        adpt = new ArrayList<>();
        hash = new HashMap();

        adpt2 = new ArrayList<>();
        hash2 = new HashMap();


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash = (HashMap) dataSnapshot.getValue();
                    adpt.add(hash.get("Email"));
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);

        root2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    hash2 = (HashMap) dataSnapshot.getValue();
                    adpt2.add(hash2.get("Email"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


       if (mAuth.getCurrentUser() != null) {
            mAuth.getCurrentUser().reload().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    currentUser = mAuth.getCurrentUser();
                    if (currentUser != null && currentUser.isEmailVerified()) {

                        if (adpt.toString().trim().contains(currentUser.getEmail().trim())) {
                            Intent MainActivity = new Intent(MainActivity.this, Atletas.class);
                            startActivity(MainActivity);
                            MainActivity.this.finish();

                        } else {
                            if (adpt2.toString().trim().contains(currentUser.getEmail().trim())) {
                                Intent MainActivity = new Intent(MainActivity.this, Treinadores.class);
                                startActivity(MainActivity);
                                MainActivity.this.finish();

                            } else {
                                Intent MainActivity = new Intent(MainActivity.this, Admin.class);
                                startActivity(MainActivity);
                                MainActivity.this.finish();

                            }

                        }
                    }
                }
            });
        } else {
            signInButton.setVisibility(VISIBLE);
            System.out.println("user not available");
        }

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