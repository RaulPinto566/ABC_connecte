package com.example.abc_connected.Backend;

public class Administrador extends Utilizador
{
    private String email, numero;

    //construtor
    public Administrador() { }

    public Administrador(String password, String username, String email, String numero) {
        super(password , username);
        this.email = email;
        this.numero = numero;
    }

    //getters

    public String getNumero() { return numero; }

    public String getEmail() { return email; }

    //setters

    public void setNumero(String numero) { this.numero = numero; }

    public void setEmail(String email) { this.email = email; }
}