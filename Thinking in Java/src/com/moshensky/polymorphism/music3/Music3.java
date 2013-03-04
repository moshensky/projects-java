package com.moshensky.polymorphism.music3;
import com.moshensky.polymorphism.music.Note;
import static com.moshensky.util.Print.*;

class Instrument {
	void play(Note n) {
		print("Instrument.play() " + n);
	}
	public String toString() {
		return "Instrument";
	}
	void adjust() {
		print("Adjusting Instrument");
	}
}

class Wind extends Instrument {
	void play(Note n) {
		print("Wind.play() " + n);
	}
	public String toString() {
		return "Wind";
	}
	void adjust() {
		print("Adjusting Wind");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		print("Percussion.play() " + n);
	}
	public String toString() {
		return "Percussion";
	}
	void adjust() {
		print("Adjusting Wind");
	}
}

class Stringed extends Instrument {
	void play(Note n) {
		print("Stringed.play() " + n);
	}
	public String toString() {
		return "Stringed";
	}
	void adjust() {
		print("Adusting Stringged");
	}
}

class Brass extends Wind {
	void play(Note n) {
		print("Brass.play() " + n);
	}
	void adjust() {
		print("Adjusting Brass");
	}
}

class Woodwind extends Wind {
	void play(Note n) {
		print("Woodwind.play() " + n);
	}
	public String toString() {
		return "Woodwind";
	}
}

public class Music3 {
	private static RandomInstrumentGenerator genInstrument = new RandomInstrumentGenerator();
	public static void tune(Instrument i) {
		//...
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] e) {
		for(Instrument i : e)
			tune(i);
	}
	public static void main(String[] args) {
		// Upcasting during addition to the array:
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
		print(new Brass());
		print("---- Instrument Generator ----");
		
		Instrument[] orchestra1 = new Instrument[10];
		for (int i=0; i<orchestra1.length; i++)
			orchestra1[i] = genInstrument.next();
		for (Instrument i : orchestra1) {
			print(i);
		}
		
		tune(new Brass());
	}

}
