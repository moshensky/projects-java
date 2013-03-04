package com.moshensky;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	JTextArea textArea = new JTextArea();
	JScrollPane sp = new JScrollPane(textArea);
	
	
	
	
	public Gui()
	{
		super("Input Emulator");
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setVisible(true);
	}
}
