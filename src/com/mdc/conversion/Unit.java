package com.mdc.conversion;

import java.util.ArrayList;


public class Unit {
	
	private static ArrayList<String> massUnit = new ArrayList<>();
	private static ArrayList<String> volumeUnit = new ArrayList<>();
	private static ArrayList<String> lengthUnit = new ArrayList<>();
	
	static
	{
		massUnit.addAll(EnglishSystem.massUnit);
		massUnit.addAll(MetricSystem.massUnit);
		
		volumeUnit.addAll(EnglishSystem.volumeUnit);
		volumeUnit.addAll(MetricSystem.volumeUnit);
		
		lengthUnit.addAll(EnglishSystem.lengthUnit);
		lengthUnit.addAll(MetricSystem.lengthUnit);
	}
	
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
	
	public static ArrayList<String> getMetricUnit(String unit)
	{
		switch(unit)
		{
		case "Mass":
			return MetricSystem.massUnit;
		case "Volume":
			return MetricSystem.volumeUnit;
		case "Length":
			return MetricSystem.lengthUnit;
		default:
			//Return an empty arraylist
			return new ArrayList<String>();
		}
	}
	
	public static ArrayList<String> getAllUnits(String unit)
	{
		switch(unit)
		{
		case "Mass":
			return massUnit;
		case "Volume":
			return volumeUnit;
		case "Length":
			return lengthUnit;
		default:
			//Return an empty arraylist
			return new ArrayList<String>();
		}
	}

}
