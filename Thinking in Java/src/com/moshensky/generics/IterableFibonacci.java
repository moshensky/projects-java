package com.moshensky.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{

	private int n;
	
	public IterableFibonacci(int count) {
		n = count;
	}
		
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			private int n = IterableFibonacci.this.n;
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	public static void main(String[] args) {
		IterableFibonacci gen = new IterableFibonacci(18);
		
		for(int i : gen) {
			System.out.println(i);
		}

	}


}
