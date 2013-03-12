package com.moshensky.generics;

import java.util.Iterator;
import java.util.Random;

import javax.management.RuntimeErrorException;


class StoryCharacter {
	private static long counter;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}

class GoodGuy extends StoryCharacter {
	@Override
	public String toString() {
		return super.toString() + " is a good guy";
	}
}

class BadGuy extends StoryCharacter {
	@Override
	public String toString() {
		return super.toString() + " is a bad guy";
	}
}

class Neo extends GoodGuy {}
class Trinity extends GoodGuy {}
class AgentSmith extends BadGuy {}
class Architect extends BadGuy {}

class CharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

	private Class<?>[] types = {
			Neo.class, Trinity.class, AgentSmith.class, Architect.class,
	};
	
	private static Random rand = new Random(47);
	
	public CharacterGenerator() {
		
	}
	
	private int size = 0;
	
	public CharacterGenerator(int size) {
		this.size = size;
	}
	
	class CharacterIterator implements Iterator<StoryCharacter> {

		private int count = size;
		
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public StoryCharacter next() {
			count--;
			return CharacterGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	@Override
	public Iterator<StoryCharacter> iterator() {
		return new CharacterIterator();
	}

	@Override
	public StoryCharacter next() {
		try {
			return (StoryCharacter)types[rand.nextInt(types.length)].newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

public class E08_CharacterGenerator {
	
	public static void main(String[] args) {
		CharacterGenerator gen = new CharacterGenerator();
		
		for (int i = 0; i < 7; i++) {
			System.out.println(gen.next());
		}
		
		System.out.println();
		
		for (StoryCharacter ch : new CharacterGenerator(7)) {
			System.out.println(ch);
		}
	}

}
