package com.moshensky.interfaces.classprocessor;

import java.util.Arrays;

public class Splitter extends Processor
{
	@Override
	String process(Object input)
	{
		return Arrays.toString(((String)input).split(" "));
	}
}
