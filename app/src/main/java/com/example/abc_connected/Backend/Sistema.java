package com.example.abc_connected.Backend;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Sistema {
    private ListaUtilizadores utilizadores;
    private ListaAtletas atletas;
    private ListaTreinadores treinadores;
    private ListaAdmin admin;
    private ListaEquipas equipas;
    private ListaJogos jogos;
    private ListaTreinos treinos;
    public Calendar dataAdmin =  Calendar.getInstance();
    public Calendar dataTreinador =  Calendar.getInstance();

    public Sistema() {
        utilizadores = new ListaUtilizadores();
        dataAdmin.set(1989 , 4 , 21);
        dataTreinador.set(1991, 5, 10);
    }
    public ListaUtilizadores getUtilizadorList() {
        return utilizadores;
    }

    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {
        utilizadores.adicionar(new Administrador("admin","admin","joaoc@gmail.com","923891276"));
    }

    public void terminar() {
        System.exit(0);
    }
}

