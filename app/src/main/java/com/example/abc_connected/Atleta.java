package com.example.abc_connected;

import java.io.Serializable;

public class Atleta extends Utilizador implements Serializable
{

    private String escalao, nome, email, numero, idade, genero, golo, posicao;

    //construtor
    public Atleta() { }

    public Atleta(String username , String password , String escalao, String nome, String email, String numero, String idade, String genero, String golo, String posicao) {
        super(password,username);
        this.escalao = escalao;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.idade = idade;
        this.genero = genero;
        this.golo = golo;
        this.posicao = posicao;
    }

    //getters

    public String getEscalao() { return escalao; }

    public String getNome() { return nome; }

    public String getNumero() { return numero; }

    public String getEmail() { return email; }

    public String getIdade() { return idade; }

    public String getGenero() { return genero; }

    public String getGolo() { return golo; }

    public String getPosicao() { return posicao; }

    //setters

    public void setEscalao(String escalao) { this.escalao = escalao; }

    public void setNome(String nome) { this.nome = nome; }

    public void setNumero(String numero) { this.numero = numero; }

    public void setEmail(String email) { this.email = email; }

    public void setIdade(String idade) { this.idade = idade; }

    public void setGenero(String genero) { this.genero = genero; }

    public void setGolo(String golo) { this.golo = golo; }

    public void setPosicao(String posicao) { this.posicao = posicao; }
}
