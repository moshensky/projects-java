package com.moshensky;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.Socket;

public class RemoteDesktopControl 
{
	
	private static RemoteDesktopControl r;
	private static RemoteDesktopGui gui;
	
	//communication variables
	private static SendData out;
	private static RecieveData in;
	
	private static boolean isResolutionSet = false;
	
	public RemoteDesktopControl()
	{
		gui = new RemoteDesktopGui();
	}
	
	public static void main(String[] args)
	{		
		r = new RemoteDesktopControl();
		//initialize connection with server
		String host = "localhost";
		host = "192.168.1.5";
		int port = 9998;
		r.connectToServer(host, port);
		gui.out = out;
		
		while(true)
		{
			if (isResolutionSet)
				break;
		}
		
		gui.startListeners(gui);
	}
	
	private void connectToServer(String host, int port) 
	{		
		try {
			Socket socket = new Socket(host, port);
			//socket.setTcpNoDelay(true);
			out = new SendData(socket);
			in = new RecieveData(socket, this);
			in.start();
		} catch (Exception e) {
			e.printStackTrace();  
		} 
	}

	public void decodeCommand(String recievedData) {
		String[] tokens = recievedData.split(":");
		
		if (tokens[0].equals("screenSize"))
		{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) screenSize.getWidth();
			int height = (int) screenSize.getHeight();		
			
			gui.xRatio = width / Double.parseDouble(tokens[1]);
			gui.yRatio = height / Double.parseDouble(tokens[2]);	
			
			if (gui.xRatio < 1) gui.xRatio = 1 / gui.xRatio;
			if (gui.yRatio < 1) gui.yRatio = 1 / gui.yRatio;
			
			isResolutionSet = true;
		}
		
	}
	



}
