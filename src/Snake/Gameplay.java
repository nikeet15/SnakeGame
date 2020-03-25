/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
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
    private ImageIcon enemyimage;
    
    private int[] snakeXlength= new int[750];   //at 0th index head of snake
    private int[] snakeYlength= new int[750];
    private int len= 3;
    
    private boolean left= false;
    private boolean right= false;
    private boolean up= false;
    private boolean down= false;
    
    private int enemyx[]= new int[50];
    private int enemyy[]= new int[50];
    private Random r;
    private int xpos,ypos;    
    
    private Timer timer;
    private int delay= 120;
    private int mov=0;
    private int score= 0;
    
    public Gameplay(){
        
        r= new Random();
        xpos= r.nextInt(34);
        ypos= r.nextInt(23);
        
        for (int i = 0; i < 34; i++) {
            enemyx[i]= 25*i+25;    
        }
        
        for (int i = 0; i < 23; i++) {
            enemyy[i]= 25*i+75;
        }
        
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
        
        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Score: "+score, 780, 30);
        
        //draw length
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: "+len, 780, 50);
        
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
        
        // if snake eats the food/enemy-----
        if(enemyx[xpos] == snakeXlength[0] && enemyy[ypos] == snakeYlength[0])
        {
            score++;
            len++;
            System.out.println(timer.getDelay());
            delay-=3;
            timer.setDelay(delay);
            //timer.restart();
            
            xpos= r.nextInt(34);
            ypos= r.nextInt(23);
        }
        
        enemyimage= new ImageIcon("Icons\\enemy.png");
        enemyimage.paintIcon(this, g, enemyx[xpos], enemyy[ypos]);
        
        //check collision
        for (int i = 1; i < len; i++) {
            
            if(snakeXlength[i]==snakeXlength[0] && snakeYlength[i]==snakeYlength[0])
            {
                right=left=up=down= false;
                //draw game over
                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("GAME OVER", 300, 300);
                
                //draw restart
                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("SPACE for restart", 350, 350);
                
                break;
            }
        }
        
        //repaint();
        g.dispose(); 
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            //reset
            
            mov= 0;
            score= 0;
            len= 3;
            repaint();
        }
        
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            mov++;
//            System.out.println(mov);
            right= true;
            if(!left)                  // added this part to avoid collision of snake to its body like
            {                          // if moving towards right cannot move left as it collide with itself hence ignore that keypress
                right= true;
            }
            
            else
            {
                right= false;
                left= true;
            }
            
            up= false;
            down= false;
        }
        
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            mov++;
            left= true;
            if(!right)
            {
                left= true;
            }
            
            else
            {
                left= false;
                right= true;
            }
            
            up= false;
            down= false;
        }
        
        else if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            mov++;
            up= true;
            
            if(!down)
            {
                up= true;
            }
            
            else
            {
                up= false;
                down= true;
            }
            
            left= false;
            right= false;
        }
        
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            mov++;
            down= true;
            if(!up)
            {
                down= true;
            }
            
            else
            {
                down= false;
                up= true;
            }
            
            left= false;
            right= false;
        }       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //called when timer starts
        
        timer.start();
        if(right)
        {
            for (int i = len; i > 0; i--) {
                
                snakeYlength[i]= snakeYlength[i-1];
            }
            
            for (int i = len; i >= 0; i--) {
             
                if(i==0)
                    snakeXlength[i]= snakeXlength[i]+25;
                
                else
                    snakeXlength[i]= snakeXlength[i-1];
                
                if(snakeXlength[i]>850)
                    snakeXlength[i]= 25;
            }
            
        }
        
        else if(left)
        {
            for (int i = len; i > 0; i--) {
                
                snakeYlength[i]= snakeYlength[i-1];
            }
            
            for (int i = len; i >= 0; i--) {
             
                if(i==0)
                    snakeXlength[i]= snakeXlength[i]-25;
                
                else
                    snakeXlength[i]= snakeXlength[i-1];
                
                if(snakeXlength[i]<25)
                    snakeXlength[i]= 850;
            }
            
        }
        
        else if(up)
        {
            for (int i = len; i > 0; i--) {
                
                snakeXlength[i]= snakeXlength[i-1];
            }
            
            for (int i = len; i >= 0; i--) {
             
                if(i==0)
                    snakeYlength[i]= snakeYlength[i]-25;
                
                else
                    snakeYlength[i]= snakeYlength[i-1];
                
                if(snakeYlength[i]<75)
                    snakeYlength[i]= 625;
            }
            
        }
        
        else if(down)
        {
            for (int i = len; i > 0; i--) {
                
                snakeXlength[i]= snakeXlength[i-1];
            }
            
            for (int i = len; i >= 0; i--) {
             
                if(i==0)
                    snakeYlength[i]= snakeYlength[i]+25;
                
                else
                    snakeYlength[i]= snakeYlength[i-1];
                
                if(snakeYlength[i]>625)
                    snakeYlength[i]= 75;
            }
        }
        
        repaint();
    }
    
}
 