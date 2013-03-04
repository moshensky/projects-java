package com.moshensky.polymorphism.music3;

import java.util.Random;

public class RandomInstrumentGenerator {
	private Random rand = new Random();
	
	public Instrument next() {
		switch(rand.nextInt(5)) {
		default:
		case 0:
			return new Woodwind();
		case 1:
			return new Brass();
		case 2:
			return new Stringed();
		case 3:
			return new Percussion();
		case 4:
			return new Wind();
		}
	}

}
