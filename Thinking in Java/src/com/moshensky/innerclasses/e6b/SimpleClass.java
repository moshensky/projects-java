package com.moshensky.innerclasses.e6b;

import com.moshensky.innerclasses.e6a.SimpleInterface;

public class SimpleClass {

	protected class SimpleInnerClass implements SimpleInterface {
		private String s;
		
		public SimpleInnerClass(String s) {
			this.s = s;
		}
		
		@Override
		public String print() {
			return "s=" + s;
		}
		
	}
}
