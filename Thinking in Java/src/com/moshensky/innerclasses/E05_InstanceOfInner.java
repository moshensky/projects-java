package com.moshensky.innerclasses;

class Outer {

	class Inner {

	}
}

public class E05_InstanceOfInner {

	public static void main(String[] args) {

		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		System.out.println(i);
	};
}
