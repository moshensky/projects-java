package com.moshensky.polymorphism.shape;
import static com.moshensky.util.Print.*;

public class Triangle extends Shape{
	@Override public void draw() {
		print("Triangle.draw()");
	}
	@Override public void erase() {
		print("Triangle.erase()");
	}
	@Override public void msg() {
		print("Triangle.msg()");
	}
}