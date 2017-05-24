/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

import static bigProjet.Joueur.i;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author 13585
 */
public class BigProjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        playTour();
        

    }
    
    public static void playTour()throws IOException{
        String input = "";
        boolean out=false;
        String city = "";
        String name = "";
        Surface s = null;
        while(!out){
            System.out.println("Please choose your Tournoi's name:");
            System.out.println("1.l'Open d'Australie");
            System.out.println("2.Rolan Garros");
            System.out.println("3.Wimlbledon");
            System.out.println("4.l'US Open");
            System.out.println("0.Exit");
            Scanner scan = new Scanner (System.in);
            input = scan.nextLine();
            switch(input){
                case "1":
                    name = "l'Open d'Australie";
                    city = "Melbourne";
                    s = Surface.Plexicushion;
                    break;
                case "2":
                    name = "Rolan Garros";
                    city = "Paris";
                    s = Surface.TerreBattue;
                    break;
                case "3":
                    name = "Wimlbledon";
                    city = "Londres";
                    s = Surface.Gazon;
                    break;
                case "4":
                    name = "l'US Open";
                    city = "New York";
                    s = Surface.Decoturf;
                    break;
                case "0":
                    out = true;
                    break;
                default:
                    System.out.println("Error. Please input again.");
            }
            if(!out){
                System.out.println("Please input the year:");
                scan = new Scanner (System.in);
                input = scan.nextLine();
                int year = Integer.parseInt(input);
                Tournoi t = new Tournoi (name,city,year,s);
                t.playTournoi();
            }
        }
    }
}
