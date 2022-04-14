package com.example.abc_connected.Backend;
import java.sql.Time;
import java.util.Date;
public class Jogos {
    private int n_jornada,id_jogo;
    private String equipa_adv, competicao, local;
    private Equipa equipa;
    private Treinador treinador;
    private Date data;
    private Time hora;
    private Estatisticas estatisticas;
    public Jogos(int id_jogo,Equipa equipa,Treinador treinador,String equipa_adv,Date data,Time hora,String local,String competicao,int n_jornada){
        this.equipa = equipa;
        this.treinador = treinador;
        this.data = data;
        this.hora = hora;
        this.n_jornada = n_jornada;
        this.equipa_adv = equipa_adv;
        this.competicao = competicao;
        this.local = local;
        this.id_jogo = id_jogo;
        estatisticas = new Estatisticas();
    }
    public Jogos(){}
    public int get_id_jogo(){
        return id_jogo;
    }
    public int get_n_jornada(){
        return n_jornada;
    }
    public String get_equipa_adversaria(){
        return equipa_adv;
    }
    public String get_competicao(){
        return competicao;
    }
    public String get_local(){
        return local;
    }
    public Equipa get_equipa(){
        return equipa;
    }
    public Treinador treinador(){
        return treinador;
    }
    public Date get_data(){
        return data;
    }
    public Time get_hora(){
        return hora;
    }
    public Estatisticas get_estatisticas(){return estatisticas;}
    public void set_id_jogo(int id_jogo){
        this.id_jogo = id_jogo; 
    }
    public void set_n_jornada(int n_jornada){
        this.n_jornada = n_jornada;
    }
    public void set_equipa_adversaria(String equipa_adv){
        this.equipa_adv = equipa_adv;
    }
    public void set_competicao(String competicao){
        this.competicao = competicao;
    }
    public  void set_local(String local){
        this.local = local;
    }
    public void set_atleta(Equipa equipa){
        this.equipa = equipa;
    }
    public void set_treinador(Treinador treinador){
        this.treinador = treinador;
    }
    public void set_data(Date data){
        this.data = data;
    }
    public void set_hora(Time hora){
        this.hora = hora;
    }
}
