package com.example.abc_connected;

import java.util.TreeMap;

public class ListaAdmin {
    private TreeMap<String, Administrador> lista;

    public class AdministradorNaoExistenteException extends Exception {
        public AdministradorNaoExistenteException() { }
        public AdministradorNaoExistenteException(String message) {
            super(message);
        }
    }

    public ListaAdmin() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public boolean existe(String username) {
        return lista.containsKey(username);
    }

    public Administrador getAdministrador(String username) throws AdministradorNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new AdministradorNaoExistenteException("Já existe um administrador com esse username");
        }
    }
}
