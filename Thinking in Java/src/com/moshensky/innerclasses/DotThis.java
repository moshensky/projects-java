package com.moshensky.innerclasses;

public class DotThis {
	public static int count = 0;
	void f() {
		System.out.println("DotThis.f()");
	}
	
	public class Inner {
		private int n;
		Inner(int count) {
			n = count;
		}
		public DotThis outer() {
			System.out.println(n);
			return DotThis.this;  // a plain "this" would be Inner's "this"
		}
	}
	
	public Inner inner() {
		return new Inner(count++);
	}
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti = dt.inner();
		
		dti.outer().f();
	}
}
