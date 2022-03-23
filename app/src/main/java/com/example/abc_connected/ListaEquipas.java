package com.example.abc_connected;

/*
LISTA_EQUIPAS- hashmap(equipa,treinador) + sets() + gets()
*/



import java.util.HashMap;

public class ListaEquipas {

    private HashMap<Equipa, Treinador> lista;

    public class EquipaNaoExistenteException extends Exception {
        public EquipaNaoExistenteException() { }
        public EquipaNaoExistenteException(String message) {
            super(message);
        }
    }

    public class EquipaDuplicadaException extends Exception {
        public EquipaDuplicadaException() { }
        public EquipaDuplicadaException(String message) {
            super(message);
        }
    }

    public ListaEquipas() {
        lista = new HashMap<>();
    }





}
