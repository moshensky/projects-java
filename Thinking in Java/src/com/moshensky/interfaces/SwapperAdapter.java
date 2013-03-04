package com.moshensky.interfaces;

import com.moshensky.interfaces.interfaceprocessor.Processor;

class SwapperAdapter implements Processor
{

	@Override
	public String name() {
		return CharacterPairSwapper.class.getName();
	}

	@Override
	public String process(Object input) {
		return CharacterPairSwapper.swap((String)input);
	}

}
