package com.example.abc_connected.Backend;

public class Treinador extends Utilizador {

    private String nome, email, numero, idade, genero, posicao,username,password;

    //construtor
    public Treinador() { }

    public Treinador(String username , String password , String nome, String email, String numero, String idade, String genero, String posicao) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.idade = idade;
        this.genero = genero;
        this.posicao = posicao;
        this.username = username;
        this.password = password;
    }

    //getters

    public String getNome() { return nome; }

    public String getNumero() { return numero; }

    public String getEmail() { return email; }

    public String getIdade() { return idade; }

    public String getGenero() { return genero; }

    public String getPosicao() { return posicao; }

    public String getPassword() { return password; }

    public String getUsername(){ return username; }

    //setters

    public void setNome(String nome) { this.nome = nome; }

    public void setNumero(String numero) { this.numero = numero; }

    public void setEmail(String email) { this.email = email; }

    public void setIdade(String idade) { this.idade = idade; }

    public void setGenero(String genero) { this.genero = genero; }

    public void setPosicao(String posicao) { this.posicao = posicao; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }
}
