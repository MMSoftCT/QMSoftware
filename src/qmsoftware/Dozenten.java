/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

import java.util.ArrayList;

/**
 * class for lecturer
 * contains personal attributes and ratings
 * 
 * @author amederake
 */
public class Dozenten
{
    // class variables
    
    private String Name;                    // lectures name
    private ArrayList<String> Modules;       // ArrayList of Modules
    private ArrayList<Bewertung> ratings;    // ArrayList of ratings


    // Construters

    Dozenten(){
        Name = "";
        Modules = new ArrayList<String>();
        ratings = new ArrayList<Bewertung>();
    }
    
    Dozenten(String name){
        Name = name;
        Modules = new ArrayList<String>();
        ratings = new ArrayList<Bewertung>();
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public void addBewertung(Bewertung bew){
        ratings.add(bew);
    }
    
    public double avgFKompetenz(String mod){
        return 0.0;
    }
}
