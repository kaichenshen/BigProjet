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
abstract class  Vetement {
    protected String color;
    protected char gendreFit;
    abstract void gendreFit(char g);
    public void setColor(String c){
        this.color = c;
    }
    public String showColor(){
        return color;
    }
    abstract void personneFit(String p);
}

class Jupe extends Vetement{
    
    
    
    Jupe(){
        this.color = "white";
        this.gendreFit = 'F';
    }
    
    public void gendreFit(char g){
        if (g==this.gendreFit){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }
    public void personneFit(String p){
        if (p.equals("Joueur")){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }

}

class Lunettes extends Vetement{

    
    Lunettes(){
        this.color = "white";
        this.gendreFit = 'F';
    }
    
    
    public void gendreFit(char g){
        if (g==this.gendreFit){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }
    public void personneFit(String p){
        if (p.equals("Spectateur")){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }

}

class Short extends Vetement{

    
    Short(){
        this.color = "white";
        this.gendreFit = 'M';
    }
    public void gendreFit(char g){
        if (g==this.gendreFit){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }
    public void personneFit(String p){
        if (p.equals("Joueur")){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }

}

class Chemise extends Vetement{

    Chemise(){
        this.color = "white";
        this.gendreFit = 'M';
    }
    public void gendreFit(char g){
        if (g==this.gendreFit){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }
    public void personneFit(String p){
        if (p.equals("Spectateur")){
            System.out.println("Fit");
        }
        else{
            System.out.println("Error.");
        }
    }
    
}
 

