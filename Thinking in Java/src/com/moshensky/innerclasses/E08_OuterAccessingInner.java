package com.moshensky.innerclasses;

public class E08_OuterAccessingInner {
	class Inner {
		private String s = "inner private field";
	}
	
	public void print() {
		System.out.println((new Inner()).s);
	}
	
	public static void main(String[] args) {
		new E08_OuterAccessingInner().print();
	}
}
