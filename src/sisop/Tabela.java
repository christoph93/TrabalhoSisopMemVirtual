/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisop;

import java.util.ArrayList;
import java.util.Random;

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

    public String[][] calculaTabela() {
        int numPags = VA / PS;

        String[][] t = new String[numPags][3];
        
        int prct = (int) (numPags / 4);

        ArrayList<Integer> aux = new ArrayList<>();
        
        Random rand = new Random();        
        
        for(int i = 0; i < prct; i++){
            int a = rand.nextInt(numPags);
            
            while(aux.contains(a)){
                a = rand.nextInt(numPags);
            }            
            aux.add(a);
        }      
        
        for (int i = 0; i < numPags; i++) {
            t[i][0] = "[" + i + "]";
            if(aux.contains(i)){
                t[i][1] = "v";
                t[i][2] = "0x" + String.format("%08X", rand.nextInt(numPags));
                        
                        
                        //String.format("%x", Integer.toHexString(rand.nextInt(numPags)));
            } else {
                t[i][1] = "i";
                t[i][2] = "0x00000000";
            }
        }
        
        return t;
    }

    public void imprimeTrabela(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i][0] + " " + tab[i][1] + " " + tab[i][2]);
        }
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
