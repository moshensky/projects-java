package com.moshensky.access;
import static com.moshensky.util.Print.*;

class Ex4Temp {
	protected void f() {
		print("protected method");
	}
}

public class Ex4 {
	public static void main(String[] args) {
		
		new Ex4Temp().f();
	}	
}
