/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package bigProjet;

import java.util.Calendar;
import java.util.Date; //pour obtenir le date maintenant
import java.text.SimpleDateFormat; //le format de date

/**
 *
 * @author Yifei TAN & Kaichen SHEN
 */
public class Personne {
    
    // les arguments
    protected String prenom;
    protected String surnom;
    protected String nomDeNaissance;
    protected String nomCourant;
    protected int dateDeNaissance;
    protected int dateDeDeces;
    protected String nationalite;
    protected int taille;
    protected int poids;
    protected boolean vieOuDecedee;  //ture -> en vie; false -> decedee
    protected char gendre;
    protected Vetement vetement;
    
    
    //les constructeurs  
    
    //non arguments
    Personne(){       
        
    }
    
    //personne en vie
    Personne (String pnom, String snom, String ndn, String nc, String na, int ddn, int t, int p, char g){
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
        this.testPersonne();
        
    }
    
    //personne qui est mort
    Personne (String pnom, String snom, String ndn, String nc, String na, int ddn, int ddd, int t, int p, char g){
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
        this.testPersonne();
    }
    
    //les method qui change les argument qui peut etre change
    public void setNomCourant(String nc){
        this.nomCourant = nc;
    }
    
    public void setNationalite(String na){
        this.nationalite = na;
    }
    
    public void setTaille(int t){
        this.taille = t;
    }
        
    public void setPoids(int p){
        this.poids = p;
    }
    
    public void setDateDeDeces(int ddd){
        this.dateDeDeces = ddd;
        this.vieOuDecedee = false;
    }
    
    //recuperer les argument
    public String getPrenom (){
        return this.prenom;
    }

    public String getSurnom (){
        return this.surnom;
    }
    
    public String getNomDeNaissance (){
        return this.nomDeNaissance;
    }
    
    public String getNomCourant (){
        return this.nomCourant;
    }
    
    public int getDateDeNaissance (){
        return this.dateDeNaissance;
    }
    
    public int getDateDeDeces (){
        return this.dateDeDeces;
    }
    
    public String getNationalite (){
        return this.nationalite;
    }
    
    public int getTaille (){
        return this.taille;
    }
    
    public int getPoids (){
        return this.poids;
    }
    
    public boolean getVieOuDecedee (){
        return this.vieOuDecedee;
    }
    
    public char getGendre(){
        return this.gendre;
    }
    
    public int getAge(){
        String n=new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        int now = Integer.parseInt(n);
        int age = now - this.dateDeNaissance;
        age = age/10000;
        return age;
    }
    
    public String toString(){
        return this.surnom;
    }

    
    //finalize
    protected void finalize(){
        //ajouter les codes si tu veux
    }
    
    //verifier les arguments
    public void testPersonne(){
    int year = this.dateDeNaissance / 10000;
    int month = (this.dateDeNaissance - (year * 10000)) / 100;
    int date =  this.dateDeNaissance - (year * 10000) - (month * 100);
    if (month > 12){
        System.out.println("Error: " + this.prenom + " " + this.surnom + " creation failed. Month is bigger than 12.");
        this.finalize();
    }
    if (date > 31){
        System.out.println("Error: " + this.prenom + " " + this.surnom + " creation failed. Date is bigger than 31.");
        this.finalize();
    }
    if (this.gendre!='F'&&this.gendre!='M'){
        System.out.println("Error: " + this.prenom + " " + this.surnom + " creation failed. Genre is wrong.");
        this.finalize();
    }

}
}