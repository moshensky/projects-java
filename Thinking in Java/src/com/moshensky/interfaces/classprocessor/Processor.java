package com.moshensky.interfaces.classprocessor;

public class Processor 
{
	
	public String name()
	{
		return getClass().getSimpleName();
	}
	
	Object process(Object input)
	{
		return input;
	}

}
