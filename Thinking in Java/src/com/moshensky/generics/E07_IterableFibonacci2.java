package com.moshensky.generics;

import java.util.Iterator;

public class E07_IterableFibonacci2 implements Iterable<Integer> {

	private Fibonacci fib = new Fibonacci();
	private int n;
	
	public E07_IterableFibonacci2(int count) {
		n = count;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return fib.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	public static void main(String[] args) {
		for (Integer i : new E07_IterableFibonacci2(18))
			System.out.println(i);
	}
	

}
