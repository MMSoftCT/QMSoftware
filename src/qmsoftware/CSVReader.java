/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmsoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CSV Reader
 * @author amederake
 */
public class CSVReader
{

    // Class variables
    private String filepath;                    // Filename
    private String sep;                         // Seperator
    private boolean hasHeader;                  // File has columnheader
    private String[] header;                    // Header data
    private static ArrayList<String[]> data;    // File data

    /**
     * extended constructor
     */
    public CSVReader()
    {
        filepath = "";
        sep = ",";
        hasHeader = false;
        header = null;
        data = new ArrayList<String[]>();
    }

    /**
     * Constructor
     *
     * @param filename  // String: Filename
     * @param s         // String: Seperator
     * @param h         // Boolean: Header
     */
    public CSVReader(String filename, String s, boolean h)
    {
        filepath = filename;
        sep = s;
        hasHeader = h;
        header = null;
        data = new ArrayList<String[]>();
    }

    /**
     * Read data into ArrayList
     *
     * @return // true if no error
     */
    public boolean ReadFile()
    {
        if (filepath != "")
        {
            File file = new File(filepath);

            if (!file.canRead() || !file.isFile())
            {
                return false;
            }

            BufferedReader in = null;
            try
            {
                in = new BufferedReader(new FileReader(filepath));
                String line = null;
                while ((line = in.readLine()) != null)
                {
                    if (hasHeader && header == null)
                    {
                        header = line.split(sep);
                    } else
                    {
                        data.add(line.split(sep));
                    }
                }
            } catch (IOException e)
            {
                return false;
            } finally
            {
                if (in != null)
                {
                    try
                    {
                        in.close();
                    } catch (IOException e)
                    {
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the column header
     *
     * @return // String Array
     */
    public String[] getHeader()
    {
        return header;
    }

    /**
     * Returns data array list
     *
     * @return // ArrayList<String[]>
     */
    public ArrayList<String[]> getData()
    {
        return data;
    }

}
