package com.moshensky;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RemoteDesktopGui extends JFrame implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel infoPanel = new JPanel(null);
	private JLabel tMouseX = new JLabel("Mouse X");
	private JLabel tMouseY = new JLabel("Mouse Y");
	private JButton btnConnect = new JButton("Connect");
	
	public SendData out;
	public double xRatio;
	public double yRatio;

	public RemoteDesktopGui()
	{
		super("Hello :) world");
		btnConnect.addActionListener(btnl);
		btnConnect.setFocusable(false);
		tMouseX.setFocusable(false);
		tMouseX.setBounds(10, 10, 220, 20);
		infoPanel.add(tMouseX);
		tMouseY.setFocusable(false);
		tMouseY.setBounds(10, 25, 220, 20);
		infoPanel.add(tMouseX);
		infoPanel.add(tMouseY);
		infoPanel.setBounds(400, 300, 220, 60);
		btnConnect.setBounds(400, 400, 100, 20);
		setLayout(null);
		//add(infoPanel);
		//add(btnConnect);
		setFocusTraversalKeysEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//turn of window decorations
        setUndecorated(true);
        //turn off the background
        //setBackground(new Color(100,100,100,77));
        //size the window
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setOpacity(0.3f);
        setVisible(true);
		
	}
	
	public void startListeners(RemoteDesktopGui frame)
	{
		addKeyListener(frame);
		addMouseListener(frame);
		addMouseMotionListener(frame);
		addMouseWheelListener(frame);
	}
	
	private ActionListener btnl = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
		}
	};

	@Override
	public void keyPressed(KeyEvent e) {
		out.send("1:" + e.getKeyCode());
		int keyCode = e.getKeyCode();
		String keyText = KeyEvent.getKeyText(keyCode);
		System.out.println(keyText + " " + keyCode);
	} 

	@Override
	public void keyReleased(KeyEvent e) {
		out.send("2:" + e.getKeyCode());		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		out.send("3:" + e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		out.send("4:" + e.getButton());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = (int)(e.getXOnScreen()*xRatio);
		int y = (int)(e.getYOnScreen()*yRatio);
		out.send("5:" + x + ":" + y);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		out.send("6:" + e.getWheelRotation());
	}
	
	
	//##########################################################################################
	//##########################################################################################
	//##########################################################################################
	
	// We do not need those methods, but they have to stay due to interface usage
	 
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
}
