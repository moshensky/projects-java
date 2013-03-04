package com.moshensky.polymorphism;
import com.moshensky.polymorphism.shape.*;
import static com.moshensky.util.Print.*;

public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		// fill shape array with shapes
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		for (Shape shp : s) {
			shp.draw();
		}
		print("-----------------------------------");
		// Excercie 3
		Shape[] shapes = { new Circle(), new Triangle(), new Square(), new Oval() };
		for (Shape sh : shapes) {
			sh.draw();
			sh.erase();
			sh.msg();			
		}
	}
}
