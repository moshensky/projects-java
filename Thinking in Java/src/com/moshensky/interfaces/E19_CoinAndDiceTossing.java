package com.moshensky.interfaces;

import java.util.Random;

interface Toss
{
	int toss();
}

interface TossingFactory
{
	Toss getToss();
}

class CoinTossing implements Toss
{
	private static final Random rand = new Random();
	@Override
	public int toss() {
		return rand.nextInt(2)+1;
	}
	
}

class DiceTossing implements Toss
{
	private static final Random rand = new Random();
	@Override
	public int toss() {
		return rand.nextInt(6)+1;
	}
}

class CoinTossingFactory implements TossingFactory
{

	@Override
	public Toss getToss() {
		return new CoinTossing();
	}
	
}

class DiceTossingFactory implements TossingFactory
{

	@Override
	public Toss getToss() {
		return new DiceTossing();
	}
	
}

public class E19_CoinAndDiceTossing {
	public static void toss(TossingFactory fact)
	{
		Toss t = fact.getToss();
		System.out.println(t.toss());
	}
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			toss(new CoinTossingFactory());
			toss(new DiceTossingFactory());
			System.out.println(" ");
		}
	}

}
