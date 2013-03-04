package com.moshensky.interfaces.interfaceprocessor;

import com.moshensky.interfaces.filters.Filter;
import com.moshensky.interfaces.filters.Waveform;

class FilterAdapter implements Processor
{

	Filter filter;
	
	public FilterAdapter(Filter filter)
	{
		this.filter = filter;
	}
	
	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Waveform process(Object input) {
		return filter.process((Waveform)input);
	}

}
