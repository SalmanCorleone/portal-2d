package State;
//import Sound;
import portal2D.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;













import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import portal2D.MainPortal2D;

public class Menu extends JPanel{
	private BufferedImage img;
	public JButton start=new JButton("Single Player");
	public JButton load= new JButton("Load Game");
	public JButton exit= new JButton("Quit To Desktop");
	public JButton credit= new JButton("Credits");
	public JButton multi= new JButton ("MultiPlayer");
//	Box box= Box.createHorizontalBox();

	public Menu(){	
		try {
			img= ImageIO.read(new File("./Box/Menu.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(new Runnable()
				{

					public void run() {
//						SoundClass.BACK.loop();
			        	MainPortal2D.level1=new Level(MainPortal2D.img1);
			        	Level1 l1= new Level1(MainPortal2D.level1);
			        	MainPortal2D.frame.remove(MainPortal2D.menu);
						MainPortal2D.frame.add(MainPortal2D.level1);
						
			//			Thread.sleep(2000);
						MainPortal2D.state=1;
						MainPortal2D.level1.setFocusable(true);
						MainPortal2D.level1.requestFocusInWindow();
						MainPortal2D.level1.repaint();
						MainPortal2D.level1.revalidate();
						
					}
					
					
				}).start();
				
			}
		});
		setLayout(null);
		
		start.setBounds(400, 250,360 , 50);
		start.setVisible(true);
		start.setFocusable(true);
		start.requestFocusInWindow();
		add(start);
		setFocusable(true);
		repaint();
		
		multi.setBounds(400,310,360 , 50);
		multi.setVisible(true);
		multi.setFocusable(true);
		multi.requestFocusInWindow();
		add(multi);
		setFocusable(true);
		repaint();
		multi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				MainPortal2D.frame.remove(MainPortal2D.menu);
				MainPortal2D.frame.add(MainPortal2D.host);
				
//				MainPortal2D.state=11;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.host.setFocusable(true);
				MainPortal2D.host.requestFocusInWindow();
				MainPortal2D.host.repaint();
				MainPortal2D.host.revalidate();
				
				System.out.println("connect");
				
				
			}
		});
		

		load.setBounds(400, 370,360 , 50);
		load.setVisible(true);
		load.setFocusable(true);
		load.requestFocusInWindow();
		add(load);
		setFocusable(true);
		repaint();
		
		exit.setBounds(400,500,360 , 50);
		exit.setVisible(true);
		exit.setFocusable(true);
		load.requestFocusInWindow();
		add(exit);
		setFocusable(true);
		repaint();
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		
		credit.setBounds(400, 430,360 , 50);
		credit.setVisible(true);
		credit.setFocusable(true);
		load.requestFocusInWindow();
		add(credit);
		setFocusable(true);
		repaint();
		credit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				MainPortal2D.frame.remove(MainPortal2D.menu);
				MainPortal2D.frame.add(MainPortal2D.credit);
				
				MainPortal2D.state=10;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.credit.setFocusable(true);
				MainPortal2D.credit.requestFocusInWindow();
				MainPortal2D.credit.repaint();
				MainPortal2D.credit.revalidate();
			}
		});
		
		
		
	}
	

	public void paintComponent(Graphics g) {

		Image frstWinBackg = new ImageIcon(
				"./Box/Menu.jpg").getImage();
		g.drawImage(frstWinBackg, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	   

}
