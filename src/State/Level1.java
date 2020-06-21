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
 



import javax.swing.JPanel;

import layout.Ball;
import layout.Obstacle;
import layout.Person;
import layout.Portal;
import layout.PortalBall;
import portal2D.MainPortal2D;
   

public class Level1{
    public BufferedImage background;
    private BufferedImage image;
    public Obstacle roof= new Obstacle (0,0,1200,200);
    public Obstacle pillar= new Obstacle ( 500, 350,200,300);
    public Obstacle pillar2= new Obstacle ( 0, 200,20,450);
    public Obstacle pillar3= new Obstacle ( 1180, 200,20,450);
    public Obstacle Ground=new Obstacle(0,650,1200,100);
    public Obstacle Ground2=new Obstacle(500,350,200,3);
    
//    public Level l= new Level("./Box/Stage1.jpg");
//    public Ball ball= new Ball(this);
//    public Person batman= new Person(l);
//    public Portal port= new Portal();
//    public PortalBall gun= new PortalBall(batman,this);
      
      
       
    public Level1(Level lvl) {
    	
    	lvl.Ver_insrt(pillar);
    	lvl.Ver_insrt(pillar2);
    	lvl.Ver_insrt(pillar3);
        
    	lvl.Hor_insrt(Ground);
    	lvl.Hor_insrt(Ground2);
    	lvl.Hor_insrt(roof);
    }
         
   
}