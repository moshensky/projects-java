package com.moshensky.interfaces.classprocessor;

public class Apply
{
	
	public static void process(Processor p, Object s)
	{
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
		System.out.println();
	}

	public static String s = "Disagreement with beliefs is by definition incorrect";
	
	public static void main(String[] args)
	{
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}
			
			
	
}
