/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigProjet;

/**
 *@param 
 * @author 13585
 */
public class JeuNormal extends Jeu{
    private Score teamAScore ;
    private Score teamBScore ;
    
    JeuNormal(String a, String b, Arbitres m){
        this.teamAScore = Score.Score0;
        this.teamBScore = Score.Score0;
        this.teamA = a;
        this.teamB = b;
        this.mainArbitres = m;
        this.e = new Echange(this.teamA, this.teamB, this.mainArbitres);
        this.winner = null;
    }
    
    
    
    
    public Score getTeamAScore(){
        return this.teamAScore;
    }
    
    public Score getTeamBScore(){
        return this.teamBScore;
    }
    
    public void setTeamAScore(String s){
        switch(s){
            case "0":
                this.teamAScore = Score.Score0;
                break;
            case "15":
                this.teamAScore = Score.Score1;
                break;
            case "30":
                this.teamAScore = Score.Score2;
                break;
            case "40":
                this.teamAScore = Score.Score3;
                break;
            case "AV":
                this.teamAScore = Score.Score4;
                break;
        }
    }
    
    public void setTeamBScore(String s){
        switch(s){
            case "0":
                this.teamBScore = Score.Score0;
                break;
            case "15":
                this.teamBScore = Score.Score1;
                break;
            case "30":
                this.teamBScore = Score.Score2;
                break;
            case "40":
                this.teamBScore = Score.Score3;
                break;
            case "AV":
                this.teamBScore = Score.Score4;
                break;
        }
    }
    
    
    
    public void teamAGetScore(){
        switch(this.teamAScore.toValue()){
            case "0":
                this.teamAScore = Score.Score1;
                break;
            case "15":
                this.teamAScore = Score.Score2;
                break;
            case "30":
                this.teamAScore = Score.Score3;
                break;
            case "40":
                this.teamAScore = Score.Score4;
                break;
            case "AV":
                if (this.teamBScore.toValue().equals("40")){
                    this.winner = this.teamA;
                    this.win = true;
                }
                else{
                    System.out.println("Error.");
                }
                break;
        }
    }
    
    public void teamBGetScore(){
        switch(this.teamBScore.toValue()){
            case "0":
                this.teamBScore = Score.Score1;
                break;
            case "15":
                this.teamBScore = Score.Score2;
                break;
            case "30":
                this.teamBScore = Score.Score3;
                break;
            case "40":
                this.teamBScore = Score.Score4;
                break;
            case "AV":
                 if (this.teamAScore.toValue().equals("40")){
                    this.winner = this.teamB;
                    this.win = true;
                }
                else{
                    System.out.println("Error.");
                }
                break;
        }
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
        if(this.teamAScore.toValue().equals("AV")){
                if(!(this.teamBScore.toValue().equals("40")||this.teamBScore.toValue().equals("AV"))){
                    this.winner = this.teamA;
                    this.win = true;
                }
                else{
                    if(this.teamBScore.toValue().equals("AV")){
                        this.teamAScore = Score.Score3;
                        this.teamBScore = Score.Score3;
                    }
                }
        }
        
        if(this.teamBScore.toValue().equals("AV")){
                if(!(this.teamAScore.toValue().equals("40")||this.teamAScore.toValue().equals("AV"))){
                    this.winner = this.teamB;
                    this.win = true;
                }
                else 
                {
                    if(this.teamAScore.toValue().equals("AV")){
                        this.teamAScore = Score.Score3;
                        this.teamBScore = Score.Score3;
                    }
                }
        }
    }
    
    
    
    
    public void playJeu(){
        while(!this.win){
            System.out.println("/***********************************************/");
            this.e.evenement();
            System.out.println("Scorer:" + e.showScorer());
            calculateScore();
            scoreTest();
            if(!this.win){
                System.out.println("Game" +this.teamA + "--" + this.teamAScore + ":" + this.teamBScore + "--" + this.teamB);
            }
        }
        System.out.println("/***********************************************/");
        showWinner();
        this.calculateEchangeNumber();
        this.calculateAceNumber();
        this.e.changeServicer();
        this.calculateBreakServiceNumber();
        this.teamAScore = Score.Score0;
        this.teamBScore = Score.Score0;
        this.win = false;
        
    }
    
    
}
