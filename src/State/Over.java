package State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Over extends JPanel{
	private BufferedImage img;
	public Over(){
		try {
			img= ImageIO.read(new File("./Box/Over.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(img, 0, 0, 1200, 700, null);
	}
	   
    public void keyPressed(KeyEvent e) 
    {
    	
    }
}
