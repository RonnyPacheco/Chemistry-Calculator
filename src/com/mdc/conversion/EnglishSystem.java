package com.mdc.conversion;

import java.util.ArrayList;

class EnglishSystem {

	static ArrayList<String> volumeUnit = new ArrayList<>();
	static ArrayList<String> lengthUnit = new ArrayList<>();
	static ArrayList<String> massUnit = new ArrayList<>();
	
	static
	{
		volumeUnit.add("Cup");
		volumeUnit.add("Pint");
		volumeUnit.add("Liter");
		volumeUnit.add("Galon");
		
		lengthUnit.add("Inch");
		lengthUnit.add("Foot");
		lengthUnit.add("Yard");
		lengthUnit.add("Mile");
		
		massUnit.add("Pound");
		massUnit.add("Ton");
	}
}
