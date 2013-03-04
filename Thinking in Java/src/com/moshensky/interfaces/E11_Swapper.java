package com.moshensky.interfaces;

import com.moshensky.interfaces.interfaceprocessor.Apply;

public class E11_Swapper {

	public static void main(String[] args)
	{
		Apply.process(new SwapperAdapter(), "abcde");
		Apply.process(new SwapperAdapter(), "1234");
	}
	
}
