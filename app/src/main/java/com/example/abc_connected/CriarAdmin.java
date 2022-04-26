package com.example.abc_connected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CriarAdmin extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    public void CriarAdmin (DatabaseReference root , String username , String password , String nome, String email, String numero, String idade, String genero)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Username", username);
        map.put("Password", password);
        map.put("Nome", nome);
        map.put("Email", email);
        map.put("Numero", numero);
        map.put("Idade", idade);
        map.put("Genero", genero);
        root.push().setValue(map);
    }

    private static final String TAG = "SignUpActivity";
    public FirebaseAuth mAuth;
    Button criar;
    EditText user;
    EditText email;
    EditText pass;
    EditText nome;
    EditText idade;
    EditText genero;
    EditText numero;
    TextView errorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criaradmin);

        email = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        criar = findViewById(R.id.criar);
        user = findViewById(R.id.user);
        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        genero = findViewById(R.id.genero);
        numero = findViewById(R.id.numero);
        errorView = findViewById(R.id.signInErrorView);


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("Admins");




        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = user.getText().toString();
                String password = pass.getText().toString();
                String emaill = email.getText().toString();
                String name = nome.getText().toString();
                String idad = idade.getText().toString();
                String gen = genero.getText().toString();
                String num = numero.getText().toString();
                CriarAdmin(root, username, password, name, emaill, num, idad, gen);

                if (email.getText().toString().contentEquals("")) {
                    errorView.setText("Email cannot be empty");
                } else if (pass.getText().toString().contentEquals("")) {
                    errorView.setText("Password cannot be empty");
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(CriarAdmin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success" + email.getText().toString());
                                FirebaseUser user = mAuth.getCurrentUser();
                                try {
                                    if (user != null)
                                        user.sendEmailVerification()
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.d(TAG, "Email sent.");
                                                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                                                    CriarAdmin.this);
                                                            // set title
                                                            alertDialogBuilder.setTitle("Please Verify Your EmailID");
                                                            // set dialog message
                                                            alertDialogBuilder
                                                                    .setMessage("A verification Email Is Sent To Your Registered EmailID, please click on the link and Sign in again!")
                                                                    .setCancelable(false)
                                                                    .setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int id) {
                                                                            Intent mainCalendarIntent = new Intent(CriarAdmin.this, Admin.class);

                                                                            startActivity(mainCalendarIntent);

                                                                        }
                                                                    });
                                                            // create alert dialog
                                                            AlertDialog alertDialog = alertDialogBuilder.create();
                                                            // show it
                                                            alertDialog.show();
                                                        }
                                                    }
                                                });
                                } catch (Exception e) {
                                    errorView.setText(e.getMessage());
                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(CriarAdmin.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                                if (task.getException() != null) {
                                    errorView.setText(task.getException().getMessage());
                                }
                            }
                        }
                    });
                }

            }
        });


    }
}