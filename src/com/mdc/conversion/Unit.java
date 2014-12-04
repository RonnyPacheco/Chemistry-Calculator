package com.mdc.conversion;

import java.util.ArrayList;

/**
 * The unit class provides us with the definitions of our metric and english system.
 * @author Tony Erazo
 * @author Ronny
 */
public class Unit {
	
	/**
	 * List containing all the mass units of the English & Metric System.
	 */
	private static ArrayList<String> massUnit = new ArrayList<>();
	
	/**
	 * List containing all the volume units of the English & Metric System.
	 */
	private static ArrayList<String> volumeUnit = new ArrayList<>();
	
	/**
	 * List containing all the length units of the English & Metric System.
	 */
	private static ArrayList<String> lengthUnit = new ArrayList<>();
	
	/**
	 * List containing all the time units.
	 */
	private static ArrayList<String> timeUnit = new ArrayList<>();
	
	/**
	 * Prevents instantiation of this class.
	 */
	private Unit(){}
	
	/**
	 * Static constructor adds all of our metric & english units.
	 */
	static
	{
		massUnit.addAll(EnglishSystem.massUnit);
		massUnit.addAll(MetricSystem.massUnit);
		
		volumeUnit.addAll(EnglishSystem.volumeUnit);
		volumeUnit.addAll(MetricSystem.volumeUnit);
		
		lengthUnit.addAll(EnglishSystem.lengthUnit);
		lengthUnit.addAll(MetricSystem.lengthUnit);
		
		timeUnit.add("Second");
		timeUnit.add("Minute");
		timeUnit.add("Hour");
		timeUnit.add("Day");
		timeUnit.add("Month");
		timeUnit.add("Year");
	}
	
	/**
	 * Gets an arraylist of all the english units
	 * @param unit the type of unit eg Mass, Length, Volume.
	 * @return english definitions list.
	 */
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
	
	/**
	 * Gets an arraylist of all the metric units
	 * @param unit the type of unit eg Mass, Length, Volume.
	 * @return metric definitions list.
	 */
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
	
	/**
	 * Gets an arraylist of all the metric & english units
	 * @param unit the type of unit eg Mass, Length, Volume.
	 * @return metric & english definitions list.
	 */
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
		case "Time":
			return timeUnit;
		default:
			//Return an empty arraylist
			return new ArrayList<String>();
		}
	}

}
