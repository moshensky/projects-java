package com.moshensky.innerclasses;


public class E04_Sequence {
	private Object[] items;
	private int next = 0;
	
	public E04_Sequence(int size) {
		items = new Object[size];
	}
	
	public void add(Object x) {
		if (next < items.length)
			items[next++] = x;
	}
	
	public class SequenceSelector implements Selector {
		private int i = 0;
		
		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length)
				i++;
		}
		
		public E04_Sequence outer() {
			return E04_Sequence.this;
		}
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}
	
	public boolean check() {
		return this == ((SequenceSelector)selector()).outer();
	}
	
	public static void main(String[] args) {
		E04_Sequence sequence = new E04_Sequence(10);
		System.out.println(sequence.check());
		
		
	}
	
}
