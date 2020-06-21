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


public class Server{

	public ObjectOutputStream output;
	public ObjectInputStream input;
	private ServerSocket server;
	private String message="";
	private String serverIP;
	private Socket connection;
	
	public Server()
	{
		try {
			server= new ServerSocket(6789, 100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		// TODO Auto-generated method stub
//		showMessage("\n Attempting connection....");
		connection= server.accept();
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
			
//			System.out.println("msgs sent");
//			showMessage("\n Ami- "+ message);
		}
		catch(IOException e)
		{
			System.out.println("Error: Message could not be sent!");
		}
	}
	
}
