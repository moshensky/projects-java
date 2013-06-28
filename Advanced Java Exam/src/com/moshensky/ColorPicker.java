package com.moshensky;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class ColorPicker extends JFrame {

	private JLabel  label = new JLabel("A Label");
	private JButton btn = new JButton("Press to show RGB value!");
	private JSlider sbR = new JSlider(JSlider.HORIZONTAL, 0, 255, 77);
	private JSlider sbG = new JSlider(JSlider.HORIZONTAL, 0, 255, 77);
	private JSlider sbB = new JSlider(JSlider.HORIZONTAL, 0, 255, 77);

	

	
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int r = sbR.getValue();
			int g = sbG.getValue();
			int b = sbB.getValue();
			label.setText(String.format("Red: %3d, Green: %3d, Blue: %3d", r,g,b));
		}
	}

	class SlideBarListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			int r = sbR.getValue();
			int g = sbG.getValue();
			int b = sbB.getValue();
			label.setBackground(new Color(r, g, b));
			label.setForeground(new Color(255-r,255-g,255-b));
			label.setText(String.format("#%02X%02X%02X", r, g, b));
		}
	}

	public ColorPicker() {
		ActionListener bl = new ButtonListener();
		ChangeListener sbListener = new SlideBarListener();

		btn.addActionListener(bl);
		sbR.addChangeListener(sbListener);
		sbG.addChangeListener(sbListener);
		sbB.addChangeListener(sbListener);

		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		sbListener.stateChanged(null);
		setLayout(new GridLayout(5, 1));
		add(sbR);
		add(sbG);
		add(sbB);
		add(label);
		add(btn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new ColorPicker();
	}
}
