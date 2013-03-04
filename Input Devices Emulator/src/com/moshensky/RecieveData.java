package com.moshensky;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecieveData extends Thread{
	Socket socket;
	private BufferedReader in = null;
	
	private String recievedData = "";
	private GameProtocol gameProtocol;
		
	public RecieveData(Socket socket, GameProtocol gp)
	{
		gameProtocol = gp;
		this.socket = socket;
		//System.out.println("New Communication Thread Started");
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
		
	public void run() {
		String data = null;
		try {
			while ((data = in.readLine()) != null) {
				recievedData = data;
				System.out.println("<DEBUG>income command: " + recievedData);
				gameProtocol.decodeCommand(recievedData);
			}
		} catch (IOException e) {
			System.err.println("RecieveData: " + e);				
		}
	}
	
	public String readMsg()
	{
		//TODO synk?
		
		if (!recievedData.equals(""))
		{
			String command = recievedData;
			recievedData = "";
			System.out.println("<DEBUG>income command: " + command);
			return command;
		}
		return "";
	}
}
