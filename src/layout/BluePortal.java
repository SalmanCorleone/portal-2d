package layout;
 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class BluePortal {
    private BufferedImage blueHor;
    private BufferedImage blueVer;
    public double x=-1;
    public double y=-1;
    int portalDirection=0;
    int paintFlag=0;
     
    BluePortal()
    {
    	try
    	{
    		blueHor=ImageIO.read(new File("./Box/blueHor.png"));
    	}
    	catch(IOException e) {System.out.println("Portal blue load hoy nai");}
    	try {
			blueVer=ImageIO.read(new File("./Box/blueVer.png"));
		} catch (IOException e) {System.out.println("orangePortal load hoy nai");}
//        portal_x1 = x;
//        portal_y1 = y;
    }
    
    
   public void p(Graphics2D g) {
	   if(paintFlag==1){
	        if(hor())
	        {
	        	g.drawImage(blueHor,(int) x, (int)y, null);
	        }
	        if (Ver())
	        {
	        	g.drawImage(blueVer,(int) x,(int) y, null);
	        }
	   }
        
   }
     
    public void set(double X, double Y, int dir)
    {
            x = X;
            y = Y;
            portalDirection= dir;
            paintFlag=1;
    }
     
    public boolean hor()
    {
    	if(portalDirection==11||portalDirection==12) return true;
    	else return false;
    }
    public boolean Ver()
    {
    	if(portalDirection==21||portalDirection==22) return true;
    	else return false;
    }



 
}