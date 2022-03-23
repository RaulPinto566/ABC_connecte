package com.example.abc_connected;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaAcessos implements Serializable
{

    private ArrayList<RegistoAcesso> lista ;

    public class AcessoNaoExistenteException extends Exception
    {
        public AcessoNaoExistenteException() { }
        public AcessoNaoExistenteException(String message)
        {
            super(message);
        }
    }
    public ListaAcessos()
    {
        lista = new ArrayList<>();
    }

    public void set_Acesso (RegistoAcesso acesso)
    {
        lista.add(acesso);
    }

    public boolean get_AcessoTrue (String username)
    {
        for (RegistoAcesso lista1 : lista) {
            if(lista1.getUtilizador().getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }

    public int get_NumAcessos ()
    {
        return lista.size();
    }
    /*funcao para criar acessos por utilzzador/*
    /*
    public Gestor get_Utilizador (String username) throws GestorNaoExistenteException {
        if (lista.containsKey(username))
        {
            return lista.get(username);
        }
        else
        {
            throw new GestorNaoExistenteException("O gestor '%s' já existe na lista");
        }
    }
    */
    public ArrayList<RegistoAcesso> get_Acessos()
    {
        return lista;
    }

}