package layout;
 

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import State.Level1;
 
public class Portal {
    private BluePortal blue;
    private OrangePortal orange;
//    Person p1= new Person();
    int options;
    
     
    public Portal()
    {
    	blue=new BluePortal();
    	orange= new OrangePortal();
    }
     
    public void set(double x, double y, int clrflag, int dir)
    {
        if(clrflag==1)
        {
        	
            blue.set(x, y,dir);
        }
        else if(clrflag==2)
        {
            orange.set(x, y, dir);
        }
        
        if(blue.hor() &&orange.hor() || blue.Ver()&& orange.Ver())
        {
        	options=1;
        }
        if(blue.hor() && orange.Ver())
        {
        	options=2;
        }
        if(blue.Ver() && orange.hor())
        {
        	options=3;
        }

    }
    
    
     
    public int go(Person b)
    {
 
    	int acc=0;
        if(b.getBounds().intersects(getBoundBlue()))
        {
        	if(blue.portalDirection== 11)
        	{
        		if(orange.portalDirection== 11) acc=180;
        		else if(orange.portalDirection== 21) acc=270;
        		else if(orange.portalDirection== 22) acc=90;
        	}
        	else if(blue.portalDirection== 12)
        	{
        		if(orange.portalDirection== 12) acc=180;
        		else if(orange.portalDirection== 21) acc=90;
        		else if(orange.portalDirection== 22) acc=270;
        	}
        	if(blue.portalDirection== 21)
        	{
        		if(orange.portalDirection== 11) acc=90;
        		else if(orange.portalDirection== 21) acc=180;
        		else if(orange.portalDirection== 12) acc=270;
        	}
        	if(blue.portalDirection== 22)
        	{
        		if(orange.portalDirection== 11) acc=270;
        		else if(orange.portalDirection== 12) acc=90;
        		else if(orange.portalDirection== 22) acc=180;
        	}
        	System.out.println("Hit the Blue");
            b.change(orange.x, orange.y,options,orange.portalDirection, acc);
            return 2;
        }
        else if(b.getBounds().intersects(getBoundOrange()))
        {
        	if(orange.portalDirection== 11)
        	{
        		if(blue.portalDirection== 11) acc=180;
        		else if(blue.portalDirection== 21) acc=270;
        		else if(blue.portalDirection== 22) acc=90;
        	}
        	else if(orange.portalDirection== 12)
        	{
        		if(blue.portalDirection== 12) acc=180;
        		else if(blue.portalDirection== 21) acc=90;
        		else if(blue.portalDirection== 22) acc=270;
        	}
        	if(orange.portalDirection== 21)
        	{
        		if(blue.portalDirection== 11) acc=90;
        		else if(blue.portalDirection== 21) acc=180;
        		else if(blue.portalDirection== 12) acc=270;
        	}
        	if(orange.portalDirection== 22)
        	{
        		if(blue.portalDirection== 11) acc=270;
        		else if(blue.portalDirection== 12) acc=90;
        		else if(blue.portalDirection== 22) acc=180;
        	}
        	System.out.println("hit the Orange");
            b.change(blue.x, blue.y,options,blue.portalDirection, acc);
            return 1;
        }
        return 0;
    }
     
    
    public int goForGrav(Person b, double ya)
    {
 
    	b.y+=ya;
        if(b.getBounds().intersects(getBoundBlue()))
        {
        	b.y-=ya;
            return 2;
        }
        else if(b.getBounds().intersects(getBoundOrange()))
        {
        	b.y-=ya;
            return 1;
        }
        b.y-=ya;
        return 0;
    }
     
    public void paint(Graphics2D g) {
    	blue.p(g);
    	orange.p(g);
         
    }
     
    public Rectangle getBoundBlue()
    {
    	if(blue.Ver())  return new Rectangle((int)blue.x, (int)blue.y, 15, 80);
    	else return  new Rectangle((int)blue.x,(int) blue.y, 80, 15);
    }
    public Rectangle getBoundOrange()
    {
    	if(orange.Ver())  return new Rectangle((int)orange.x,(int) orange.y, 15, 80);
    	else return  new Rectangle((int)orange.x, (int)orange.y, 80, 15);
    }
 
}