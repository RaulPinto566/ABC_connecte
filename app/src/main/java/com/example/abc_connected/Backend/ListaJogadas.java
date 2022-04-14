package com.example.abc_connected.Backend;

import java.util.ArrayList;


public class ListaJogadas  {
    private ArrayList<Jogadas> lista;

    public class JogadaNaoExistenteException extends Exception {
        public JogadaNaoExistenteException() { }
        public JogadaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class JogadaDuplicadoException extends Exception {
        public JogadaDuplicadoException() { }
        public JogadaDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaJogadas() {
        lista = new ArrayList<>();
    }
    
    public void adicionar_Jogada(Jogadas jogada) throws JogadaDuplicadoException {
        if (jogada == null) {
            throw new NullPointerException("O parâmetro 'jogada' não pode ser um valor nulo!");
        }
        else
        {
            lista.add(jogada);
        }
    }      

    public ArrayList<Jogadas> get_Jogadas() {return lista;}
}
