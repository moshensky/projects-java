package com.moshensky.innerclasses;


class StringHolder {
	private String s;
	
	StringHolder(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s;
	}
}


public class E02_SequenceOfStringHolders {

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		
		for (int i = 0; i < 10; i++) {
			sequence.add(new StringHolder("i=" + i));
		}
		
		Selector selector = sequence.selector();
		
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
