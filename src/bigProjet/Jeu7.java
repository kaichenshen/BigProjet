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
public class Jeu7 extends Jeu{
    private int teamAScore ;
    private int teamBScore ;
    private int flag = 1;
    
    Jeu7(String a, String b, Arbitres m){
        this.teamAScore = 0;
        this.teamBScore = 0;
        this.teamA = a;
        this.teamB = b;
        this.mainArbitres = m;
        this.e = new Echange(this.teamA, this.teamB, this.mainArbitres);
        this.winner = null;
    }
    
    
    
    public int getTeamAScore(){
        return this.teamAScore;
    }
    
    public int getTeamBScore(){
        return this.teamBScore;
    }
    
    public void setTeamAScore(int i){
        if (!(i>0&&i<8)){
            System.out.println("Set Error.");
        }
        else{
            this.teamAScore = i;
        }
    }
    
    public void setTeamBScore(int i){
        if (!(i>0&&i<8)){
            System.out.println("Set Error.");
        }
        else{
            this.teamBScore = i;
        }
    }
    
    
    
    public void teamAGetScore(){
        this.teamAScore++;
    }
    
    public void teamBGetScore(){
        this.teamBScore++;
    }
    
    public void calculateScore(){
        if (e.showScorer().equals(teamA)){
                this.teamAGetScore();
            }
            else{
                this.teamBGetScore();
                
            }
    }
    
    public void scoreTest(){
       if(this.teamAScore>=7){
           if(this.teamAScore-this.teamBScore>=2){
               this.winner = this.teamA;
               this.win=true;
           }
       }
       if(this.teamBScore>=7){
           if(this.teamBScore-this.teamAScore>=2){
               this.winner = this.teamB;
               this.win=true;
           }
       }
       if(!this.win){
           
       }
    }
    
    
    
    
    public void playJeu(){
        while(!win){
            System.out.println("/***********************************************/");
            this.e.evenement();
            flag++;
            if(flag==2){
               flag=0;
               e.changeServicer();
            }
            System.out.println("Scorer:" + e.showScorer());
            System.out.println();
            calculateScore();
            scoreTest();
            if(!this.win){
                System.out.println("Game" + this.teamA + "--" + this.teamAScore + ":" + this.teamBScore + "--" + this.teamB);
            }
        }
        System.out.println("/***********************************************/");
        showWinner();
        this.e.changeServicer();
        this.calculateEchangeNumber();
        this.calculateAceNumber();
        this.calculateBreakServiceNumber();
        this.teamAScore = 0;
        this.teamBScore = 0;
        this.win = false;
        
    }
    
}
