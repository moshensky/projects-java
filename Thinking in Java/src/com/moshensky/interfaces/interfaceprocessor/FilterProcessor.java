package com.moshensky.interfaces.interfaceprocessor;

import com.moshensky.interfaces.filters.BandPass;
import com.moshensky.interfaces.filters.HighPass;
import com.moshensky.interfaces.filters.LowPass;
import com.moshensky.interfaces.filters.Waveform;

public class FilterProcessor 
{
	
	public static void main(String[] args)
	{
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
		
	}

}
