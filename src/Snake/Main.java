/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Gameplay g= new Gameplay();
        JFrame f= new JFrame();
        f.setBounds(10,10,905,700);
        f.setBackground(Color.DARK_GRAY);
        f.setResizable(false);
        f.setTitle("Snake Game");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        f.add(g);
    }
    
}
