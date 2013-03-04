package com.moshensky.interfaces.classprocessor;

public class Downcase extends Processor
{
	@Override
	String process(Object input)
	{
		return ((String)input).toLowerCase();
	}
}
