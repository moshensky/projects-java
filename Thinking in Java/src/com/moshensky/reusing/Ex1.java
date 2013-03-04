package com.moshensky.reusing;

class Ex1Simple {
	public Ex1Simple() {};
}

public class Ex1 {
	Ex1Simple x;
	public void main(String[] args) {
		if (x == null)
			x = new Ex1Simple();
		}
}
