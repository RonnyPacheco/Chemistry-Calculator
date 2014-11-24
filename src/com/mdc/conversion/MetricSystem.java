package com.mdc.conversion;

import java.util.ArrayList;

public class MetricSystem {

	static ArrayList<String> volumeUnit = new ArrayList<>();
	static ArrayList<String> lengthUnit = new ArrayList<>();
	static ArrayList<String> massUnit = new ArrayList<>();
	
	private static String[] keys = new String[]{"Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "", "Kilo"};
	static
	{
		
		for(String key : keys)
		{
			volumeUnit.add(key + "Liter");
		}
		
		for(String key : keys)
		{
			lengthUnit.add(key + "Meter");
		}
		
		for(String key : keys)
		{
			massUnit.add(key + "Gram");
		}
	}
}
