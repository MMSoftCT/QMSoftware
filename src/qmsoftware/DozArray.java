/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

import java.util.ArrayList;

/**
 *spezialized ArrayList for Dozent class
 * 
 * @author micim
 */
public class DozArray extends ArrayList<Dozent>
{
    /**
     * search for Dozent Oject where the name matches
     * @param name  String
     * @return      Boolean
     */
    public boolean contains(String name)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * return the Dozent Object where the name matches
     * @param name  String
     * @return      Dozent
     */
     public Dozent get(String name)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i).getName().equals(name))
            {
                return this.get(i);
            }
        }
        return null;
    }

     /**
     * return the index of the Dozent Object where the name matches
     * @param name  String
     * @return      int
     */
     public int indexOf(String name)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i).getName().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

     /**
      * return the names of the teachers who are able to teach the given modul
      * @param mod  String
      * @return     ArrayList of String
      */
     public ArrayList<String> getDozenten(String mod)
     {
        ArrayList<String> ret = new ArrayList<String>();
         
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i).canModule(mod))
            {
                ret.add(this.get(i).getName());
            }
        }
        return ret;
     }
}
