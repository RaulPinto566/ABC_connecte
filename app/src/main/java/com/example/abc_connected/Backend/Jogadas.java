package com.example.abc_connected.Backend;

public class Jogadas {
    private boolean ataque, defesa, remate, falta, baliza, falhado, sofrida, cometida, corte, assistencia, golo;
    private int distancia,id_jogada;
    private String lado, zona_baliza;
    private Atleta atleta;
    public Jogadas (boolean ataque, boolean defesa, boolean falta, boolean assistencia, boolean golo, boolean falhado, boolean sofrida, boolean cometida, boolean corte,boolean remate,boolean baliza){ 
        this.ataque = ataque;
        this.defesa = defesa;
        this.remate = remate;
        this.falta = falta;
        this.baliza = baliza;
        this.assistencia = assistencia;
        this.cometida = cometida;
        this.corte = corte;
        this.falhado = falhado;
        this.golo = golo;
        this.sofrida = sofrida;
    }
    public boolean get_ataque(){
        return ataque;
    }
    public boolean get_defesa(){
        return defesa;
    }
    public boolean get_remate(){
        return remate;
    }
    public boolean get_falta(){
        return falta;
    }
    public boolean get_baliza(){
        return baliza;
    }
    public boolean get_falhado(){
        return falhado;
    }
    public boolean get_cometida(){
        return cometida;
    }
    public boolean get_sofrida(){
        return sofrida;
    }
    public boolean  get_corte(){
        return corte;
    }
    public boolean get_assistencia(){
        return assistencia;
    }
    public boolean get_golo(){
        return golo;
    }
    public int get_distancia(){
        return distancia;
    }
    public String get_lado(){
        return lado;
    }
    public String get_zona_baliza(){
        return zona_baliza;
    }
    public Atleta get_atleta(){
        return atleta;
    }
    public int get_id_jogada(){
        return id_jogada;
    }
    public void set_ataque(boolean ataque){
        this.ataque = ataque;
    }
    public void set_defesa(boolean defesa){
        this.defesa = defesa;
    }
    public void set_remate(boolean remate){
        this.remate = remate;
    }
    public void set_falta(boolean falta){
        this.falta = falta;
    }
    public void set_baliza(boolean baliza){
        this.baliza = baliza;
    }
    public void set_falhado(boolean falhado){
        this.falhado = falhado;
    }
    public void set_cometida(boolean cometida){
        this.cometida = cometida;
    }
    public void set_sofrida(boolean sofrida){
        this.sofrida = sofrida;
    }
    public void set_corte (boolean corte){
        this.corte = corte;
    }
    public void set_assistencia(boolean assistencia){
        this.assistencia = assistencia;
    }
    public void set_golo(boolean golo){
        this.golo = golo;
    }
    public void set_distancia(int distancia){
        this.distancia = distancia;
    }
    public void set_lado(String lado){
        this.lado = lado;
    }
    public void set_zona_baliza(String zona_baliza){
        this.zona_baliza = zona_baliza;
    }
    public void set_atleta(Atleta atleta){
        this.atleta = atleta;
    }
    public void set_id_jogada(int id_jogada){
        this.id_jogada = id_jogada;
    }
}
