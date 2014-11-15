package com.mdc.conversion;

import java.util.ArrayList;


public class Unit {
	
	public static ArrayList<String> getEnglishUnit(String unit)
	{
		switch(unit)
		{
		case "Mass":
			return EnglishSystem.massUnit;
		case "Volume":
			return EnglishSystem.volumeUnit;
		case "Length":
			return EnglishSystem.lengthUnit;
		default:
			//Return an empty arraylist
			return new ArrayList<String>();
		}
	}

}
