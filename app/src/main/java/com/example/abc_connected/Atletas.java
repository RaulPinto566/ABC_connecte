package com.example.abc_connected;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.calendario.MainActivityCalendar;
import com.google.firebase.auth.FirebaseAuth;

public class Atletas extends AppCompatActivity {

    public FirebaseAuth mAuth;
    Button logout, call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atleta);
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.button23);
        call = findViewById(R.id.button2);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent=new Intent(new Intent(Atletas.this, MainActivity.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            };
        });
call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent mainCalendarIntent = new Intent(Atletas.this, MainActivityCalendar.class);

        startActivity(mainCalendarIntent);
    }
});
    }
}
