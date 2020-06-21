package State;

import network.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import firstPlayer.*;
import secondPlayer.*;
import sun.misc.Cleaner;

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
   

public class MLevel1 extends JPanel{
    public BufferedImage background;
    private BufferedImage image;
    public MObstacle roof= new MObstacle (this,0,0,1200,200);
    public MObstacle pillar= new MObstacle (this, 500, 350,200,300);
    public MObstacle pillar2= new MObstacle (this, 0, 200,20,400);
    public MObstacle pillar3= new MObstacle (this, 1180, 200,20,400);
    public MObstacle Ground=new MObstacle(this,0,650,1200,100);
    public MObstacle Ground2=new MObstacle(this,500,350,200,3);

//    public Ball ball= new Ball(this);
    public MPlayer1 batman= new MPlayer1(this);
    public Portal1 port= new Portal1();
    public PortalBall1 gun= new PortalBall1(batman,this);
    

    public MPlayer2 catman= new MPlayer2(this);
    public Portal2 port2= new Portal2();
    public PortalBall2 gun2= new PortalBall2(catman,this);
    
    public int U=0, D=0, L=0, R=0;
    public int U2=0, R2=0, L2=0, D2=0;
    public String msg="1000 500 0 0 -1 -1";
    public String getMsg= "00000000000000000000000000000000";
    public Client client= new Client();
    public Server server= new Server();
    
    public int mouse=0;
    public int mouse_x=-1, mouse_y=-1;
    public int mouse2=0;
    public int mouse_x2=-1, mouse_y2=-1;
    public int pos_x=1000, pos_y=500,pFlg=0;
    public int pos_x2=40, pos_y2=500,pFlg2=0;
      
      
       
    public MLevel1(int x, Client cl) {
    	
    	System.out.println(x);
    	
    	client= cl;
    	
    	if(x==2) client.startRunning();
    	if(x==1) server.startRunning();
        try {                
            background = ImageIO.read(new File("./Box/Stage1.jpg"));
         } catch (IOException ex){
              // handle exception...
         }
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
   
               
            public void keyReleased(KeyEvent e) {
                pillar.keyReleased(e);
                batman.keyReleased(e);
//                catman.keyReleased(e);
            }
   
               
            public void keyPressed(KeyEvent e) {
                pillar.keyPressed(e);
                batman.keyPressed(e);
//                catman.keyPressed(e);
            }
        });
         
        addMouseListener(new MouseAdapter() {
             
            public void mousePressed(MouseEvent e)
            {
                //mouse.pressed(e);
//                int z;
//                 
//                if(e.getButton()== MouseEvent.BUTTON1) z=1;
//                else z=2;
//                p.set(e.getX(), e.getY(),z);
                 gun.go(e.getX(),e.getY(),e);
                 if(e.getButton()== MouseEvent.BUTTON1) mouse=1;
                 if(e.getButton()== MouseEvent.BUTTON3) mouse=2;
                 
                 mouse_x= e.getX();
                 mouse_y= e.getY();
                
            }
            public void mouseReleased(MouseEvent e)
            {
                 
            }
        });
        setFocusable(true);
          
    }
       
    public void move() {
//        ball.move();
        pillar.move();
        batman.move();
        
//        msg="000";
        
//        if(L==1) msg= msg.substring(0, 1) +'1'+ msg.substring(2,3);
//        if(U==1) msg= '1'+msg.substring(1, 3);
//        if(R==1) msg= msg.substring(0, 2)+'1';
        
        msg= Integer.toString(pos_x);
        msg= msg.substring(0) + ' ';
        
        msg= msg.substring(0) + Integer.toString(pos_y);
        msg= msg.substring(0) + ' ';

        msg= msg.substring(0) + Integer.toString(pFlg);
        msg= msg.substring(0) + ' ';
        
        msg= msg.substring(0) + Integer.toString(mouse);
        msg= msg.substring(0) + ' ';
        
        msg= msg.substring(0) + Integer.toString(mouse_x);
        msg= msg.substring(0) + ' ';
        msg= msg.substring(0) + Integer.toString(mouse_y);
        
        mouse=0;
        mouse_x=-1;
        mouse_y=-1;
//        
//        client.sendMessage(U);
//        client.sendMessage(L);
//        client.sendMessage(R);
        
//        System.out.println("\n U "+U+ " L "+L+ " R "+R);
//        server.sendMessage(Integer.toString(U));
//        server.sendMessage(Integer.toString(L));
//        server.sendMessage(Integer.toString(R));
        
//        server.sendMessage(msg);
        
//        client.sendMessage(msg);
        
//        System.out.println(msg);
//        
        gun.move();
        port.go(batman);
        
//        try {
//			U2= (int)client.input.readInt();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			L2= (int)client.input.readInt();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			R2= (int)client.input.readInt();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        try {
//        	
//			getMsg= (String) server.input.readObject();
////        	getMsg= (String) client.input.readObject();
//		} catch (ClassNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        System.out.println(getMsg);
        int i=0, j;
        
        for(; i<getMsg.length(); i++)
        {
        	if(getMsg.charAt(i)==' ')
        	{
        		break;
        	}
        }
        
        pos_x2= Integer.parseInt(getMsg.substring(0,i));
        
        j=++i;
        
        for(; i<getMsg.length(); i++)
        {
        	if(getMsg.charAt(i)==' ')
        	{
        		break;
        	}
        }
        
        pos_y2= Integer.parseInt(getMsg.substring(j,i));
        
        j=++i;
        
        for(; i<getMsg.length(); i++)
        {
        	if(getMsg.charAt(i)==' ')
        	{
        		break;
        	}
        }
        
        pFlg2= Integer.parseInt(getMsg.substring(j,i));
        
        j=++i;
        
        for(; i<getMsg.length(); i++)
        {
        	if(getMsg.charAt(i)==' ')
        	{
        		break;
        	}
        }
        
        mouse2= Integer.parseInt(getMsg.substring(j,i));
        
        j=++i;
        
        for(; i<getMsg.length(); i++)
        {
        	if(getMsg.charAt(i)==' ')
        	{
        		break;
        	}
        }
        
        mouse_x2= Integer.parseInt(getMsg.substring(j,i));
        mouse_y2= Integer.parseInt(getMsg.substring(i+1));
        
        if(mouse2!=0 && mouse_x2!=-1 && mouse_y2!= -1)
        {
        	gun2.go(mouse_x2, mouse_y2, mouse2);
        }
        
//        
//        
//        System.out.println("\n U2 "+U2+ " L2 "+L2+ " R2 "+R2);
        
        catman.keyPressed();
        catman.move();
        gun2.move();
        port2.go(catman);
        
    }
   
    public void serverCommunication()
    {
    	server.sendMessage(msg);
        
        try {
        	
			getMsg= (String) server.input.readObject();
			
//			try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void clientCommunication()
    {
    	client.sendMessage(msg);
        
        try {
        	
			getMsg= (String) client.input.readObject();
			
//			try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //Override
    public void paint(Graphics g) {
        super.paint(g);
         
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
           
  
//        g2d.drawImage(image, 0, 0, null);
        g2d.drawImage(background,0,0,1200,700,null);
//        ball.p(g2d);
         
//        roof.p(g2d);
//        pillar.p(g2d);
        batman.p(g2d);
        gun.p(g2d);
        port.paint(g2d);
        

        catman.p(g2d);
        gun2.p(g2d);
        port2.paint(g2d);
    }
}