package com.example.abc_connected.Backend;

import java.util.ArrayList;

public class Equipa {

    private String n_Equipa;
    private ArrayList<Atleta> lista;

    public Equipa(String n_Equipa,ArrayList<Atleta> lista) {
        this.n_Equipa = n_Equipa;
        this.lista = new ArrayList<Atleta>(lista);
    }

    //getters

    public String getN_equipa() {return n_Equipa;}

    public ArrayList<Atleta> get_atletas(){return lista;}

    //setters

    public void set_equipa(ArrayList<Atleta> lista){this.lista = lista;}

    public void setN_equipa(String n_Equipa){this.n_Equipa = n_Equipa;}
}
