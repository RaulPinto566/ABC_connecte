package com.example.abc_connected;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class JogoJogadas3 extends AppCompatActivity {

      private Button distanci6,distancia7,distancia9,ladoesq,ladocentro,ladodireito,guardar,cancelar;
      private ListView window_list6;
      private ArrayAdapter adapter;
      private ArrayList adpt,list,email,nome;
      private HashMap hash;
      private String distancia,lado;
      @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.direita);
            distanci6 = findViewById(R.id.button6c);
            distancia7 = findViewById(R.id.button11c);
            distancia9 = findViewById(R.id.button12c);
            ladoesq = findViewById(R.id.button14c);
            ladocentro = findViewById(R.id.button15c);
            ladodireito = findViewById(R.id.button13c);
            guardar = findViewById(R.id.guardar5c);
            cancelar = findViewById(R.id.guardar6c);
            window_list6 = findViewById(R.id.window_list6);
            adpt = new ArrayList();
            list = new ArrayList();
            hash = new HashMap();
            email = new ArrayList();
            nome = new ArrayList();


            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,adpt);
            window_list6.setAdapter(adapter);

            distanci6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distanci6.setSelected(!distanci6.isSelected());

                    if (distancia7.isSelected()) {
                        distancia7.setSelected(false);
                    }

                    if (distancia9.isSelected()) {
                        distancia9.setSelected(false);
                    }
                    distancia = "6";
                }

            });
            distancia7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distancia7.setSelected(!distancia7.isSelected());
                    if (distanci6.isSelected()){
                        distanci6.setSelected(false);
                    }
                    if (distancia9.isSelected()){
                        distancia9.setSelected(false);
                    }
                    distancia = "7";
                }
            });
            distancia9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    distancia9.setSelected(!distancia9.isSelected());

                    if (distanci6.isSelected()){
                        distanci6.setSelected(false);
                    }
                    if (distancia7.isSelected()){
                        distancia7.setSelected(false);
                    }
                    distancia = "9";
                }
            });
            ladoesq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladoesq.setSelected(!ladoesq.isSelected());
                    if (ladocentro.isSelected()){
                        ladocentro.setSelected(false);
                    }
                    if (ladodireito.isSelected()){
                        ladodireito.setSelected(false);
                    }
                    lado = "esquerdo";

                }
            });
            ladocentro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladocentro.setSelected(!ladocentro.isSelected());
                    if (ladoesq.isSelected()){
                        ladoesq.setSelected(false);
                    }
                    if (ladodireito.isSelected()){
                        ladodireito.setSelected(false);
                    }
                    lado = "centro";

                }
            });
            ladodireito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ladodireito.setSelected(!ladodireito.isSelected());
                    if (ladoesq.isSelected()){
                        ladoesq.setSelected(false);
                    }
                    if (ladocentro.isSelected()){
                        ladocentro.setSelected(false);
                    }
                    lado = "direito";
                }
            });
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
}
