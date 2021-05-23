/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author miche_uce8t6c
 */
public class Main implements Serializable
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[8];
        int sceltaUtente=0;
        Scanner tastiera=new Scanner(System.in);
        CentroFitness c1=new CentroFitness();
        Utente utente;
        String nome;
        String cognome;
        LocalDateTime accesso=null;
        LocalDateTime uscita=null;
        int giorno,mese,anno,ora,minuto;
        int giornoU,meseU,annoU,oraU,minutoU;
        int esitoOperazione;
        int codiceIdentificativo=1;
        int posizione;
        String nomeFileTesto="utentiCentroFitness.txt";
        String nomeFileBinario="utentiCentroFitnessBinario.bin";
        
        
        vociMenu[0]="Chiudi applicazione";
        vociMenu[1]="Registra nuovo accesso";
        vociMenu[2]="Elimina accesso";
        vociMenu[3]="Visualizza la data di presenza di uno specifico utente";
        vociMenu[4]="Registra uscita dell'utente";
        vociMenu[5]="Visualizza tutti gli Utenti";
        vociMenu[6]="Esporta utenti su file CSV";
        vociMenu[7]="Salva dati";
        
        
        try 
        {
            FileInputStream f1=new FileInputStream(nomeFileBinario);
            ObjectInputStream reader=new ObjectInputStream(f1);

            try
            {
                c1=(CentroFitness)reader.readObject();
                reader.close();
                System.out.println("\nLettura avvenuta correttamente");
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("Errore di lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file"); 
        }
        
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("Applicazione chiusa. Arrivederci! :)");
                        break;
                    }
                    case 1:
                    {
                        System.out.println("Premi invio per continuare");
                        tastiera.nextLine();
                        System.out.println("Inserisci i dati dello studente");
                        System.out.println("Nome --> ");
                        nome=tastiera.nextLine();
                        System.out.println("Cognome --> ");
                        cognome=tastiera.nextLine();
                        System.out.println("DATA\n");                        
                        System.out.println("Giorno--> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Mese--> ");
                        mese=tastiera.nextInt();                      
                        System.out.println("Anno--> ");
                        anno=tastiera.nextInt();
                        System.out.println("\nORARIO\n");
                        System.out.println("Ora--> ");
                        ora=tastiera.nextInt();
                        System.out.println("Minuto--> ");
                        minuto=tastiera.nextInt();
                        accesso=LocalDateTime.of(anno, mese, giorno, ora, minuto);
                        
                        utente=new Utente(codiceIdentificativo, nome, cognome, giorno, mese, anno, ora, minuto);
                        codiceIdentificativo++;
                        esitoOperazione=c1.aggiungiAccesso(utente);
                        if (esitoOperazione==-1)
                            System.out.println("Massimo numero di utenti raggiunto. Impossibile aggiungere l'utente");
                        else
                            System.out.println("Utente aggiunto correttamente");
                        
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Premi invio per continuare");
                        tastiera.nextLine();
                        System.out.println("Inserisci il nome dell'utente");
                        nome=tastiera.nextLine();
                        
                        System.out.println("\nInserisci la data di accesso");
                        System.out.println("Giorno--> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Mese--> ");
                        mese=tastiera.nextInt();
                        System.out.println("Anno--> ");
                        anno=tastiera.nextInt();
                        System.out.println("Ora--> ");
                        ora=tastiera.nextInt();
                        System.out.println("Minuto--> ");
                        minuto=tastiera.nextInt();
                        accesso=LocalDateTime.of(anno, mese, giorno, ora, minuto);
                        esitoOperazione=c1.eliminaAccesso(nome,accesso);
                        if(esitoOperazione==-1)
                            System.out.println("Studente non presente");
                        else
                            System.out.println("Accesso rimosso correttamente");
                        break;
                    }
                    
                    case 3:
                    {
                        System.out.println("Premi invio per continuare");
                        tastiera.nextLine();
                        System.out.println("Inserisci il nome dell'Utente");
                        nome=tastiera.nextLine();
                        
                        System.out.println("Inserisci il cognome dell'Utente");
                        cognome=tastiera.nextLine();
                        utente=c1.getUtente(nome, cognome);
                        if (utente==null)
                            System.out.println("\nUtente non presente");
                        else
                        {
                            System.out.println("UTENTE\n"+utente.toString());
                            tastiera.nextLine();
                            System.out.println(utente.getAccesso().toString());
                        }
                        
                        break;
                    }
                    
                    case 4:
                    {
                        System.out.println("Premi invio per continuare");
                        tastiera.nextLine();
                        System.out.println("Inserisci il codice identificativo");
                        codiceIdentificativo=tastiera.nextInt();
                        utente=c1.getUtenteID(codiceIdentificativo);
                        posizione=c1.getPosizione(codiceIdentificativo);
                        if(posizione==-1)
                            System.out.println("Utente non presente");

                        else
                        {

                            System.out.println("Registra la data e ora di uscita di "+utente.getNome());

                            System.out.println("UTENTE\n"+utente.toString());

                            tastiera.nextLine();

                            System.out.println("Giorno uscita--> ");
                            giornoU=tastiera.nextInt();
                            System.out.println("Mese uscita--> ");
                            meseU=tastiera.nextInt();
                            System.out.println("Anno uscita--> ");
                            annoU=tastiera.nextInt();
                            System.out.println("Ora uscita--> ");
                            oraU=tastiera.nextInt();
                            System.out.println("Minuto uscita--> ");
                            minutoU=tastiera.nextInt();
                            c1.assegnaData(codiceIdentificativo,giornoU,meseU,annoU,oraU,minutoU);
                        }
                    }
                    
                    case 5:
                    {
                        System.out.println(c1.elencoStudenti());
                        break;   
                    }
                    
                    case 6:
                    {
                        try
                        {
                            c1.esportaUtentiCSV(nomeFileTesto);
                            System.out.println("Utenti esportati correttamente");
                        }
                        catch(IOException e1)
                        {
                            System.out.println("Impossibile accedere al file");
                        }
                        catch(FileException e2)
                        {
                            System.out.println(e2.toString());
                        }
                        break;
                    }
                    
                    case 7:
                    {
                        try
                        {
                            c1.salvaUtentiBinario(nomeFileBinario);
                            System.out.println("salvataggio avvenuto correttamente");
                            break;
                        }
                        catch(IOException e1)
                        {
                            System.out.println("impossibile accedere al file, gli utenti non sono stati salvati");
                            break;
                        }
                        catch(FileException e2)
                        {
                            System.out.println(e2.toString());
                            break;
                        }
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException el)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
        }while(sceltaUtente!=0);
    }
}
