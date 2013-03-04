package com.moshensky.concurrency.waxomatic;

import java.util.concurrent.TimeUnit;

class Car {
	private boolean waxOn = false;
	
	public synchronized void waxed(){
		waxOn = true; //ready to buff
		notifyAll();
	}
	public synchronized void buffed(){
		waxOn = false;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException {
		while(waxOn == true)
			wait();
	}
	public synchronized void waitForBuffing() throws InterruptedException {
		while(waxOn == false)
			wait();
	}
}

class WaxOn implements Runnable {
	private Car car;
	
	public WaxOn(Car c){
		car = c;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}			
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
}

class WaxOff implements Runnable {
	private Car car;
	
	public WaxOff(Car c){
		car = c;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}

public class WaxOMatic {
	public static void main(String[] args) throws Exception{
		Car car = new Car();
		
		(new Thread(new WaxOff(car))).start();
		(new Thread(new WaxOn(car))).start();
	}
}












