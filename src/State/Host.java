package State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import portal2D.MainPortal2D;

public class Host extends JPanel{
	
	public JButton host= new JButton("Host a game...");
	public JButton join= new JButton("Join");
	public JButton back= new JButton("Back");
	public Host()
	{
		setLayout(null);
		host.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainPortal2D.frame.remove(MainPortal2D.host);
				MainPortal2D.frame.add(MainPortal2D.connect);
				
				MainPortal2D.state=11;
				MainPortal2D.network_state=1;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.connect.setFocusable(true);
				MainPortal2D.connect.requestFocusInWindow();
				MainPortal2D.connect.repaint();
				MainPortal2D.connect.revalidate();
				
				System.out.println("connect");
			}
		});
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainPortal2D.frame.remove(MainPortal2D.host);
				
				MainPortal2D.join= new Join(MainPortal2D.client);
				MainPortal2D.frame.add(MainPortal2D.join);
				
				MainPortal2D.state=21;
				MainPortal2D.network_state=2;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.join.setFocusable(true);
				MainPortal2D.join.requestFocusInWindow();
				MainPortal2D.join.repaint();
				MainPortal2D.join.revalidate();
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainPortal2D.frame.remove(MainPortal2D.host);
				MainPortal2D.frame.add(MainPortal2D.menu);
				
				MainPortal2D.state=0;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.menu.setFocusable(true);
				MainPortal2D.menu.requestFocusInWindow();
				MainPortal2D.menu.repaint();
				MainPortal2D.frame.revalidate();
			}
		});
		
		host.setBounds(400, 270,360 , 50);
		join.setBounds(400, 370,360 , 50);
		back.setBounds(400, 470, 360, 50);
		
		add(host);
		add(join);
		add(back);
	}
}
