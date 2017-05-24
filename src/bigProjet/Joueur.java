/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

import java.util.*;

/**
 *
 * @author 13585
 */


public class Joueur extends Personne {
    static int i = 0;
    
     // les arguments
    private String main;  //Une main de jeu (Droitier ou Gaucher)
    private String sponsor;
    private int classement ;
    private String entraineur;
    
    
    
    //les constructeurs  
    Joueur(){
        
    }
    
    Joueur (String pnom, String snom, String ndn, String nc, String na, int ddn, int t, int p, char g, String m, String s, String e){
        this.prenom = pnom;
        this.surnom = snom;
        this.nomDeNaissance = ndn;
        this.nomCourant = nc;
        this.nationalite = na;
        this.dateDeNaissance = ddn;
        this.taille = t;
        this.poids = p;
        this.vieOuDecedee = true;
        this.gendre = g;
        this.main = m;
        this.sponsor = s;
        this.classement = i;
        i++;
        this.entraineur = e;
        this.testPersonne();
        this.setVetement();
    }
    
    Joueur (String pnom, String snom, String ndn, String nc, String na, int ddn, int ddd, int t, int p, char g, String m, String s, String e){
        this.prenom = pnom;
        this.surnom = snom;
        this.nomDeNaissance = ndn;
        this.nomCourant = nc;
        this.nationalite = na;
        this.dateDeNaissance = ddn;
        this.dateDeDeces = ddd;
        this.taille = t;
        this.poids = p;
        this.vieOuDecedee = false;
        this.gendre = g;
        this.main = m;
        this.sponsor = s;
        this.classement = i;
        i++;
        this.entraineur = e;
        this.testPersonne();
        this.setVetement();
    }

    
    //set et get method
    public void setSponsor(String s){
        this.sponsor = s;
    }
    
    public void setClassment(int c){
        this.classement = c;
    }
    
    public void setEntraineur(String e){
        this.entraineur = e;
    }
    
    public String getMain(){
        return this.main;
    }
    
    public String getSponsor(){
        return this.sponsor;
    }
    
    public int getClassment(){
        return this.classement;
    }
    
    public String getEntraineur(){
        return this.entraineur;
    }
    
    public void challenge(){
        //ajouter 
    }
    
    public void setVetement(){
        if (this.gendre=='F'){
            vetement = new Jupe();
        }
        else{
            vetement = new Short();
        }
    }
    
    public Spectateur becomeSpectateur(){
        int billet = 0;
        int numeroDePlace = 0;
        Scanner scan = new Scanner (System.in);
        System.out.println("Input the billet.");
        String s = scan.nextLine();
        int[] seq;
        seq = new int[2];
        seq[i] = Integer.parseInt(s);
        billet = seq[0];
        System.out.println("Input the numeroDePlace.");
        s = scan.nextLine();
        seq = new int[2];
        seq[i] = Integer.parseInt(s);
        numeroDePlace = seq[0];
        return new Spectateur (this.prenom, this.surnom, this.nomDeNaissance, this.nomCourant, this.nationalite, this.dateDeNaissance, this.gendre, billet, numeroDePlace);
    }
    
}
