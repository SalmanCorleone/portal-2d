package network;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Client{

	public ObjectOutputStream output;
	public ObjectInputStream input;
	private ServerSocket server;
	private String message="";
	public String serverIP;
	private Socket connection;
	
	public Client(String host)
	{
		serverIP= host;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public void startRunning()
	{
		try
		{
			connectToServer();
			setupStream();
//			whileChatting();
		}
		catch(EOFException e)
		{
//			showMessage("\n connection terminated by client");
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		finally
//		{
//			closeCrap();
//		}
	}

	private void connectToServer() throws IOException
	{
		System.out.println(serverIP);
		// TODO Auto-generated method stub
//		showMessage("\n Attempting connection....");
		connection= new Socket(InetAddress.getByName(serverIP),6789);
//		showMessage(" Now connected to "+ connection.getInetAddress().getHostName());
	}
	
	private void setupStream() throws IOException
	{
		output= new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input= new ObjectInputStream(connection.getInputStream());
//		showMessage("\n Streams are now set up!! \n");
	}
	
	
	private void closeCrap()
	{
//		showMessage("\n Closing connection \n");
		
		try
		{
			input.close();
			output.close();
			connection.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String a)
	{
		try
		{
			output.writeObject(a);
			output.flush();
//			showMessage("\n Ami- "+ message);
		}
		catch(IOException e)
		{
//			chatWindow.append("Error: Message could not be sent!");
		}
	}
	
}
