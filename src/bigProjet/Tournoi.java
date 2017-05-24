/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

import java.io.*;
import java.util.*;

/**
 *
 * @author 13585
 */
public class Tournoi {
    private ArrayList <Joueur> listJoueur = new ArrayList <Joueur>();
    private ArrayList <Joueur> listJoueurTemp = new ArrayList <Joueur>();
    private ArrayList <Spectateur> listSpectateur = new ArrayList<Spectateur>();
    private ArrayList <Arbitres> listArbitres = new ArrayList<Arbitres>();
    private String name;
    private int year;
    private String city;
    private Surface surface;
    private Match match;
    private static int i=0;
    private static int matchNiveau = 1;
    private int nombreDePoint = 20;
    private boolean champion = false;
    File f;
    
    Tournoi(String n, String c,int y, Surface s){
        
        this.name = n;
        this.city = c;
        this.year = y;
        this.surface = s;
        System.out.println("1.For a real tournoi;");
        System.out.println("2.For a test tournoi;");
        Scanner scan = new Scanner (System.in);
        String in = scan.nextLine();
        switch (in){
            case "1":
                this.creatListsNormal();
                break;
            case "2":
                this.creatLists4();
                break;
            default:System.out.println("Error");
        }
        f = new File(this.name+"--"+this.city+"--"+this.year+".txt");
    }
    
    public Joueur autoJoueur(){
        int year = new java.util.Random().nextInt(30)+1965;
        int month = new java.util.Random().nextInt(12)+1;
        int day = new java.util.Random().nextInt(30)+1;
        int ddn = year*10000+month*100+day;
        int taille = new java.util.Random().nextInt(40)+160;
        int poid = new java.util.Random().nextInt(80)+110;
        String[] nation = {"China","French","American","Germen","Italian","Russien"};
        int na = new java.util.Random().nextInt(nation.length);
        char[] gendre = {'F','M'};
        int ge = new java.util.Random().nextInt(gendre.length);
        String[] main={"left","right"};
        int ma = new java.util.Random().nextInt(main.length);
        String prename = "A"+i;
        String surname="B"+i;
        String nomCourant="C"+i;
        String sponsor="D"+i;
        String entraineur="E"+i;
        i++;
        Joueur a = new Joueur (prename,surname,"",nomCourant,nation[na],ddn,taille,poid,gendre[ge],main[ma],sponsor,entraineur);
        return a;
    }
    
    public Arbitres autoArbitres(){
        int year = new java.util.Random().nextInt(30)+1965;
        int month = new java.util.Random().nextInt(12)+1;
        int day = new java.util.Random().nextInt(30)+1;
        int ddn = year*10000+month*100+day;
        int taille = new java.util.Random().nextInt(40)+160;
        int poid = new java.util.Random().nextInt(80)+110;
        String[] nation = {"China","French","American","Germen","Italian","Russien"};
        int na = new java.util.Random().nextInt(nation.length);
        char[] gendre = {'F','M'};
        int ge = new java.util.Random().nextInt(gendre.length);
        String prename = "A"+i;
        String surname="B"+i;
        String nomCourant="C"+i;
        i++;
        Arbitres a = new Arbitres (prename,surname,"",nomCourant,nation[na],ddn,taille,poid,gendre[ge]);
        return a;
    }
    
    public Spectateur autoSpectateur(){
        int year = new java.util.Random().nextInt(30)+1965;
        int month = new java.util.Random().nextInt(12)+1;
        int day = new java.util.Random().nextInt(30)+1;
        int ddn = year*10000+month*100+day;
        int billet = new java.util.Random().nextInt(200)+20;
        int numeroDePlace = new java.util.Random().nextInt(100)+1;
        String[] nation = {"China","French","American","Germen","Italian","Russien"};
        int na = new java.util.Random().nextInt(nation.length);
        char[] gendre = {'F','M'};
        int ge = new java.util.Random().nextInt(gendre.length);
        String prename = "A"+i;
        String surname="B"+i;
        String nomCourant="C"+i;
        i++;
        Spectateur a = new Spectateur (prename,surname,"",nomCourant,nation[na],ddn,gendre[ge],billet,numeroDePlace);
        return a;
    }
    
    public void creatListsNormal(){
        for(int j=0;j<256;j++){
            this.listJoueur.add(autoJoueur());
        }
        i = 0;
        for(int j=0;j<100;j++){
            this.listSpectateur.add(autoSpectateur());
        }
        i = 0;
        for(int j=0;j<10;j++){
            this.listArbitres.add(autoArbitres());
        }
        i = 0;
    }
    
     public void creatLists4(){
        for(int j=0;j<4;j++){
            this.listJoueur.add(autoJoueur());
        }
        i = 0;
        for(int j=0;j<100;j++){
            this.listSpectateur.add(autoSpectateur());
        }
        i = 0;
        for(int j=0;j<10;j++){
            this.listArbitres.add(autoArbitres());
        }
        i = 0;
    }
    
    public void startMatch() throws IOException{
        int player1=new java.util.Random().nextInt(this.listJoueur.size());
        int player2=new java.util.Random().nextInt(this.listJoueur.size());
        while(player1==player2){
            player1=new java.util.Random().nextInt(this.listJoueur.size());
            player2=new java.util.Random().nextInt(this.listJoueur.size());
        }
        int arbitres = new java.util.Random().nextInt(10);
        Joueur playerA = this.listJoueur.get(player1);
        Joueur playerB = this.listJoueur.get(player2);
        if(player1>player2){
            this.listJoueur.remove(player1);
            this.listJoueur.remove(player2);
        }else{
            this.listJoueur.remove(player2);
            this.listJoueur.remove(player1);
        }
        Arbitres mainArbitres = this.listArbitres.get(arbitres);
        this.match = new Match (playerA,playerB,mainArbitres,matchNiveau,nombreDePoint);
        FileWriter fw = new FileWriter (f,true);
        try{
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(this.match.playMatch());
            bw.newLine();
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally{
            fw.close();
        }
        this.listJoueurTemp.add(this.match.getWinner());
    }
    
    public void testRoundFinish() throws IOException{
        if(this.listJoueur.size()==0){
            matchNiveau++;
            this.listJoueur = this.listJoueurTemp;
            this.listJoueurTemp = new ArrayList <Joueur>(0);
        }
        if(this.listJoueur.size()==1){
            System.out.println("Champion is: "+this.listJoueur.get(0).prenom+" "+this.listJoueur.get(0).surnom);
            this.champion = true;
            FileWriter fw = new FileWriter (f,true);
            try{
                BufferedWriter bw = new BufferedWriter (fw);
                bw.write("Champion is: "+this.listJoueur.get(0).prenom+" "+this.listJoueur.get(0).surnom);
                bw.newLine();
                bw.newLine();
                bw.newLine();
                bw.flush();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }finally{
                fw.close();
            }
        }
    }
    
    public void playTournoi() throws IOException{
        while(!this.champion){
            startMatch();
            testRoundFinish();
        
        }
    }
    
}
