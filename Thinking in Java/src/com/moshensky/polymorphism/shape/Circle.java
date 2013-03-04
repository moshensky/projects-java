package com.moshensky.polymorphism.shape;
import static com.moshensky.util.Print.*;

public class Circle extends Shape{
	@Override public void draw() {
		print("Circle.draw()");
	}
	@Override public void erase() {
		print("Circle.erase()");
	}
	@Override public void msg() {
		print("Circle.msg()");
	}
}
