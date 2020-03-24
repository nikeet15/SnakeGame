/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class Gameplay extends JPanel{
 
    private ImageIcon t;
    
    public Gameplay(){
        
    }
   
    @Override
    public void paint(Graphics g){
        
        //order of title image
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        //draw title image
        t = new ImageIcon("Icons\\snaketitle.jpg");
        t.paintIcon(this, g, 25, 11);

        //border of gameplay 
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);
        
        //backgroung of gameplay
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);
        
        
        
    }
    
}
 