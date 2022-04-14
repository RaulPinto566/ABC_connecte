package com.example.abc_connected.Backend;

import java.util.HashMap;

public class ListaEquipas {

    private HashMap<Treinador, Equipa> lista;

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
