/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 12104806
 */
public class Main {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileReader fr = new FileReader("config.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        
        String[] params = new  String[4];        
        Tabela t;
        while(line != null){            
            params = line.split(" ");
            t = new Tabela(Integer.parseInt(params[0]),
                    Integer.parseInt(params[1]),
                    Integer.parseInt(params[2]),
                    Integer.parseInt(params[3]));
            
            System.out.println("\n" + t.toString());
            t.imprimeTrabela(t.calculaTabela());
            
            line = br.readLine();            
        }
        
        
        
    }
    
    
    
    
}
