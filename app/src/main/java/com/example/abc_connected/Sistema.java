package com.example.abc_connected;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;


public class Sistema implements Serializable {
    private final ListaUtilizadores utilizadores;
    private Utilizador utilizadorLigado;
    private ListaAcessos listaEntradas;
    public Calendar dataAdmin =  Calendar.getInstance();
    public Calendar dataTreinador =  Calendar.getInstance();

    public Sistema() {
        utilizadores = new ListaUtilizadores();
        listaEntradas = new ListaAcessos();
        dataAdmin.set(1989 , 4 , 21);
        dataTreinador.set(1991, 5, 10);
    }
    public ListaAcessos getListaEntradas()
    {
        return listaEntradas;
    }
    public ListaUtilizadores getUtilizadorList() {
        return utilizadores;
    }

    public boolean autenticarUtilizador(String nomeUtilizador, String password) {
        if (utilizadores.existe(nomeUtilizador)) {
            try{
                Utilizador u = utilizadores.getUtilizador(nomeUtilizador);
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u;
                    listaEntradas.set_Acesso(new RegistoAcesso(utilizadorLigado, LocalDateTime.now()));
                    return true;
                }
            }catch (ListaUtilizadores.UtilizadorNaoExistenteException e) {}
        }
        return false;
    }

    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {

        utilizadores.adicionar(new Administrador("admin","admin","joaoc@gmail.com","923891276"));
        utilizadores.adicionar(new Treinador("treinador","treinador","Sergio Conceicao", "sergioconceicao@gmail.com", "917659524", "Principal"));

        utilizadores.adicionar(new Administrador("admins","admins","ze@gmail.com", "919191919"));
        utilizadores.adicionar(new Treinador("treinador","treinador","Sergio Conceicao", "sergioconceicao@gmail.com", "917659524","adjunto"));

    }

    public void terminar() {
        System.exit(0);
    }
}

