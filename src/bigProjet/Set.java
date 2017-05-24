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
public class Set {
    private String teamA;
    private String teamB;
    private String winner;
    private Arbitres mainArbitres;
    private JeuNormal j;
    private Jeu7 j7;
    private int jeuA;
    private int jeuB;
    private boolean win = false;
    private boolean j7OrNot = false;
    private boolean setLong = false;

    Set(String a, String b, Arbitres m){
        this.jeuA = 0;
        this.jeuB = 0;
        this.teamA = a;
        this.teamB = b;
        this.mainArbitres = m;
        this.j = new JeuNormal(this.teamA, this.teamB, this.mainArbitres);
        this.j7 = new Jeu7(this.teamA, this.teamB, this.mainArbitres);
        this.winner = null;
        
    }
    

    
    public int getjeuA(){
        return this.jeuA;
    }
    
    public int getjeuB(){
        return this.jeuB;
    }
    
    public Arbitres getmainArbitres(){
        return this.mainArbitres;
    }
    
    public String getTeamA(){
        return this.teamA;
    }
    
    public String getTeamb(){
        return this.teamB;
    }
    
    public JeuNormal getJeuNormal(){
        return this.j;
    }
    
    public Jeu7 getJeu7(){
        return this.j7;
    }
        
    public String getWinner(){
        return this.winner;
    }
    
    public void setjeuA(int jeua){
        this.jeuA=jeua;
    }
    
     public void setjeuB(int jeub){
        this.jeuB=jeub;
    }
    
    public void setteamA(String teama){
        this.teamA=teama;
    }
    
    public void setteamB(String teamb){
        this.teamB=teamb;
    }
    
    public void setmainArbitres(Arbitres m){
        this.mainArbitres=m;
    }
    
    public void setjeu(JeuNormal jn){
        this.j=jn;
    }
    
    public void setjeu7(Jeu7 j){
        this.j7=j;
    }
    
    
    public void setLong(){
        this.setLong = true;
    }
    
    
    
    
    
    public void teamAGetJeu(){
        this.jeuA++;
    }
    
    public void teamBGetJeu(){
        this.jeuB++;
    }
    
    public void jeuWinner(){
        if(!this.j7OrNot){    
            if(j.getWinner().equals(teamA)){
                    teamAGetJeu();
                    System.out.println("Set:" + this.teamA + ":" + this.jeuA + "--" +this.jeuB+":"+this.teamB);
                }
                else{
                    teamBGetJeu();
                    System.out.println("Set:" + this.teamA + ":" + this.jeuA + "--" +this.jeuB+":"+this.teamB);
                }
        }
        else{
            if(j7.getWinner().equals(teamA)){
                    teamAGetJeu();
                    System.out.println("Set:" + this.teamA + ":" + this.jeuA + "--" +this.jeuB+":"+this.teamB);
                }
                else{
                    teamBGetJeu();
                    System.out.println("Set:" + this.teamA + ":" + this.jeuA + "--" +this.jeuB+":"+this.teamB);
                }
        }
    }
    
    public void testAWin(){
        if(this.jeuA==6&&this.setLong==false){
            if(this.jeuB<5){
                this.winner = this.teamA;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
            }
        }
        else if(this.jeuA==7){
            if((this.jeuB==5 || this.jeuB==6)&&this.setLong==false){
                this.winner = this.teamA;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
            }   
        }
        else if (this.jeuA-this.jeuB>=2&&this.setLong==true&&this.jeuA>=7){
            this.winner = this.teamA;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
                this.setLong=false;
        }
        if(this.jeuA==7&&this.jeuB==6) this.j7OrNot=false;
    }
    
    public void testBWin(){
        if(this.jeuB==6&&this.setLong==false){
            if(this.jeuA<5){
                this.winner = this.teamB;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
            }
        }
        else if(this.jeuB==7&&this.setLong==false){
            if(this.jeuA==5 || this.jeuA==6){
                this.winner = this.teamB;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
            }   
        }
        else if (this.jeuB-this.jeuA>=2&&this.setLong==true&&this.jeuB>=7){
                this.winner = this.teamB;
                System.out.print("Winner of the Set:");
                System.out.println(this.winner);
                win = true;
                this.setLong=false;
        }
        if(this.jeuB==7&&this.jeuA==6) this.j7OrNot=false;
    }
    
    public void testSet(){
        testAWin();
        testBWin();
        if(this.jeuA==this.jeuB&&this.jeuA==6&&(!this.setLong)){
            this.j7OrNot=true;
        } 
        
    }
    
    public void playSet(){
        while(!win&&(!this.j7OrNot)){
            j.playJeu();
            jeuWinner();
            testSet();
        }
        while(this.j7OrNot){
            j7.playJeu();
            jeuWinner();
            testSet();
        }
        this.jeuA = 0;
        this.jeuB = 0;
        this.win = false;
        this.j7OrNot = false;
        this.setLong = false;
    }
}
