package com.mdc.conversion;

import java.util.ArrayList;

/**
 * Hidden class that contains all our english system definitions.
 * @author Tony Erazo
 *
 */
class EnglishSystem {

	/**
	 * List containing our volume units of the english system.
	 */
	static ArrayList<String> volumeUnit = new ArrayList<>();
	
	/**
	 * List containing our length units of the english system.
	 */
	static ArrayList<String> lengthUnit = new ArrayList<>();
	
	/**
	 * List containing our mass units of the english system.
	 */
	static ArrayList<String> massUnit = new ArrayList<>();
	
	/**
	 * Static constructor adds all of our english units.
	 */
	static
	{
		volumeUnit.add("Cup");
		volumeUnit.add("Pint");
		volumeUnit.add("Liter");
		volumeUnit.add("Gallon");
		
		lengthUnit.add("Inch");
		lengthUnit.add("Foot");
		lengthUnit.add("Yard");
		lengthUnit.add("Mile");
		
		massUnit.add("Pound");
		massUnit.add("Ton");
	}
}
