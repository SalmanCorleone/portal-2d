package State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import portal2D.MainPortal2D;

public class Pause extends JPanel{
	private BufferedImage bg;
	public Level last_on_Frame;
	
	public Pause()
	{
		try {
			bg=ImageIO.read(new File("./bg/Pause.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				new Thread(new Runnable(){
				public void run() {
					MainPortal2D.frame.remove(MainPortal2D.pause);
					MainPortal2D.frame.add(MainPortal2D.menu);
					
					MainPortal2D.state=0;
					MainPortal2D.menu.setFocusable(true);
					MainPortal2D.menu.requestFocusInWindow();
					MainPortal2D.menu.repaint();
					MainPortal2D.menu.revalidate();
						
					}
					
				}).start();

				
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});


	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg,0,0,1200,700,null);
		
	}

}
