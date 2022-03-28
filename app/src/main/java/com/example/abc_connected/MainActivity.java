package com.example.abc_connected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText username,
            password;
    private Button login;
    Switch active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        active = findViewById(R.id.active);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("login").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String input1 = username.getText().toString();
                        String input2 = password.getText().toString();

                        if (dataSnapshot.child(input1).exists()) {
                            if (dataSnapshot.child(input1).child("password").getValue(String.class).equals(input2)) {
                                if (active.isChecked()) {
                                    if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("admin")) {
                                        com.example.abc_connected.preferences.setDataLogin(MainActivity.this, true);
                                        com.example.abc_connected.preferences.setDataAs(MainActivity.this, "admin");
                                        startActivity(new Intent(MainActivity.this, com.example.abc_connected.AdminActivity.class));
                                    } else if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("user")){
                                        com.example.abc_connected.preferences.setDataLogin(MainActivity.this, true);
                                        com.example.abc_connected.preferences.setDataAs(MainActivity.this, "user");
                                        startActivity(new Intent(MainActivity.this, com.example.abc_connected.UserActivity.class));
                                    }
                                } else {
                                    if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("admin")) {
                                        com.example.abc_connected.preferences.setDataLogin(MainActivity.this, false);
                                        startActivity(new Intent(MainActivity.this, com.example.abc_connected.AdminActivity.class));

                                    } else if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("user")){
                                        com.example.abc_connected.preferences.setDataLogin(MainActivity.this, false);
                                        startActivity(new Intent(MainActivity.this, com.example.abc_connected.UserActivity.class));
                                    }
                                }

                            } else {
                                Toast.makeText(MainActivity.this, "Kata sandi salah", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Data belum terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (com.example.abc_connected.preferences.getDataLogin(this)) {
            if (com.example.abc_connected.preferences.getDataAs(this).equals("admin")) {
                startActivity(new Intent(this, com.example.abc_connected.AdminActivity.class));
                finish();
            } else {
                startActivity(new Intent(this, com.example.abc_connected.UserActivity.class));
                finish();
            }
        }
    }
}