/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author miche_uce8t6c
 */
public class Utente implements Serializable
{
    //attributi
    private int codiceIdentificativo;
    private String nome;
    private String cognome;
    private LocalDateTime accesso;
    private LocalDateTime uscita;
    
    /**
     * il metodo Utente è il costruttore della classe Utente
     * @param codiceIdentificativo
     * @param nome
     * @param cognome
     * @param giorno
     * @param mese
     * @param anno
     * @param ora
     * @param minuto 
     */
    public Utente(int codiceIdentificativo, String nome, String cognome, int giorno, int mese, int anno, int ora, int minuto)
    {
        this.codiceIdentificativo=codiceIdentificativo;
        this.nome=nome;
        this.cognome=cognome;
        accesso=LocalDateTime.of(anno,mese,giorno,ora,minuto);
        uscita=null;
    }
    /**
     * costruttore di copia della classe Utente
     * @param u 
     */
    public Utente(Utente u)
    {
        codiceIdentificativo=u.getCodiceIdentificativo();
        nome=u.getNome();
        cognome=u.getCognome();
        accesso=u.getAccesso();
        uscita=u.getUscita();
    }
    /**
     * costruttore vuoto della classe Utente
     */
    public Utente()
    {
        codiceIdentificativo=0;
        nome="";
        cognome="";
        accesso=LocalDateTime.now();
        uscita=LocalDateTime.now();
    }
    
    /**
     * getCodiceIdentificativo ritorna il codiceIdentificativo
     * @return codiceIdentificativo
     */
    public int getCodiceIdentificativo()
    {
        return codiceIdentificativo;
    }

    /**
     * setCodiceIdentificativo assegna codiceIdentificativo
     * @param codiceIdentificativo 
     */
    public void setCodiceIdentificativo(int codiceIdentificativo) 
    {
        this.codiceIdentificativo=codiceIdentificativo;
    }
    
    /**
     * restituisce nome
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * assegna nome
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome=nome;
    }

    /**
     * restituisce cognome
     * @return cognome
     */
    public String getCognome() 
    {
        return cognome;
    }

    /**
     * assegna cognome
     * @param cognome 
     */
    public void setCognome(String cognome) 
    {
        this.cognome=cognome;
    }
    
    /**
     * restituisce accesso
     * @return accesso
     */
    public LocalDateTime getAccesso()
    {
        return accesso;
    }
    
    /**
     * assegna accesso
     * @param giorno
     * @param mese
     * @param anno
     * @param ora
     * @param minuto 
     */
    public void setAccesso(int giorno,int mese, int anno, int ora, int minuto)
    {
        accesso=LocalDateTime.of(anno, mese, giorno, ora, minuto);
    }
    
    /**
     * restituisce uscita
     * @return 
     */
    public LocalDateTime getUscita()
    {
        return uscita;
    }
    
    /**
     * assegna uscita
     * @param giornoU
     * @param meseU
     * @param annoU
     * @param oraU
     * @param minutoU 
     */
    public void setUscita(int giornoU,int meseU, int annoU, int oraU, int minutoU)
    {
        uscita=LocalDateTime.of(annoU, meseU, giornoU, oraU, minutoU);
    }
    
    /**
     * visualizza tutti i dati di un utente
     * @return s
     */
    public String toString()
    {
        String s;
        s="\nID--> "+getCodiceIdentificativo()+"\nNome--> "+getNome()+"\nCognome--> "+getCognome()+"\nData Entrata--> "+getAccesso()+"\nData Uscita--> "+getUscita()+"\n";
        return s;
    }

}