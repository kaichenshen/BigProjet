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
abstract public class Jeu {
    protected String teamA;
    protected String teamB;
    protected String winner;
    protected Arbitres mainArbitres;
    protected Echange e;
    protected static int echangeNumber=0;
    protected static int aceNumber=0;
    protected static int breakService=0;
    protected boolean win = false;
    
    public String getTeamA(){
        return this.teamA;
    }
    
    public String getTeamB(){
        return this.teamB;
    }
    
    public String getWinner(){
        return this.winner;
    }
    
    public Arbitres getArbitres(){
        return this.mainArbitres;
    }
    
    public Echange getEchange(){
        return this.e;
    }
    
    public int getEchangeNumber(){
        return echangeNumber;
    }
    
    public int getAceNumber(){
        return aceNumber;
    }
    
    public int getBreakService(){
        return breakService;
    }
    
    public void setTeamA(String a){
        this.teamA = a;
    }
    public void setTeamB(String a){
        this.teamB = a;
    }
    public void setWinner(String a){
        this.winner = a;
    }
    public void setArbitres(Arbitres a){
        this.mainArbitres = a;
    }
    public void setEchange(Echange a){
        this.e = a;
    }
    public void resetBreakService(){
        breakService =0;
    }
    public void resetAceNumber(){
        aceNumber =0;
    }
    public void resetEchangeNumber(){
        this.e.resetEchange();
        echangeNumber = 0;
    }
    
    public void calculateEchangeNumber(){
        echangeNumber = echangeNumber + e.getEchangeNumber();
    }
    
    public void calculateAceNumber(){
        if(e.getAceOrNot()){
            aceNumber++;
        }
    }
    
    public void calculateBreakServiceNumber(){
        if(this.winner.equals(this.e.getAnother()))
            breakService++;
    }
    
    public void showWinner(){
        System.out.println("Winner is:" + this.winner);
    }
    
    
    abstract public void teamAGetScore();
    
    abstract public void teamBGetScore();
    
    abstract public void calculateScore();
    
    abstract public void scoreTest();
    
    abstract public void playJeu();
    
}
