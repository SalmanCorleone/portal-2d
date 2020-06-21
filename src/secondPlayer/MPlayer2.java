package secondPlayer;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import State.*;
 
public class MPlayer2 {
    double x = 40;
    double y = 500;
    double xa = 0;
    double ya = 0;
    double yChange=0;
    
    
    public double p1_x=0;
    public double p1_y=0;
    public double p2_x=0;
    public double p2_y=0;
    
    public boolean XChangeButtonPressed = false;
    
    int jump=-1;
    int degree;
    private MLevel1 m;
    private BufferedImage image;
    private BufferedImage left;
    private BufferedImage right;
	private int PaintFlag=0;

 
    public MPlayer2(MLevel1 main) {
        this.m= main;
        
        try {image=ImageIO.read(new File("./images/batman.png"));
		} catch (IOException e) {e.printStackTrace();}
        try {left=ImageIO.read(new File("./images/batLeft.png"));
      		} catch (IOException e) {e.printStackTrace();}
        try {right=ImageIO.read(new File("./images/batRight.png"));
  		} catch (IOException e) {e.printStackTrace();}



    }
    
    public void change(double a, double b,int option,int outPortalDir, int deg)
    {
    	System.out.println("\n   degree" +deg);
    	 degree=deg;
    	 
    	 System.out.println(x+ " "+ y+" "+ xa+" "+ ya);
    	
    	 while(degree!=0)
     	{
     		double tem1, tem2;
     		tem1= xa;
     		tem2=ya;
     		
     		ya=-tem1;
     		xa=tem2;
     		degree-=90;
     		
     		System.out.println(x+ " "+ y+" "+ xa+" "+ ya);
     	}
    	 
    	 System.out.println(x+ " "+ y+" "+ xa+" "+ ya);
    	 
//    	System.out.printf("%lf %lf %lf %lf\n", x,y,xa,ya);
    	 
//    	if(option==2|| option==3)
//    	{
//    		int temp=xa;
//    		xa=ya;
//    		ya=temp;
//    	}
        if(outPortalDir==11)
        {
        	x=a+30;
        	y=b+30;
        }
        else if(outPortalDir==12)
        {
        	x=a+30;
        	y=b-40;
        }
        if(outPortalDir==21)
        {
        	x=a+30;
        	y=b+30;
        }
        else if(outPortalDir==22)
        {
        	x=a-30;
        	y=b+15;
        }
        
        System.out.println(x+ " "+ y+" "+ xa+" "+ ya);
    }
 
    public void move() {
         
//        System.out.println("\n"+jump+" "+ ya);
             
        if(jump==1)
        {
            if(vert_collision(0, ya))
            {
                y-=2;
                while(!collision(0,-1))
                {
                    y-=1;
                }
                ya=0;
                jump=-1;
                y+=1.0;
                return;
            }
            if (vert_collision(0,0)){
                if(ya>0)y-=3;
                else if(ya<0)y+=3;
                if(xa>0)x-=3;
                else if(xa<0)x+=3;
                 
                jump=-1;
                 
                ya = xa=0.0;
                return;
            }
            if (y+ya>0  && !vert_collision(0,0) && ya<0) 
            {
            	y+=ya;
            	ya++;
            }
            else
            {
                jump=-1;
                ya=0.0;
            }
            //y+=ya;
            //System.out.println(y+ " "+ ya);
            
            while(degree!=0)
        	{
        		double tem1, tem2;
        		tem1= xa;
        		tem2=ya;
        		
        		ya=tem1;
        		xa=-tem2;
        		
        	}
             
        }
        else
        {
            fall();
        }
         
            if (horz_collision(0,0)){
                if(ya>0)y-=3.0;
                else if(ya<0)y+=3.0;
                if(xa>0)x-=3.0;
                else if(xa<0)x+=3.0;
                 
//                jump=0;
                 
                ya = xa=0.0;
            }
            else if (x + xa > 0.0 && x + xa < m.getWidth()-60.0)
            {
                //ya=5;
            	
            	if(jump==0)
            	{
            		if(!XChangeButtonPressed) xa=0;
            	}
            	if(!horz_collision(xa, 0))
                {
            		x+=xa;
                }
//                y+=ya;
            }
            else
            {
            	xa=0.0;
                //ya=0;
            }
             
             
         
    }
     
    public void fall()
    {
        if(vert_collision(0, 2.0)) 
        {
        	
//        	System.out.println("\n v");
            jump=0;
            ya=0.0;
            return;
        }
         
        
         
         
        if(( !vert_collision(0, ya) && !vert_collision(0, 2.0)) || m.port2.goForGrav(this, ya)!=0)
        {
        	
//        	System.out.println("\n ya "+ ya+ " " + y);
        	y+= ya;
        	if(ya<20) ya+=.10;
             
        }
        else
        {
            if(vert_collision(0, ya))
            {
                y-=ya;
                while(!vert_collision(0,2))
                {
                    y+=1.0;
                    if(m.port2.goForGrav(this, 0)!=0)
                    {
                    	return;
                    }
                }
                
                
                ya=0.0;
                jump=0;
                y-=1.0;
//                System.out.println("\n v");
                return;
            }

//        	System.out.println("\n v");
            y-= ya;
            ya=0.0;
            jump=0;
            //y-=1;
            //System.out.println(y);
        }
         
    }
   
    
    public void keyReleased() {
    	PaintFlag=0;
        xa = 0;
        ya=0;
        XChangeButtonPressed= false;
    }
 

    public void keyPressed() {
    	
//    	System.out.println("kan??  "+ e.getKeyCode());
        if (m.L2==1){
        	PaintFlag = 1;
            if(!collision())xa = -3;
            else
            {
                xa=0;
                x-=3;
                if(collision())
                {
                    x+=3;
                }
                else
                {
                    x+=3;
                    xa=-3;
                }
            }
            XChangeButtonPressed= true;
        }
        if (m.R2==1){
        	PaintFlag=2;
        	
        	if(!collision(3,0)) xa=3;
        	XChangeButtonPressed= true;
        }
        
        if (m.U2==1){
        	
        	
            if(jump==0)
            {
                jump=1;
                ya=-20;  
            }
             
        }
        if (m.D2==1){

        }
        if(m.U2==0 && m.D2==0 && m.L2==0 && m.R2==0) keyReleased();
         
    }
    private boolean collision() {
        return (m.roof.getBounds().intersects(getBounds()) || m.pillar.getBounds().intersects(getBounds()) || m.Ground.getBounds().intersects(getBounds())|| m.pillar2.getBounds().intersects(getBounds())|| m.pillar3.getBounds().intersects(getBounds()));
    }
    private boolean collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        if (m.roof.getBounds().intersects(getBounds()) || m.pillar.getBounds().intersects(getBounds())||m.Ground.getBounds().intersects(getBounds()) || m.pillar2.getBounds().intersects(getBounds()) || m.pillar3.getBounds().intersects(getBounds()))
        {
            x-=ax;
            y-=ay;
            return true;
        }
        x-=ax;
        y-=ay;
        return false;
         
    }
    
    private boolean vert_collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        if (m.roof.getBounds().intersects(getBounds()) || m.Ground.getBounds().intersects(getBounds()) || m.Ground2.getBounds().intersects(getBounds()))
        {
            x-=ax;
            y-=ay;
            return true;
        }
        x-=ax;
        y-=ay;
        return false;
         
    }

    private boolean horz_collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        if (m.pillar.getBounds().intersects(getBounds()) || m.pillar2.getBounds().intersects(getBounds()) || m.pillar3.getBounds().intersects(getBounds()))
        {
            x-=ax;
            y-=ay;
            return true;
        }
        x-=ax;
        y-=ay;
        return false;
         
    }
    
    private boolean floor_collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        if (m.Ground.getBounds().intersects(getBounds()) || m.Ground2.getBounds().intersects(getBounds()))
        {
            x-=ax;
            y-=ay;
            return true;
        }
        x-=ax;
        y-=ay;
        return false;
         
    }

    public void p(Graphics2D g) {

    	x= m.pos_x2;
    	y=m.pos_y2;
    	PaintFlag= m.pFlg2;
    	
    	if(PaintFlag==0) g.drawImage(image,(int)x, (int)y,null);
    	else if(PaintFlag==1)g.drawImage(left,(int)x, (int)y,null);
    	else if(PaintFlag==2)g.drawImage(right,(int)x,(int) y,null);
    }
     
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int) y, 30, 40);
    }
//    public Rectangle b_portal() {
//        return new Rectangle((int)m.BluePortal.x,(int) y, 30, 40);
//    }
//    public Rectangle o_portal() {
//        return new Rectangle((int)x,(int) y, 30, 40);
//    }
}