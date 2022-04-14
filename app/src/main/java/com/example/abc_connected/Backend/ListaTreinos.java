package com.example.abc_connected.Backend;

import java.util.TreeMap;

public class ListaTreinos {

    private TreeMap<String, Treinos> lista;

    public class TreinoNaoExistenteException extends Exception {
        public TreinoNaoExistenteException() { }
        public TreinoNaoExistenteException(String message) {
            super(message);
        }
    }

    public class TreinoDuplicadoException extends Exception {
        public TreinoDuplicadoException() { }
        public TreinoDuplicadoException(String message) {
            super(message);
        }
    }

    public ListaTreinos() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void adicionar(Treinos treino) throws ListaTreinos.TreinoDuplicadoException {
        if (treino == null) {
            throw new NullPointerException("O parâmetro 'treino' não pode ser um valor nulo!");
        }

        if (!lista.containsKey(treino.getId_treino())) {
            lista.put(String.valueOf(treino.getId_treino()), treino);
        }else{
            throw new ListaTreinos.TreinoDuplicadoException(String.format("O treino '%s' já existe na coleção", treino.getId_treino()));
        }

    }

    public boolean existe(String id) {
        return lista.containsKey(id);
    }

    public Treinos getTreinos(String id) throws ListaTreinos.TreinoNaoExistenteException {
        if (lista.containsKey(id)){
            return lista.get(id);
        }else{
            throw new ListaTreinos.TreinoNaoExistenteException("Já existe um treino com esse id");
        }
    }
}
