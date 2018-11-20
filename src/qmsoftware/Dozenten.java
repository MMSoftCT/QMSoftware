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
    
    private String Name;                     // lectures name
    private ArrayList<String> Modules;       // ArrayList of Modules
    private ArrayList<Bewertung> ratings;    // ArrayList of ratings


    // Constructer

    public Dozenten(){
        Name = "";
        Modules = new ArrayList<String>();
        ratings = new ArrayList<Bewertung>();
    }
    
    /**
     * parameterized constructor
     * @param name String   // Name of the teacher
     */
    public Dozenten(String name){
        Name = name;
        Modules = new ArrayList<String>();
        ratings = new ArrayList<Bewertung>();
    }
    
    // class methodes
    
    /**
     * returns the name
     * @return String
     */
    public String getName(){
        return Name;
    }
    
    /**
     * set the name
     * @param name String
     */
    public void setName(String name){
        Name = name;
    }
    
    /**
     * add a new ratingset
     * @param bew Bewertung
     */
    public void addBewertung(Bewertung bew){
        ratings.add(bew);
    }
    
    /**
     * return the ratingset at given index
     * @param idx   int
     * @return Bewertung
     */
    public Bewertung getBewertung(int idx){
        return ratings.get(idx);
    }
    
    /**
     * return averged FKompetenz rating for given module
     * @param mod   String
     * @return double
     */
    public double avgFKompetenz(String mod){
        return 0.0;
    }
    
    /**
     * return averged PKompetenz rating for given module
     * @param mod
     * @return 
     */
    public double avgPKompetenz(String mod){
        return 0.0;
    }
    
    /**
     * return averged Versataendlich rating for given module
     * @param mod
     * @return 
     */
    public double avgVerstaendlich(String mod){
        return 0.0;
    }
    
    /**
     * return averged Vorbereitung rating for given module
     * @param mod
     * @return 
     */
    public double avgVorbereitet(String mod){
        return 0.0;
    }
    
    /**
     * return averged Proble rating for given module
     * @param mod
     * @return 
     */
    public double avgProblem(String mod){
        return 0.0;
    }
}
