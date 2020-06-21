package State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import portal2D.MainPortal2D;
import network.Client;

public class Join extends JPanel{

	public JTextField IP= new JTextField("Enter Host's IP...");
	public JButton back= new JButton("Back");
	
	public Join(final Client cl)
	{
		setLayout(null);
		
		IP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.serverIP= e.getActionCommand();
				MainPortal2D.frame.remove(MainPortal2D.join);
				MainPortal2D.frame.add(MainPortal2D.connect);
				
				MainPortal2D.state=11;
//				System.out.println(MainPortal2D.state);
				MainPortal2D.connect.setFocusable(true);
				MainPortal2D.connect.requestFocusInWindow();
				MainPortal2D.connect.repaint();
				MainPortal2D.connect.revalidate();
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainPortal2D.frame.remove(MainPortal2D.join);
				MainPortal2D.frame.add(MainPortal2D.host);
				
				MainPortal2D.host.setFocusable(true);
				MainPortal2D.host.requestFocusInWindow();
				MainPortal2D.host.repaint();
				MainPortal2D.host.revalidate();
			}
		});
		
		IP.setBounds(400, 350, 200, 50);
		back.setBounds(400,450,100,50);
		add(IP);
		add(back);
	}
}
