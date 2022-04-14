package com.example.abc_connected.Backend;

import java.util.TreeMap;

public class ListaTreinadores {

    private TreeMap<String, Treinador> lista;

    public class TreinadorNaoExistenteException extends Exception {
        public TreinadorNaoExistenteException() { }
        public TreinadorNaoExistenteException(String message) {
            super(message);
        }
    }

    public class TreinadorDuplicadoException extends Exception {
        public TreinadorDuplicadoException() { }
        public TreinadorDuplicadoException(String message) {
            super(message);
        }
    }

    public ListaTreinadores() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void adicionar(Treinador treinador) throws TreinadorDuplicadoException {
        if (treinador == null) {
            throw new NullPointerException("O parâmetro 'treinador' não pode ser um valor nulo!");
        }

        if (!lista.containsKey(treinador.getUsername())) {
            lista.put(treinador.getUsername(), treinador);
        }else{
            throw new TreinadorDuplicadoException(String.format("O treinador '%s' já existe na coleção", treinador.getUsername()));
        }

    }

    public boolean existe(String username) {
        return lista.containsKey(username);
    }

    public Treinador getTreinador(String username) throws TreinadorNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new TreinadorNaoExistenteException("Já existe um treinador com esse username");
        }
    }
}
