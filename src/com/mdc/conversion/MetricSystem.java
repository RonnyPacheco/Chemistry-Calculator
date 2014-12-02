package com.mdc.conversion;

import java.util.ArrayList;

/**
 * Hidden class that contains all our metric system definitions.
 * @author Tony Erazo
 *
 */
class MetricSystem {

	/**
	 * List containing our volume units of the metric system.
	 */
	static ArrayList<String> volumeUnit = new ArrayList<>();
	
	/**
	 * List containing our length units of the metric system.
	 */
	static ArrayList<String> lengthUnit = new ArrayList<>();
	
	/**
	 * List containing our mass units of the metric system.
	 */
	static ArrayList<String> massUnit = new ArrayList<>();
	
	/**
	 * Conversion key sub clauses to converting other metric units.
	 */
	private static String[] keys = new String[]{"Micro", "Milli", "Centi", "Deci", "", "Kilo"};
	
	/**
	 * Static constructor adds all of our metric units.
	 */
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
