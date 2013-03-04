package com.moshensky;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


/*
 * left click
 * right click
 * middle click
 * scroll up
 * scroll down
 * mouse move to X Y
 * mouse drag
 * 
 */

public class InputEmulator {
	private Robot robot;
	
	public InputEmulator()
	{		
		try {
			robot = new Robot();			
			//robot.setAutoDelay(20);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pressKey(int keycode)
	{
		robot.keyPress(keycode);
		//System.out.println(keycode);
	}
	
	public void releaseKey(int keycode)
	{
		robot.keyRelease(keycode);
		//System.out.println(keycode);
	}
		
	public void moveMouse(int x, int y, boolean mouseDown)
	{
		if (mouseDown)
		{
			// start dragging
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseMove(x, y);
		}
		else
		{
			robot.mouseMove(x, y);
		}
		//System.out.println("Mouse moved: " + x + ", " + y);
	}
	
	public void pressLeftMouseBtn()
	{
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//System.out.println("Left mouse button pressed");
	}
	
	public void releaseLeftMouseBtn()
	{
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//System.out.println("Left mouse button released");
	}
	
	public void pressRightMouseBtn()
	{
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		//System.out.println("Right mouse button press");
	}
	
	public void releaseRightMouseBtn()
	{
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		//System.out.println("Right mouse button released");
	}
	
	public void pressMiddleMouseBtn()
	{
		robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		//System.out.println("Middle mouse button pressed");
	}
	
	public void releaseMiddleMouseBtn()
	{
		robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
		//System.out.println("Middle mouse button released");
	}
	
	public void moveMouseWheel(int wheelAmt)
	{
		robot.mouseWheel(wheelAmt);
		//System.out.println("Mouse wheel moved: " + wheelAmt);
	}
}
