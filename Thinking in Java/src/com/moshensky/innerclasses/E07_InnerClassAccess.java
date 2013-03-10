package com.moshensky.innerclasses;

public class E07_InnerClassAccess {
	private String s = "Hello World!";
	
	private String print() {
		return s;
	}
	
	class Inner {
		void modify(String as) {
			s = as;
			System.out.println(print());
		}
	}
	
	public void alter(String s) {
		(new Inner()).modify(s);
	}
	
	public static void main(String[] args) {
		new E07_InnerClassAccess().alter("new World :");
	}
	
}
