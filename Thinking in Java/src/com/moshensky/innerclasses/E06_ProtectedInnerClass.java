package com.moshensky.innerclasses;

import com.moshensky.innerclasses.e6a.SimpleInterface;
import com.moshensky.innerclasses.e6b.SimpleClass;

public class E06_ProtectedInnerClass extends SimpleClass {
	
	SimpleInterface inner() {
		return (SimpleInterface)new SimpleInnerClass("test");
	}
	
	public static void main(String[] args) {
		E06_ProtectedInnerClass foo = new E06_ProtectedInnerClass();
		System.out.println(foo.inner().print());
	}
	
}
