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
public class Echange {
    
    private String hitter;
    private String servicer;
    private String another;
    private String deServicer;
    private String getScore;
    private Arbitres mainArbitres;
    private String state="service";
    private int chance = 0;
    private int echange = 0;
    private boolean aceOrNot = true;
    private static int doubleFaute = 0;
    
   
    Echange(String a1, String a2, Arbitres m){
        this.hitter = a1;
        this.servicer = this.hitter;
        this.another = a2;
        this.deServicer = this.another;
        this.mainArbitres = m;
        this.getScore = this.hitter;
    }
    
    
    public void setHitter(String a){
        this.hitter = a;
    }
    
    public void setAnother(String a){
        this.another = a;
    }
    
    public void setServicer(String a){
           if(!this.servicer.equals(a)){
               changeServicer();
           }
    }
    
    public void setDeServicer(String a){
        this.deServicer = a;
    }
    
    public void setArbitres(Arbitres a){
        this.mainArbitres = a;
    }
    
    public void setState(String s){
        this.state = s;
    }
    
    public void resetEchange(){
        echange = 0;
    }
    
    public void resetDoubleFaute(){
        doubleFaute = 0;
    }
    
    public String getHitter(){
        return this.hitter;
    }
    
    public String getAnother(){
        return this.another;
    }
    
    public boolean getAceOrNot(){
        return this.aceOrNot;
    }
    
    public String showScorer(){
        return this.getScore;
    }
    
    public Arbitres getArbitres(){
        return this.mainArbitres;
    }
    
    public String getState(){
        return this.state;
    }
    
    public String getGetScore(){
        return this.getScore;
    }

    public int getChance(){
        return this.chance;
    }
    
    public int getEchangeNumber(){
        return this.echange;
    }
    
    public int getDoubleFaute(){
        return doubleFaute;
    }
    
    private void swap(){
        String temp;
        temp = this.hitter;
        this.hitter = this.another;
        this.another = temp;
        System.out.println("Next hitter: " + this.hitter);
        System.out.println();
        
    }
    
    private void normalState(){
        String e;
        System.out.println("Normal hit:");
        e = this.mainArbitres.judge();
        switch (e){
            case "1":
                this.getScore = this.another;
                this.aceOrNot = false;
                this.state = "finish";
                this.mainArbitres.setState("finish");
                System.out.println("result: "+ this.hitter +" faute");
                System.out.println();
                break;
            case "2":
                this.getScore = this.another;
                this.aceOrNot = false;
                this.state = "finish";
                this.mainArbitres.setState("finish");
                System.out.println("result: "+ this.hitter +" filet");
                System.out.println();
                break;
            case"3":
                System.out.println("result: "+ this.hitter +" hitback");
                swap();
                this.aceOrNot = false;
                this.echange++;
                break;
            case"4":
                this.getScore = this.another;
                this.state = "finish";
                this.mainArbitres.setState("finish");
                System.out.println("result: "+ this.hitter +" miss");
                System.out.println();
                break;
            default:
                System.out.println("Input Error");
        }
    }
    
    private void serviceState(){
        String e;
        System.out.println("Service:" + this.hitter);
        e = this.mainArbitres.judge();
        switch (e){
            case "1":
                if(this.chance < 1){
                    System.out.println("result: "+ this.hitter +" service faute");
                    System.out.println();
                    this.chance++;
                    break;
                }
                else{
                    System.out.println("result: "+ this.hitter +" service faute twice");
                    System.out.println();
                    this.getScore = this.another;
                    doubleFaute++;
                    this.aceOrNot = false;
                    this.state = "finish";
                    this.mainArbitres.setState("finish");
                    break;
                }
            case "2":
                System.out.println("result: "+ this.hitter +" reservice");
                System.out.println();
                break;
            case"3":
                this.state = "normal";
                this.mainArbitres.setState("normal");
                System.out.println("result: "+ this.hitter +" Service correct ");
                System.out.println("Game state:" + this.state);
                swap();
                break;
            default:
                System.out.println("Input Error");
                
        }
    }
    
    void changeServicer(){
        String temp;
        temp = this.servicer;
        this.servicer = this.deServicer;
        this.deServicer = temp;
        
    }
    
    void evenement(){
        this.state = "service";
        this.hitter = this.servicer;
        this.another = this.deServicer;
        this.chance = 0;
        this.aceOrNot = true;
        this.mainArbitres.setState("service");
        while(!this.state.equals("finish")){
            if(this.state.equals("normal")){
                normalState();
            }
            else{
                serviceState();
                }
        }
        
        
    }
    
    
    
}
