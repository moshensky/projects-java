package com.moshensky;
import java.io.*;
import java.net.*;

public class SendData {
	
	Socket socket;
	private PrintWriter out = null;
	
	public String data = null;
	
	public SendData(Socket socket)
	{
		this.socket = socket;
	}
		
	public void send(String data) {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println(e);
		}
		out.println(data);
		//System.out.println("<DEBUG>out command: " + data);
	}

}
