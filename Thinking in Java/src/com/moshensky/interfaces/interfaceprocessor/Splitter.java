package com.moshensky.interfaces.interfaceprocessor;

import java.util.Arrays;

class Splitter extends StringProcessor
{

	@Override
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}

}
