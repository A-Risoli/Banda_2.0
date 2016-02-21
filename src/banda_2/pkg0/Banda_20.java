/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banda_2.pkg0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Antonio
 */
public class Banda_20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame primapagina =new mainpage();
        primapagina.setVisible(true);
        
        try {
            // TODO code application logic here

            Cripto a = new Cripto("Pippo");
            byte[] x =a.encryptText("Ciao Come vafegegreg lì ?? ^ !3456&/wegffwje");
            System.out.println("Ciao Come va lì ?? ^ !3456&/wegffwje");
            System.out.println(a.decryptText(x));
            
        } catch (Exception ex) {
            Logger.getLogger(Banda_20.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
