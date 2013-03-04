package com.moshensky;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server extends Thread{
	private static int port = 9998;
	private static int socketTimeout = 0; // 30000; // ms
	private static BufferedReader in = null;
	private static PrintWriter out = null;
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	
	private static InputEmulator emulator;
	private static Gui gui;
	
	private boolean leftMouseBtnDown;

	private static void init()
	{
		// Initializations
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setReuseAddress(true);
			System.out.println(System.currentTimeMillis() + " [GAMESERVER] Connection Socket Created");
		} catch (IOException e) {
			System.err.println(System.currentTimeMillis() + " [GAMESERVER] Could not listen on port: " + port);
			System.err.println(e);
			System.exit(1);
		}
		System.out.println(System.currentTimeMillis() + " [GAMESERVER] Waiting for Connection");
	}
	
	private static Socket waitForConnection()
	{
		gui = new Gui();
		Socket clientSocket = null;
		// Check for new incoming connections
		try {
			if ((clientSocket = serverSocket.accept()).isConnected()) {
				clientSocket.setTcpNoDelay(true);
				clientSocket.setSoTimeout(socketTimeout);
				System.out.println(System.currentTimeMillis() + " [GAMESERVER] New Connection: " + clientSocket);
			}
		} catch (Exception e) {
			System.err.println(System.currentTimeMillis() + " [GAMESERVER] clientSocket Exception: " + e);
		}
		
		return clientSocket;
	}
	
	public static void main(String[] args)
	{
		
		
				
		init();
		clientSocket = waitForConnection();
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println(e);
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();		
		out.println("screenSize:" + width + ":" + height);
		
		
		
		Server s = new Server();
		emulator = new InputEmulator();
		while (true)
		{
			s.run();
		}
	}

	
	/*
	 * Input data from player
	 */
	public void run() {		
		try {
			String data;
			while ((data = in.readLine()) !=null) 
			{
				//System.out.println("<debug recieved data> " + data);
				decodeCommand(data);
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void decodeCommand(String command) 
	{		
		String[] tokens = command.split(":");
		int cmnd = Integer.parseInt(tokens[0]);
		int value = Integer.parseInt(tokens[1]);
		
		if (cmnd != 5)
			gui.textArea.append(command + "\n");
		
		switch (cmnd)
		{
		case 1:
			emulator.pressKey(value);
			break;
		case 2:
			emulator.releaseKey(value);
			break;
		case 3:
			// mouse btn pressed
			switch (value)
			{
			case 1:
				emulator.pressLeftMouseBtn();
				leftMouseBtnDown = true;
				break;
			case 2:
				emulator.pressMiddleMouseBtn();
				break;
			case 3:
				emulator.pressRightMouseBtn();
				break;
			}
			break;
		case 4:
			// mouse btn released
			switch (value)
			{
			case 1:
				emulator.releaseLeftMouseBtn();
				leftMouseBtnDown = false;
				break;
			case 2:
				emulator.releaseMiddleMouseBtn();
				break;
			case 3:
				emulator.releaseRightMouseBtn();
				break;
			}
			break;
		case 5:
			emulator.moveMouse(value, Integer.parseInt(tokens[2]), leftMouseBtnDown);
			break;
		case 6:
			emulator.moveMouseWheel(value);
			break;
		}
	}
	
}
