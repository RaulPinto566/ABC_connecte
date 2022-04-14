package com.example.abc_connected;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Plslastone {
    public void CriarAtleta (DatabaseReference root ,String username , String password , String escalao, String nome, String email, String numero, String idade, String genero, String posicao)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Username",username);
        map.put("Password", password);
        map.put("Nome", nome);
        map.put("Email", email);
        map.put("Numero", numero);
        map.put("Idade", idade);
        map.put("Genero", genero);
        map.put("Posicao",posicao);
        map.put("Escalao",escalao);
        root.push().setValue(map);
    }
    public void CriarTreinador (DatabaseReference root, String username , String password , String nome, String email, String numero, String idade, String genero, String posicao)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Username",username);
        map.put("Password", password);
        map.put("Nome", nome);
        map.put("Email", email);
        map.put("Numero", numero);
        map.put("Idade", idade);
        map.put("Genero", genero);
        map.put("Posicao",posicao);
        root.push().setValue(map);
    }
    public void CriarAdministrador (DatabaseReference root, String username , String password , String nome, String email, String numero, String idade, String genero)
    {
        HashMap<String ,String> map = new HashMap<>();
        map.put("Username",username);
        map.put("Password", password);
        map.put("Nome", nome);
        map.put("Email", email);
        map.put("Numero", numero);
        map.put("Idade", idade);
        map.put("Genero", genero);
        root.push().setValue(map);
    }
    public void CriarEquipa (DatabaseReference root, ArrayList<String> list,String treinador)
    {
        HashMap map = new HashMap();
        map.put("Treinador",treinador);
        map.put("Atletas", list);
        root.push().setValue(map);
    }
    public void CriarJogo (DatabaseReference root, String id_jogo, String equipa, String equipa_adv, String local, String competicao,String n_jornada)
    {
        HashMap map = new HashMap();
        map.put("Id_jogo",id_jogo);
        map.put("Equipa", equipa);
        map.put("Equipa_Adv", equipa_adv);
        map.put("Local", local);
        map.put("Competicao", competicao);
        map.put("N_Jornada", n_jornada);
        root.push().setValue(map);
    }
    public void CriarJogadas (DatabaseReference root,String periodo,String atleta_marcador,String atleta_assistencia,String zona_baliza,String zona_campo,boolean ataque, boolean defesa, boolean falta, boolean assistencia, boolean golo, boolean falhado, boolean sofrida, boolean cometida, boolean corte,boolean remate,boolean baliza)
    {
        HashMap map = new HashMap();
        map.put("Ataque" ,ataque);
        map.put("Defesa",defesa);
        map.put("Falta",falta);
        map.put("Assitencia",assistencia);
        map.put("Golo",golo);
        map.put("Falhado",falhado);
        map.put("Sofrida",sofrida);
        map.put("Cometida",cometida);
        map.put("Corte",corte);
        map.put("Remate",remate);
        map.put("Baliza",baliza);
        HashMap mep = new HashMap();
        mep.put("Atleta_Marcador",atleta_marcador);
        mep.put("Atleta_Assistencia",atleta_assistencia);
        mep.put("Zona_Baliza",zona_baliza);
        mep.put("Zona_Campo",zona_campo);
        mep.put("Periodo",periodo);
        mep.put("",map);
        root.push().setValue(mep);
    }
}
