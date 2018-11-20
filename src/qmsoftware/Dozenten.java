/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

/**
 * class for lecturer
 * contains personal attributes and ratings
 * 
 * @author amederake
 */
public class Dozenten
{
    // class variables
    
    private String Name;            // lectures name
    private String[] Modules;       // Array of Modules
    private Bewertung[] ratings;    // Array of ratings


    // Construters

    Dozenten(){
        Name = "";
    }
}
