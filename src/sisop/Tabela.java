/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisop;

/**
 *
 * @author 12104806
 */
public class Tabela {
    
    private int VA, PS, PTE, NUM;

    public Tabela(int VA, int PS, int PTE, int NUM) {
        this.VA = VA;
        this.PS = PS;
        this.PTE = PTE;
        this.NUM = NUM;
        
        
    }

    
    public String calculaTabela(){
        int numPags = VA/PS;
        
        String[][] t = new String[numPags][2];
        
        
        
        
        
        String tab = "";
        
        return tab;
    }
    
    
    @Override
    public String toString() {
        return "Tabela{" + "VA=" + VA + ", PS=" + PS + ", PTE=" + PTE + ", NUM=" + NUM + '}';
    }
    
    
    public int getVA() {
        return VA;
    }

    public void setVA(int VA) {
        this.VA = VA;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public int getPTE() {
        return PTE;
    }

    public void setPTE(int PTE) {
        this.PTE = PTE;
    }

    public int getNUM() {
        return NUM;
    }

    public void setNUM(int NUM) {
        this.NUM = NUM;
    }
    
    
   
    
    
    
}
