package com.moshensky.polymorphism;


class AlertStatus {
	public void status() {
		
	}
}

class AlertStatusRed extends AlertStatus {
	public void status() {
		System.out.println("Red Alert!");
	}
}

class AlertStatusGreen extends AlertStatus {
	public void status() {
		System.out.println("Alert status normal.");
	}
}

class AlertStatusOrange extends AlertStatus {
	public void status() {
		System.out.println("Caution!");
	}
}

enum AlertOptions {
	ALERT_RED, ALERT_GREEN, ALERT_ORANGE 
}


public class Starship {
	private AlertStatus alert = new AlertStatusGreen();
	public void changeAlert(AlertOptions alert) {
		switch (alert) {
		case ALERT_RED:
			this.alert = new AlertStatusRed();
			break;
		case ALERT_GREEN:
			this.alert = new AlertStatusGreen();
			break;
		case ALERT_ORANGE:
			this.alert = new AlertStatusOrange();
			break;
		}
	}
	public void activateAlarm() {
		alert.status();
	}
	public static void main(String[] args) {
		Starship Battlecruiser = new Starship();
		AlertOptions[] alerts = AlertOptions.values();
		for (int i=0; i<3;i++) {
			Battlecruiser.changeAlert(alerts[i]);
			Battlecruiser.activateAlarm();
		}
		
		
	}
	
}
