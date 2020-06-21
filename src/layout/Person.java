package layout;
 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import State.Level;
import State.Level1;
 
public class Person {
    public double x = 40;
    public double y = 500;
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
    private Level m;
    private BufferedImage image;
    private BufferedImage left;
    private BufferedImage right;
	private int PaintFlag=0;

 
    public Person(Level main) {
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
    	 
    	if(ya<0.0) 
    	{
    		System.out.println("deg "+deg);
    		if(deg!=0) jump=2;
    		else jump=1;
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
         
        System.out.println("\njump "+jump+" "+y+" "+ ya);
             
        if(jump==2)
        {
            if(vert_collision(0, ya))
            {
//                y-=2;
                while(!collision(0,-1))
                {
                    y-=1;
                }
                ya=0;
                jump=-1;
                y+=1.0;
                System.out.println("j "+jump);
                return;
            }
            if (vert_collision(0,0)){
                if(ya>0)y-=3;
                else if(ya<0)y+=3;
                if(xa>0)x-=3;
                else if(xa<0)x+=3;
                 
                jump=-1;
                System.out.println("j "+jump);
                 
                ya = xa=0.0;
                return;
            }
            if (y+ya>0  && !vert_collision(0,0) && ya<0) 
            {
            	y+=ya;
            	ya+=0.1;
            	System.out.println("barse");
            }
            else
            {
                jump=-1;
                ya=0.0;

                System.out.println("j "+jump);
                return;
            }
             
        }
        
        if(jump==1)
        {
            if(vert_collision(0, ya))
            {
//                y-=2;
                while(!collision(0,-1))
                {
                    y-=1;
                }
                ya=0;
                jump=-1;
                y+=1.0;
                System.out.println("j "+jump);
                return;
            }
            if (vert_collision(0,0)){
                if(ya>0)y-=3;
                else if(ya<0)y+=3;
                if(xa>0)x-=3;
                else if(xa<0)x+=3;
                 
                jump=-1;
                System.out.println("j "+jump);
                 
                ya = xa=0.0;
                return;
            }
            if (y+ya>0  && !vert_collision(0,0) && ya<0) 
            {
            	y+=ya;
            	ya+=1.0;
            	System.out.println("barse");
            }
            else
            {
                jump=-1;
                ya=0.0;

                System.out.println("j "+jump);
                return;
            }
            //y+=ya;
            //System.out.println(y+ " "+ ya);
            
//            while(degree!=0)
//        	{
//        		double tem1, tem2;
//        		tem1= xa;
//        		tem2=ya;
//        		
//        		ya=tem1;
//        		xa=-tem2;
//        		
//        	}
             
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
         
        
         
         
        if(( !vert_collision(0, ya) && !vert_collision(0, 2.0)) || m.port.goForGrav(this, ya)!=0)
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
                    if(m.port.goForGrav(this, 0)!=0)
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
   
    
    public void keyReleased(KeyEvent e) {
    	PaintFlag=0;
        xa = 0;
//        ya=0;
        XChangeButtonPressed= false;
    }
 

    public void keyPressed(KeyEvent e) {
    	
//    	System.out.println("kan??  "+ e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A){
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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D){
        	PaintFlag=2;
        	
        	if(!collision(3,0)) xa=3;
        	XChangeButtonPressed= true;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W){
        	
        	
            if(jump==0)
            {
                jump=1;
                ya=-20;  
            }
             
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S){

        }
         
    }
    private boolean collision() {
    	for(int i=0; i<m.Obs.size();i++){
    	    if (m.Obs.get(i).getBounds().intersects(getBounds()))
    	    {

//    	    	System.out.println("collision hoise");
    	        return true;
    	    }
    	}
    	return false;
    }
    private boolean collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        for(int i=0; i<m.Obs.size();i++){
    	    if (m.Obs.get(i).getBounds().intersects(getBounds()))
    	    {
                x-=ax;
                y-=ay;
    	        return true;
    	    }
    	}
        x-=ax;
        y-=ay;
    	return false;
         
    }
    
    private boolean vert_collision(double ax, double ay) {
        x+=ax;
        y+=ay;
        for(int i=0; i<m.ObsHor.size();i++)
        {
	        if (m.ObsHor.get(i).getBounds().intersects(getBounds()))
	        {
	            x-=ax;
	            y-=ay;
	            return true;
	        }
        
        }
        x-=ax;
        y-=ay;
        return false;
    }

    private boolean horz_collision(double ax, double ay) {
    	x+=ax;
        y+=ay;
        for(int i=0; i<m.ObsVer.size();i++)
        {
	        if (m.ObsVer.get(i).getBounds().intersects(getBounds()))
	        {
	            x-=ax;
	            y-=ay;
	            return true;
	        }
        
        }
        x-=ax;
        y-=ay;
        return false;
         
    }

    public void p(Graphics2D g) {
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