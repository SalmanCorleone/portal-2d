package layout;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import State.Level;
import State.Level1;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 500;
	int xa = 3;
	int ya = 3;
	private Level m;
	private int tempx=x;
	private int tempy=y;

	public Ball(Level main) {
		this.m= main;
	}

	public void move() {
		if (x + xa < 0)
			xa = -xa;
		if (x + xa > m.getWidth() - DIAMETER)
			xa = -xa;
		if (y + ya < 0)
			ya = -ya;
		if (y + ya > m.getHeight() - DIAMETER)
			ya=-ya;
		if (collision(xa,ya)){
			
			if(collision(xa,0))xa=-xa;
			if(collision(0,ya)) ya=-ya;
			
//			xa=-xa;
//			ya=-ya;


		}
		tempx=x+xa;
		tempy=y+ya;
		x=tempx;
		y=tempy;

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

	public void p(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(tempx, tempy, DIAMETER, DIAMETER);
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
}