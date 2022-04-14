package com.example.abc_connected.Backend;

public class Estatisticas
{
    private ListaJogadas lista;
    private int periodo;
    
    //construtor
    public Estatisticas() { }
   
    public Estatisticas(int periodo) {
        this.periodo = periodo;
        lista = new ListaJogadas();
    } 
    
    //getters

    public ListaJogadas get_lista_jogadas(){
        return lista;
    }
    public int get_periodo(){
        return periodo;
    }
    
    //setters

    public void set_periodo(int periodo){
        this.periodo = periodo;
    }


}