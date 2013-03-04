package com.moshensky.interfaces.interfaceprocessor;

public class Apply
{

	public static void process(Processor p, Object s)
	{
		System.out.println("Using Processor " + p.name());
		System.out.print(p.process(s));
		System.out.println();
	}
	
}
