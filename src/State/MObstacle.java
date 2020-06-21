package State;

import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import State.Level1;
 
public class MObstacle {
    int y=350;
    int WIDTH = 40;
    int HEIGHT = 40;
    int x = 0;
    int xa = 0;
    private MLevel1 m;
     
    public MObstacle (MLevel1 main) {
        this.m= main;
    }
     
    public MObstacle (MLevel1 main, int X, int Y) {
        this.m= main;
        y=Y;
        x=X;
    }
     
    public MObstacle (MLevel1 main, int X, int Y, int w,int h) {
        this.m= main;
        y=Y;
        x=X;
        WIDTH=w;
        HEIGHT= h;
    }
 
    public void move() {
        if (x + xa > 0 && x + xa < m.getWidth()-60)
            x = x + xa;
    }
 
    public void p(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
 
    public void keyReleased(KeyEvent e) {
        xa = 0;
     
    }
 
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_K)
            xa = 3;
        if (e.getKeyCode() == KeyEvent.VK_H)
            xa = -3;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
 
}