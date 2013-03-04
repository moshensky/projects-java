package com.moshensky.interfaces;

class CharacterPairSwapper
{
	
	static String swap(String input)
	{
		StringBuilder str = new StringBuilder(input.length());
		
		for (int i = 0; i < input.length() - 1; i += 2)
		{
			str.append(input.charAt(i+1));
			str.append(input.charAt(i));
		}
		
		if (input.length() % 2 != 0)
			str.append(input.charAt(input.length() - 1));
		
		return str.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(swap("1234"));
		System.out.println(swap("abcde"));
	}

}
