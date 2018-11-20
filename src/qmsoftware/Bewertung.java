/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

/**
 * Class for lecturer ratings, contains one dataset from input
 *
 * @author amederake
 */
public class Bewertung
{

    // Class Variables
    private String Modul;           // Modulename
    private int FKompetenz;         // fachliche Kompetenz
    private int PKompetenz;         // pädagogische Kompetenz
    private int Verstaendlich;      // Verständlichkeit
    private int Vorbereitet;        // Unterrichts Vorbereitung
    private int Problem;           // Problembehandlung

    /**
     * standard constructor
     */
    Bewertung()
    {
        Modul = "";
        FKompetenz = 0;
        PKompetenz = 0;
        Verstaendlich = 0;
        Vorbereitet = 0;
        Problem = 0;
    }

    /**
     * parameterised constructor
     *
     * @param m // Modulname
     * @param fk // Fachkompetenz
     * @param pk // pädagogische Kompetenz
     * @param ve // Verständlichkeit
     * @param vo // Vorbereitung
     * @param p // Problembehandlung
     */
    Bewertung(String m, int fk, int pk, int ve, int vo, int p)
    {
        Modul = m;
        FKompetenz = fk;
        PKompetenz = pk;
        Verstaendlich = ve;
        Vorbereitet = vo;
        Problem = p;
    }

    // class methodes
    
    /**
     * retuns modulname
     *
     * @return String
     */
    public String getModul()
    {
        return Modul;
    }

    /**
     * set Modulname
     *
     * @param mod String
     */
    public void setModul(String mod)
    {
        Modul = mod;
    }

    /**
     * retuns FKompetenz rating
     *
     * @return
     */
    public int getFKompetenz()
    {
        return FKompetenz;
    }

    /**
     * set FKompeteznz rating
     *
     * @param in int
     */
    public void setFKompetenz(int in)
    {
        FKompetenz = in;
    }

    /**
     * returns PKompetenz rating
     *
     * @return int
     */
    public int getPKompetenz()
    {
        return PKompetenz;
    }

    /**
     * set PKompetenz rating
     *
     * @param in int
     */
    public void setPKompetenz(int in)
    {
        PKompetenz = in;
    }

    /**
     * returns Verstaendlich rating
     *
     * @return int
     */
    public int getVerstaendlich()
    {
        return Verstaendlich;
    }

    /**
     * set Verstaendlich rating
     *
     * @param in int
     */
    public void setVerstaendlich(int in)
    {
        Verstaendlich = in;
    }

    /**
     * returns Vorbereitung rating
     *
     * @return int
     */
    public int getVorbereitet()
    {
        return Vorbereitet;
    }

    /**
     * set Vorbereitet rating
     *
     * @param in int
     */
    public void setVorbereitet(int in)
    {
        Vorbereitet = in;
    }

    /**
     * returns Problem rating
     *
     * @return
     */
    public int getProblem()
    {
        return Problem;
    }

    /**
     * set Problem rating
     *
     * @param in int
     */
    public void setProblem(int in)
    {
        Problem = in;
    }
}
