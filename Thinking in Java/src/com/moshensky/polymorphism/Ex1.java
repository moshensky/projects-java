package com.moshensky.polymorphism;
import static com.moshensky.util.Print.*;

class Cycle {
	public String toString() {
		return ("Cycle.ride()");
	}
	public int wheels() {
		return 0;
	}
}

class Unicycle extends Cycle {
	public String toString() {
		return "Unicycle.ride()";
	}
	public int wheels() {
		return 1;
	}
}

class Bicycle extends Cycle {
	public String toString() {
		return "Bicycle.ride()";
	}
	public int wheels() {
		return 2;
	}
}

class Tricycle extends Cycle {
	public String toString() {
		return "Tricycle.ride()";
	}
	public int wheels() {
		return 3;
	}
}

public class Ex1 {
	public static void ride(Cycle c) {
		print(c.wheels());
	}
	public static void main(String[] args) {
		ride(new Bicycle());
	}
}
