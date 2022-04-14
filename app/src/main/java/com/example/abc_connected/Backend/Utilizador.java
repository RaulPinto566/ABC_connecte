package com.example.abc_connected.Backend;

public class Utilizador {
    private String username;
    private String password;

    //construtor
    public Utilizador() { }

    public Utilizador(String password, String username)
    {
        this.username = username;
        this.password = password;
    }

    //getters

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    //setters

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

}