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
public class Dozent
{
    // class variables
    
    private String Name;                     // lectures name
    private ArrayList<String> Modules;       // ArrayList of Modules
    private ArrayList<Bewertung> ratings;    // ArrayList of ratings


    // Constructer

    public Dozent(){
        Name = "";
        Modules = new ArrayList<String>();
        ratings = new ArrayList<Bewertung>();
    }
    
    /**
     * parameterized constructor
     * @param name String   // Name of the teacher
     */
    public Dozent(String name){
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
     * add a new Module 
     * @param mod String
     */
    public void addModul(String mod){
        if(!Modules.contains(mod))
        {
            Modules.add(mod);
        }
    }
    
    /**
     * check if given Modul in Modules
     * @param mod   String
     * @return      Boolean
     */
    public boolean canModule(String mod)
    {
        return Modules.contains(mod);
    }
    
    /**
     * add a new ratingset and update Modules array
     * @param bew Bewertung
     */
    public void addBewertung(Bewertung bew){
        ratings.add(bew);
        addModul(bew.getModul());
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
     * return how much studends have rated
     * @param mod   String
     * @return int
     */
    public int rateCount(String mod)
    {
        int count = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                count ++;
            }
        }
        return count;
        
    }

    /**
     * return how much rates are 5 or 6
     * @param mod
     * @return 
     */
    public int badRate(String mod)
    {
         int count = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                if(ratings.get(i).getFKompetenz() == 5 ||
                   ratings.get(i).getFKompetenz() == 6)
                {
                count ++;
                }
                if(ratings.get(i).getPKompetenz() == 5 ||
                   ratings.get(i).getPKompetenz() == 6)
                {
                count ++;
                }
                if(ratings.get(i).getVerstaendlich() == 5 ||
                   ratings.get(i).getVerstaendlich() == 6)
                {
                count ++;
                }
                if(ratings.get(i).getVorbereitet() == 5 ||
                   ratings.get(i).getVorbereitet() == 6)
                {
                count ++;
                }
                if(ratings.get(i).getProblem() == 5 ||
                   ratings.get(i).getProblem() == 6)
                {
                count ++;
                }
            }
        }
        return count;
    }
    
    /**
     * return averged FKompetenz rating for given module
     * @param mod   String
     * @return double
     */
    public double avgFKompetenz(String mod){
        double count = 0;
        double rate = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                rate += ratings.get(i).getFKompetenz();
                count ++;
            }
        }
        return rate / count;
    }
    
    /**
     * return averged PKompetenz rating for given module
     * @param mod
     * @return 
     */
    public double avgPKompetenz(String mod){
        double count = 0;
        double rate = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                rate += ratings.get(i).getPKompetenz();
                count ++;
            }
        }
        return rate / count;
    }
    
    /**
     * return averged Versataendlich rating for given module
     * @param mod
     * @return 
     */
    public double avgVerstaendlich(String mod){
        double count = 0;
        double rate = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                rate += ratings.get(i).getVerstaendlich();
                count ++;
            }
        }
        return rate / count;
    }
    
    /**
     * return averged Vorbereitung rating for given module
     * @param mod
     * @return 
     */
    public double avgVorbereitet(String mod){
        double count = 0;
        double rate = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                rate += ratings.get(i).getVorbereitet();
                count ++;
            }
        }
        return rate / count;
    }
    
    /**
     * return averged Proble rating for given module
     * @param mod
     * @return 
     */
    public double avgProblem(String mod){
        double count = 0;
        double rate = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            if (ratings.get(i).getModul().equals(mod))
            {
                rate += ratings.get(i).getProblem();
                count ++;
            }
        }
        return rate / count;
    }
}
