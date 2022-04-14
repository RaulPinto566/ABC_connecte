package com.example.abc_connected.Backend;

public class Treinos {

    private int hora, minutos, id_treino;
    private String local;
    private Equipa equipa;

    //construtor
    public Treinos(){}


    public Treinos(int hora, int minutos, int id_treino, String local, Equipa equipa){
        this.hora = hora;
        this.minutos = minutos;
        this.id_treino = id_treino;
        this.local = local;
        this.equipa = equipa;
    }

    //getters


    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getId_treino() {
        return id_treino;
    }

    public String getLocal() {
        return local;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    //setters

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setId_treino(int id_treino) {
        this.id_treino = id_treino;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }
}


