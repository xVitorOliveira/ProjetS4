package com.example.vitor.reserterre;

import java.util.ArrayList;

/**
 * Created by voliveira on 15/03/17.
 */

public class Gymnase{
    private String nom ;
    private String adresse;
    private ArrayList <String> equipements;
    public void Gymnases(String n, String a, ArrayList <String> equip){
        nom=n;
        adresse=a;
        equipements=equip;
    }
    public String getNom(){
        return nom;
    }
    public String getAdresse(){
        return adresse;
    }
}
