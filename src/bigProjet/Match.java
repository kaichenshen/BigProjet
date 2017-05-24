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
public class Match {
    private Joueur playerA1;
    private Joueur playerB1;
    private Joueur playerA2;
    private Joueur playerB2;
    private Joueur winner;
    private Arbitres mainArbitre;
    private String typeSOD;
    private char typeGendre; //m -> male; f -> female; x -> mixte;
    private int niveau;
    private int nombreDePoint;
    private int teamAScore;
    private int teamBScore;
    private Set set;
    private boolean win = false;
    
    Match() {
    
}
    //single
    Match(Joueur a, Joueur b, Arbitres main_a, int n, int ndp){
        this.playerA1 = a;
        this.playerA2 = null;
        this.playerB1 = b;
        this.playerB2 = null;
        this.mainArbitre = main_a;
        this.typeSOD = "single";
        this.typeGendre = a.gendre;
        this.niveau = n;
        this.nombreDePoint = ndp;
        this.set = new Set (a.getSurnom(),b.getSurnom(),main_a);
        
    }
    
    //double
    Match(Joueur a1, Joueur a2, Joueur b1, Joueur b2, Arbitres main_a, int n, int ndp){
        this.playerA1 = a1;
        this.playerA2 = a2;
        this.playerB1 = b1;
        this.playerB2 = b2;
        this.mainArbitre = main_a;
        this.typeSOD = "double";
        this.typeGendre=this.getDoubleGendre(a1, a2, b1, b2);
        this.niveau = n;
        this.nombreDePoint = ndp;
        this.set = new Set (a1.getSurnom() +"&"+ a2.getSurnom(),b1.getSurnom()+"&"+b2.getSurnom(),main_a);
        
    }
    
    public void setPlayerA1(Joueur a){
        this.playerA1 = a;
    }
    
    public void setPlayerA2(Joueur a){
        this.playerA2 = a;
    }
    
    public void setPlayerB1(Joueur a){
        this.playerB1 = a;
    }
    
    public void setPlayerB2(Joueur a){
        this.playerB2 = a;
    }
    
    public void setMainArbitres(Arbitres a){
        this.mainArbitre = a;
    }
    
    public void setNiveau(int n){
        this.niveau = n;
    }
    
    public void setNombreDePoint(int n){
        this.nombreDePoint = n;
    }
    
    public Joueur[] getPlayers(){
        Joueur[] j = new Joueur[4];
        j[0] = this.playerA1;
        if (this.typeSOD.equals("double")){
            j[1] = this.playerA2;
            j[2] = this.playerB1;
            j[3] = this.playerB2;
        }
        else{
            j[1] = this.playerB1;
        }
        return j;
    }
    
    public Arbitres getMainArbitres(){
        return this.mainArbitre;
    }
    
    public int getNiveau(){
        return this.niveau;
    }
    
    public int getNombreDePoint(){
        return this.nombreDePoint;
    }
    
    public void testSingleGendre(Joueur a, Joueur b){
        if (a.gendre != b.gendre){
            System.out.println("Error: the players' gendre are not same.");
        }

    }
    
    public char getDoubleGendre(Joueur a1, Joueur a2, Joueur b1, Joueur b2){
        if (a1.gendre == b1.gendre && a1.gendre == a2.gendre && b1.gendre == b2.gendre){
            return a1.gendre;
        }
        else if( a1.gendre != a2.gendre && b1.gendre != b2.gendre){
            return 'X'; // x -> mixte
        }
        else{
            finalize();
            System.out.println("Error: Double mixte game creation failed.");
            return 'e'; //
        }
    }
    
    public Joueur getWinner(){
        return this.winner;
    }
    
    public Joueur randomFirstService(){
        Joueur[] j = new Joueur [4];
        j=getPlayers();
        int r = new java.util.Random().nextInt(4);
        while(j[r]==null){
            r = new java.util.Random().nextInt(4);
        }
        return j[r];
    }
    
    
    
    
    public void setWinner(){
        if(this.set.getWinner().equals(this.playerA1.surnom)){
            this.teamAScore++;
            System.out.println("Macth:" + this.playerA1 + ":" + this.teamAScore + "--" +this.teamBScore+":"+this.playerB1);
        }
        else{
            this.teamBScore++;
            System.out.println("Macth:" + this.playerA1 + ":" + this.teamAScore + "--" +this.teamBScore+":"+this.playerB1);
        }
    }
    
    public void testMatchWin(){
        switch(this.typeGendre){
            case 'M':{
                if(this.teamAScore==this.teamBScore&&this.teamAScore==2){
                   this.set.setLong();
                }
                else if(this.teamAScore==3){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                else if(this.teamBScore==3){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }

               if(this.teamAScore-this.teamBScore>=2&&this.teamAScore>3){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                if(this.teamBScore-this.teamAScore>=2&&this.teamBScore>3){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                break;
                }
            
            case 'F':{
                if(this.teamAScore==this.teamBScore&&this.teamAScore==1){
                    this.set.setLong();
                    System.out.println("in");
                }
                else if(this.teamAScore==2){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                else if(this.teamBScore==2){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }

                if(this.teamAScore-this.teamBScore>=2&&this.teamAScore>3){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                if(this.teamBScore-this.teamAScore>=2&&this.teamBScore>3){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                break;
                }
            
            case'X':{
                if(this.teamAScore==this.teamBScore&&this.teamAScore==2){
                this.set.setLong();
                }else if(this.teamAScore==2){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                else if(this.teamBScore==2){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }

                if(this.teamAScore-this.teamBScore>=2){
                    this.winner = this.playerA1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                if(this.teamBScore-this.teamAScore>=2){
                    this.winner = this.playerB1;
                    this.win = true;
                    System.out.print("Winner of the Match:");
                    System.out.println(this.winner);
                }
                break;
            }

            default:{
                System.out.println("ERROR.");
                break;
            }
        }
    }
    

    
    public String playMatch(){
        this.set.getJeuNormal().getEchange().setServicer(randomFirstService().getSurnom());
        while(!win){
            this.set.playSet();
            setWinner();
            testMatchWin();
        }
        System.out.println();
        String message = "/****************Data statistics****************/\r\n"
                            + "Winner of the Match:"+this.winner+"\r\n"
                            +"Final Score of the Macth:" + this.playerA1 + ":" + this.teamAScore + "--" +this.teamBScore+":"+this.playerB1+"\r\n"
                            +"Echange Number: " + this.set.getJeuNormal().getEchangeNumber()+"\r\n"
                            +"Ace Number: " +this.set.getJeuNormal().getAceNumber()+"\r\n"
                            +"Double Faute Number: " +this.set.getJeuNormal().getEchange().getDoubleFaute()+"\r\n"
                            +"Break Service Number: " +this.set.getJeuNormal().getBreakService()+"\r\n"
                            +"/****************Data statistics****************/";
        System.out.println(message);
        this.set.getJeuNormal().resetEchangeNumber();
        this.set.getJeuNormal().e.resetDoubleFaute();
        this.set.getJeuNormal().resetAceNumber();
        this.set.getJeuNormal().resetBreakService();
        this.teamAScore = 0;
        this.teamBScore = 0;
        this. win = false;
        message = "Nivea"+this.niveau+": "+this.playerA1+" VS "+this.playerB1+"\r\n"+message;
        return message;
    }
    
    
    
    
    protected void finalize(){
        //ajouter les codes si tu veux
    }
}
