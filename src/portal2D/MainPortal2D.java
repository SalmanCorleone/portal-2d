package portal2D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import network.Client;
import State.*;


public class MainPortal2D {
	public static int state=-1;
//    public static Level1 level1= new Level1();
    public static Menu menu= new Menu();
    public static Host host= new Host();
    public static Join join;
    public static Client client= new Client();
//    public static JPanel menu= new N();
    
    public static MLevel1 mlevel1;
    public static JFrame frame;
	public static Credit credit= new Credit();
	public static Pause pause= new Pause();
	public static Welcome wc= new Welcome();
	public static Connect connect=new Connect(); 
	
	public static int network_state;
	
	public static String img1= "./bg/Stage1.jpg";
	public static String img2= "./bg/Lvl2.jpg";
	public static String img3= "./bg/Lvl3.jpg";  
	public static String img4= "./bg/Lvl4.jpg";  
	public static String img5= "./bg/Lvl5.jpg";  
	public static String img6= "./bg/Lvl6.jpg";  
	
	public static Level level1;
	public static Level level2;
	public static Level level3;
	public static Level level4;
	public static Level level5;
	public static Level level6;
	
	
//	public static Level1 l1= new Level1(level1);

//	public static Level2 l2= new Level2(level2);
//	public static Sound sound= new Sound();
    public static void main(String[] args) {
    	
        
//        Level2 level2= new Level2();
        Over gameOver=new Over();
        
//        Sound.xo.setLoopCount(5);
        
        frame = new JFrame("PORTAL Step 1");
        frame.add(wc);
//        menu.setFocusable(true);
//        menu.start.setFocusable(true);
//        menu.start.requestFocusInWindow();
//        menu.repaint();
        frame.setSize(1200, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        while (true) {
            System.out.print(state);
        	state= state;
        	if(state==-1)
        	{
        		
				wc.repaint();
        	}
        	if(state==0)
        	{
        		menu.setFocusable(true);
        		frame.requestFocusInWindow();
        		menu.revalidate();
        	}
        	if(state==1)
        	{

        		level1.repaint();
        		try {
					level1.move();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
        		
        	}
        	else if(state==2)
        	{
        		level2.repaint();
        		try {
					level2.move();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//        		level1.setFocusable(true);
//        		level1.requestFocusInWindow();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        	}
        	else if(state==9)
        	{
        		
        	}
        	else if(state==10)
        	{
        		credit.repaint();

        	}
        	else if(state==11)
        	{
        		connect.repaint();
        		
        		mlevel1= new MLevel1(network_state, client);
				
				frame.remove(MainPortal2D.connect);
				frame.add(mlevel1);
				
				MainPortal2D.state=12;
//				System.out.println(MainPortal2D.state);
				mlevel1.setFocusable(true);
				mlevel1.requestFocusInWindow();
				mlevel1.repaint();
				mlevel1.revalidate();
        	}
        	else if(state==12)
        	{

        		if(network_state==1) mlevel1.serverCommunication();
        		if(network_state==2) mlevel1.clientCommunication();
        		mlevel1.move();
        		mlevel1.repaint();
        		
        		try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        	}
        	else if(state==100)
        	{
        		pause.repaint();
        	}
            
            
            

        }
    }
       

}
