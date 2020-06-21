package State;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import portal2D.MainPortal2D;

public class Credit extends JPanel{
	private BufferedImage bg;
	
	public Credit()
	{
		try {
			bg=ImageIO.read(new File("./bg/Credit.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				super.mousePressed(arg0);
				MainPortal2D.frame.remove(MainPortal2D.credit);
				MainPortal2D.frame.add(MainPortal2D.menu);
				
				MainPortal2D.state=0;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.menu.setFocusable(true);
				MainPortal2D.menu.requestFocusInWindow();
				MainPortal2D.menu.repaint();
				MainPortal2D.frame.revalidate();
				
			}
		});

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg,0,0,1200,700,null);
		
	}

}
