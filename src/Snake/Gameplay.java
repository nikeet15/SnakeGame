/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author acer
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
 
    private ImageIcon t;
    private ImageIcon leftmouth;
    private ImageIcon rightmouth; 
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage;
    
    private int[] snakeXlength= new int[750];   //at 0th index head of snake
    private int[] snakeYlength= new int[750];
    private int len= 3;
    
    private boolean left= false;
    private boolean right= false;
    private boolean up= false;
    private boolean down= false;
    
    private Timer timer;
    private int delay= 100;
    private int mov=0;
    
    public Gameplay(){
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay, this);
        timer.start();
        
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
        
        //initialization of snake................
        
        //at start putting snake at left corner
        if(mov==0)
        {
            snakeXlength[2]= 50;
            snakeXlength[1]= 75;
            snakeXlength[0]= 100;
            
            snakeYlength[2]= 100;
            snakeYlength[1]= 100;
            snakeYlength[0]= 100;
        }
        
        rightmouth= new ImageIcon("Icons\\rightmouth.png");
        rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        
        for (int i = 0; i < len; i++) {
            if(i==0)
            {
                if(right)
                {   rightmouth= new ImageIcon("Icons\\rightmouth.png");
                    rightmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
                }
            
                if(left)
                {
                    leftmouth= new ImageIcon("Icons\\leftmouth.png");
                    leftmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
                }
            
                if(up)
                {   
                    upmouth= new ImageIcon("Icons\\upmouth.png");
                    upmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
                }
            
                if(down)
                {
                    downmouth= new ImageIcon("Icons\\downmouth.png");
                    downmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
                }
            }
            
            else if(i!=0)
            {   
                snakeimage= new ImageIcon("Icons\\snakeimage.png");
                snakeimage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            
            
            
        }
        
        
        
        g.dispose();
        
        
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
 