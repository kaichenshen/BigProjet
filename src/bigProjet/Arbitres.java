/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

import java.util.Scanner;

/**
 *
 * @author 13585
 */


public class Arbitres extends Personne {
    
    private String state="service";
    

    
    Arbitres (String pnom, String snom, String ndn, String nc, String na, int ddn, int t, int p, char g){
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
    
    public void setState(String a){
        this.state=a;
    }
    
    public String judge(){
        int r=0;
        //Scanner scan=new Scanner(System.in);
        //String judge=scan.nextLine();
        switch (this.state){
            
            case "service":
                r = new java.util.Random().nextInt(3)+1;
                break;
            case "normal":
                r = new java.util.Random().nextInt(4)+1;
                break;
            case "finish":
                this.state = "service";
                break;
            default:
                System.out.println("Error");
                break;
        }
        return r+"";
    }
    

    
    
}
