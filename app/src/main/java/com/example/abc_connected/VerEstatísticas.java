package com.example.abc_connected;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class VerEstatísticas extends AppCompatActivity {
    private TextInputLayout rc, rf,cf, atq, dfs,rmttt,glstt,e9,e7,e6,c9,c7,c6,d9,d7,d6;
    private Button sair;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_estatisticas);
        rc = findViewById(R.id.rc);
        rf = findViewById(R.id.rf);
        cf = findViewById(R.id.cf);
        atq = findViewById(R.id.atq);
        dfs = findViewById(R.id.dfs);
        rmttt = findViewById(R.id.rmttt);
        glstt = findViewById(R.id.glstt);
        e9 = findViewById(R.id.e9);
        e7 = findViewById(R.id.e7);
        e6 = findViewById(R.id.e6);
        c9 = findViewById(R.id.c9);
        c7 = findViewById(R.id.c7);
        c6 = findViewById(R.id.c6);
        d9 = findViewById(R.id.d9);
        d7 = findViewById(R.id.d7);
        d6 = findViewById(R.id.d6);
        sair = findViewById(R.id.sair);

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
