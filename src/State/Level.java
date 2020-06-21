package State;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;



import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;

import javax.swing.JPanel;

import layout.Ball;
import layout.Obstacle;
import layout.Person;
import layout.Portal;
import layout.PortalBall;
import portal2D.MainPortal2D;
   

public class Level extends JPanel{
    public BufferedImage background;
    private BufferedImage image;
    
    public static ArrayList <Obstacle> danger=new ArrayList<Obstacle>();

    public static ArrayList <Obstacle> Obs= new ArrayList<Obstacle>();

    public static ArrayList <Obstacle> ObsVer= new ArrayList<Obstacle>();

    public static ArrayList <Obstacle> ObsHor= new ArrayList<Obstacle>();

    public static ArrayList <Obstacle> ObsFloor= new ArrayList<Obstacle>();

    public Ball ball= new Ball(this);
    public Person batman= new Person(this);
    public Portal port= new Portal();
    public PortalBall gun= new PortalBall(batman,this);
      
      
       
    public Level(String img) {
    	
    	Obs.clear();
    	ObsHor.clear();
    	ObsVer.clear();
        try {                
            background = ImageIO.read(new File(img));
         } catch (IOException ex){
              // handle exception...
         }
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
   
               
            public void keyReleased(KeyEvent e) {
//                pillar.keyReleased(e);
                batman.keyReleased(e);
            }
   
               
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            	{
            		MainPortal2D.frame.remove(MainPortal2D.level1);
        			MainPortal2D.frame.add(MainPortal2D.menu);
        			
//        			Thread.sleep(2000);
        			MainPortal2D.state=0;
        			MainPortal2D.menu.setFocusable(true);
        			MainPortal2D.menu.requestFocusInWindow();
        			MainPortal2D.menu.repaint();
        			MainPortal2D.menu.revalidate();
            	}
            	
            	if(e.getKeyCode()==KeyEvent.VK_P)
            	{
            		
            		MainPortal2D.frame.add(MainPortal2D.pause);
        			
        			MainPortal2D.state=100;
        			MainPortal2D.pause.setFocusable(true);
        			MainPortal2D.pause.requestFocusInWindow();
        			MainPortal2D.pause.repaint();
        			MainPortal2D.pause.revalidate();
            		
            	}
//                pillar.keyPressed(e);
                batman.keyPressed(e);
            }
        });
         
        addMouseListener(new MouseAdapter() {
             
            public void mousePressed(MouseEvent e)
            {

                 gun.go(e.getX(),e.getY(),e);
                
                
            }
            public void mouseReleased(MouseEvent e)
            {
                 
            }
        });
        setFocusable(true);
          
    }
    
    public void Ver_insrt(Obstacle ob)
    {
    	ObsVer.add(ob);
    	Obs.add(ob);
    }
    public void Hor_insrt(Obstacle ob)
    {
    	ObsHor.add(ob);
    	Obs.add(ob);
    }
    
       
    public void move() throws InterruptedException {
        ball.move();
//        pillar.move();
        batman.move();
        gun.move();
        port.go(batman);
        
        switch(MainPortal2D.state)
        {
        case 1:
        	
	        if(batman.x>1080 && batman.x<1155 && batman.y>600 && batman.y<630)
	        {
	        	MainPortal2D.level2=new Level(MainPortal2D.img2);
	        	Level2 l2= new Level2(MainPortal2D.level2);
	        	MainPortal2D.frame.remove(MainPortal2D.level1);
				MainPortal2D.frame.add(MainPortal2D.level2);
				
	//			Thread.sleep(2000);
				MainPortal2D.state=2;
				MainPortal2D.level2.setFocusable(true);
				MainPortal2D.level2.requestFocusInWindow();
				MainPortal2D.level2.repaint();
				MainPortal2D.level2.revalidate();
	        }
	        break;
	        
        case 2:
        	if(batman.x>1080 && batman.x<1180 && batman.y>300 && batman.y<390)
	        {
	        	MainPortal2D.frame.remove(MainPortal2D.level2);
				MainPortal2D.frame.add(MainPortal2D.menu);
				
	//			Thread.sleep(2000);
				MainPortal2D.state=0;
				MainPortal2D.menu.setFocusable(true);
				MainPortal2D.menu.requestFocusInWindow();
				MainPortal2D.menu.repaint();
				MainPortal2D.menu.revalidate();
	        }
	        break;
        }
        
        
    }
    
 
   

    public void paint(Graphics g) {
//        super.paint(g);
         
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
           
  
//        switch(MainPortal2D.state)
//        {
//        case 1:
//            g2d.drawImage(background,0,0,1200,700,null);
//            break;
//        case 2:
//        	g2d.drawImage(background, 0, 0, 1200, 700, null);
//        }

        g2d.drawImage(background, 0, 0, 1200, 700, null);
//        ball.p(g2d);
         
        batman.p(g2d);
        gun.p(g2d);
        port.paint(g2d);
        
        for(int i=0; i<Obs.size();i++){
//    	    Obs.get(i).p(g2d);
    	}
    }
   
       
   
}