package com.moshensky.interfaces.classprocessor;

public class Upcase extends Processor
{
	@Override
	String process(Object input)
	{
		return ((String)input).toUpperCase();
	}
}
