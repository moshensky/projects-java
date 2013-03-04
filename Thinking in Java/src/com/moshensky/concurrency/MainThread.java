package com.moshensky.concurrency;

import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		LiftOff launch = new LiftOff();
		
		for(int i=0; i < 100;i++)
		{
			launch = new LiftOff();
			 TimeUnit.MILLISECONDS.sleep(1000);
			 System.out.println(i);
			 Thread t = new Thread(launch);
			 t.start();
		}

	}

}
