package com.moshensky.polymorphism.shape;
import static com.moshensky.util.Print.*;

public class Oval extends Shape{
	@Override public void draw() {
		print("Oval.draw()");
	}
	@Override public void erase() {
		print("Oval.erase()");
	}
	@Override public void msg() {
		print("Oval.msg()");
	}
}
