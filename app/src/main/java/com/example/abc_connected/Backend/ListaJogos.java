package com.example.abc_connected.Backend;

import java.util.TreeMap;

public class ListaJogos {
    private TreeMap<Integer, Jogos> lista;

    public class JogoNaoExistenteException extends Exception {
        public JogoNaoExistenteException() { }
        public JogoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class JogoDuplicadoException extends Exception {
        public JogoDuplicadoException() { }
        public JogoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaJogos() {
        lista = new TreeMap<>();        
    }
    
    public void adicionar(Jogos jogo) throws JogoDuplicadoException {
        if (jogo == null) {
            throw new NullPointerException("O parâmetro 'jogo' não pode ser um valor nulo!");
        }        
        
        if (!lista.containsKey(jogo.get_id_jogo())) {
            lista.put(jogo.get_id_jogo(), jogo);
        }else{
            throw new JogoDuplicadoException(String.format("O jogo '%s' já existe na coleção", jogo.get_id_jogo()));
        }
        
    }      
    
    public boolean existe(int id_jogo) {
        return lista.containsKey(id_jogo);
    }
    
    public Jogos get_Jogo(int id_jogo) throws JogoNaoExistenteException {
        if (lista.containsKey(id_jogo)){
            return lista.get(id_jogo);
        }else{
            throw new JogoNaoExistenteException("Já existe um Jogo com esse id.");
        }
    }
}
