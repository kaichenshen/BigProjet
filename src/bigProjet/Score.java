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
enum Score {
    Score0(0),Score1(1),Score2(2),Score3(3),Score4(4);
    
    private String s;
    
    private Score(int i){
        switch (i){
            case 0: 
                this.s = "0";
                break;
            case 1: 
                this.s = "15";
                break;
            case 2: 
                this.s = "30";
                break;
            case 3: 
                this.s = "40";
                break;
            case 4: 
                this.s = "AV";
                break;
        }
            
    }
    
    public String toValue(){
        return s;
    }  
    
    public String toString(){
        return s;
    }
}
