/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfile;

import eccezioni.FileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class TextFile implements Serializable
{
    private  char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public TextFile(String nomeFile, char mode) throws IOException
    {
        this.mode='R';
        if (mode=='w' || mode=='W')
            this.mode='W';
        if (this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile));
    }
    
    public TextFile(String nomeFile, char mode, boolean append) throws IOException
    {
        this.mode='R';
        if (mode=='w' || mode=='W')
            this.mode='W';
        if (this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile, append));
    }
    
    public void toFile(String line) throws IOException, FileException
    {
        if (mode=='R')
            throw new FileException("Impossibile scrivere sul file. File aperto in lettura.");
        writer.write(line);
        writer.newLine();
    }
    
    public String fromFile() throws FileException, IOException
    {
        String s;
        if (mode=='W')
            throw new FileException("Impossibile leggere da file. File aperto in scrittura.");
        s=reader.readLine();
        if (s==null)
            throw new FileException("Fine del file raggiunta");        
        return s;
        
    }
    
    public void close() throws IOException
    {
        if (mode=='R')
            reader.close();
        else
            writer.close();
    }
}
