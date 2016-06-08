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

    private int VA, PS, PTE, NUM, VAbits, PSbits;
    private String[][] tabela;
    Random rand;

    public Tabela(int VA, int PS, int PTE, int NUM) {
        rand = new Random();
        this.VA = VA;
        this.PS = PS;
        this.PTE = PTE;
        this.NUM = NUM;
        VAbits = (int) (Math.log(VA * 1024) / Math.log(2));
        PSbits = (int) (Math.log(PS * 1024) / Math.log(2));
        tabela = calculaTabela();

    }

    public void init() {
        imprimeTrabela(tabela);
        comparaEnderecos();
    }

    private String[][] calculaTabela() {
        int numPags = VA / PS;

        String[][] t = new String[numPags][3];

        int prct = (int) (numPags / 4);

        ArrayList<Integer> aux = new ArrayList<>();

        System.out.println("VAbits " + VAbits);
        System.out.println("PSbits " + PSbits);

        for (int i = 0; i < prct; i++) {
            int a = rand.nextInt(numPags);

            while (aux.contains(a)) {
                a = rand.nextInt(numPags);
            }
            aux.add(a);
        }

        for (int i = 0; i < numPags; i++) {
            t[i][0] = "[" + i + "]";
            if (aux.contains(i)) {
                t[i][1] = "v";
                t[i][2] = String.format("%08X", rand.nextInt((int) Math.pow(2, VAbits - PSbits)));
            } else {
                t[i][1] = "f";
                t[i][2] = "00000000";
            }
        }

        return t;
    }

    private void comparaEnderecos() {
        //gera
        int[] enderecos = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            enderecos[i] = rand.nextInt((int) Math.pow(2, VAbits) - 1);
        }

        //valida
        for (int i : enderecos) {
            int VAshifted = i >> PSbits;
            if (tabela[VAshifted][1].equals("f")) {
                System.out.println("VA 0x" + String.format("%08X", i) + " --> Inválido [VPN " + VAshifted + "]");
            } else {
                int aux = Integer.parseInt(tabela[VAshifted][2]) << PSbits;
                int off = i << VAbits - PSbits;
                int temp = off & ((int) Math.pow(2, VAbits) - 1);
                temp = temp >> VAbits - PSbits;

                System.out.println("VA 0x" + String.format("%08X", i) + " --> " + String.format("%08X", temp | aux) + "[VPN " + VAshifted + "]");
            }

        }
    }

    public void imprimeTrabela(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i][0] + " " + tab[i][1] + " 0x" + tab[i][2]);
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
