package com.example.abc_connected;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipa implements Serializable {

    private String n_Equipa;
    private ArrayList<Atleta> lista;

    public Equipa(String n_Equipa) {
        this.n_Equipa = n_Equipa;
        lista = new ArrayList<Atleta>();

    }

    public Equipa(){
        lista = new ArrayList<Atleta>();
    }


    //getters

    public String getN_equipa() {
        return n_Equipa; }

    //setters

    public void setN_equipa(String n_Equipa){
        this.n_Equipa = n_Equipa; }


}
