package com.moshensky.polymorphism.shape;
import static com.moshensky.util.Print.*;

public class Square extends Shape{
	@Override public void draw() {
		print("Square.draw()");
	}
	@Override public void erase() {
		print("Square.erase()");
	}
	@Override public void msg() {
		print("Square.msg()");
	}
}
