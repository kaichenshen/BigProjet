/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

/**
 *
 * @author 13585
 */

public class Spectateur extends Personne {
    
    
    int billet;
    int numeroDePlace;
    private Action action = Action.normal;
    
    Spectateur (String pnom, String snom, String ndn, String nc, String na, int ddn, char g, int b, int ndp){
        this.prenom = pnom;
        this.surnom = snom;
        this.nomDeNaissance = ndn;
        this.nomCourant = nc;
        this.nationalite = na;
        this.dateDeNaissance = ddn;
        this.vieOuDecedee = false;
        this.gendre = g;
        this.billet = b;
        this.numeroDePlace = ndp;
        this.testPersonne();
        this.setVetement();
    }
    
    public void setBillet(int b){
        this.billet = b;
    }
    
    public void setNumeroDePlace(int ndp){
        this.numeroDePlace = ndp;
    }
    
    public void setAction(Action a){
        this.action = a;
    }
    
    public int getBillet(){
        return this.billet;
    }
    
    public int getNumeroDePlace(){
        return this.numeroDePlace;
    }
    
    public Action getAction(){
        return this.action;
    }
    
    public void setVetement(){
        if (this.gendre=='F'){
            vetement = new Lunettes();
        }
        else{
            vetement = new Chemise();
        }
    }
}
