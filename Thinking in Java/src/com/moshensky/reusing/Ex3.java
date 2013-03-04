package com.moshensky.reusing;

class Art {
	Art () { System.out.println("art const");}
}

class Drawing extends Art {
	Drawing() { System.out.println("drawing const");}
}

public class Ex3 extends Drawing {
	public static void main(String[] args) {
		Ex3 x = new Ex3();
	}
}
