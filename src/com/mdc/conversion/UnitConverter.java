package com.mdc.conversion;

/**
 * Unit converter handles all the chemistry formulas to converting our units.
 * This class can convert english units to metric and vise versa.
 * @author Tony Erazo
 * @author Ronny
 */
public class UnitConverter {
	
	/**
	 * Prevents object instantiation.
	 */
	private UnitConverter(){}
	
	/**
	 * Converts a specified unit to another specified unit.
	 * @param measurementType the type of measurement English or Metric unit eg Kilometer, Pound, Year, Day, Second, etc.
	 * @param unitOne the unit converted.
	 * @param amount the amount of the unitOne being provided to conversion.
	 * @param unitTwo the unit we are converting unitOne to.
	 * @return the conversion.
	 */
	public static double convert(String measurementType, String unitOne, double amount, String unitTwo)
	{
		if(unitOne.equals(unitTwo) || amount == 0)
		{
			return amount;
		}
		else if(unitOne.contains("Kilo") && unitTwo.contains("Deci"))
		{
			amount *= 10000; 
		}
		else if(unitOne.contains("Deci") && unitTwo.contains("Kilo"))
		{
			amount /= 10000; 
		}
		else if(unitOne.contains("Kilo") && unitTwo.contains("Centi"))
		{
			amount *= 100000; 
		}
		else if(unitOne.contains("Centi") && unitTwo.contains("Kilo"))
		{
			amount /= 100000; 
		}
		else if(unitOne.contains("Kilo") && unitTwo.contains("Milli"))
		{
			amount *= 1000000; 
		}
		else if(unitOne.contains("Milli") && unitTwo.contains("Kilo"))
		{
			amount /= 1000000; 
		}
		else if(unitOne.contains("Kilo") && unitTwo.contains("Micro"))
		{
			amount *= 1000000000; 
		}
		else if(unitOne.contains("Micro") && unitTwo.contains("Kilo"))
		{
			amount /= 1000000000; 
		}
		
		else if(unitOne.contains("Centi") && unitTwo.contains("Deci"))
		{
			amount /= 10; 
		}
		else if(unitOne.contains("Deci") && unitTwo.contains("Centi"))
		{
			amount *= 10; 
		}
		else if(unitOne.contains("Milli") && unitTwo.contains("Deci"))
		{
			amount /= 100; 
		}
		else if(unitOne.contains("Deci") && unitTwo.contains("Milli"))
		{
			amount *= 100; 
		}
		else if(unitOne.contains("Micro") && unitTwo.contains("Deci"))
		{
			amount /= 100000; 
		}
		else if(unitOne.contains("Deci") && unitTwo.contains("Micro"))
		{
			amount *= 100000; 
		}
		
		else if(unitOne.contains("Milli") && unitTwo.contains("Centi"))
		{
			amount /= 10; 
		}
		else if(unitOne.contains("Centi") && unitTwo.contains("Milli"))
		{
			amount *= 10; 
		}
		else if(unitOne.contains("Micro") && unitTwo.contains("Centi"))
		{
			amount /= 10000; 
		}
		else if(unitOne.contains("Centi") && unitTwo.contains("Micro"))
		{
			amount *= 10000; 
		}
		
		else if(unitOne.contains("Micro") && unitTwo.contains("Milli"))
		{
			amount /= 1000; 
		}
		else if(unitOne.contains("Milli") && unitTwo.contains("Micro"))
		{
			amount *= 1000; 
		}
		else if(unitOne.contains("Kilo"))
		{
			amount /= 1000;
		}
		else if(unitOne.contains("Deci"))
		{
			amount *= 10;
		}
		else if(unitOne.contains("Centi"))
		{
			amount *= 100;
		}
		else if(unitOne.contains("Milli"))
		{
			amount *= 1000;
		}
		else if(unitOne.contains("Micro"))
		{
			amount *= 1000000;
		}
		
		else if(unitTwo.contains("Kilo"))
		{
			amount /= 1000;
		}
		else if(unitTwo.contains("Deci"))
		{
			amount *= 10;
		}
		else if(unitTwo.contains("Centi"))
		{
			amount *= 100;
		}
		else if(unitTwo.contains("Milli"))
		{
			amount *= 1000;
		}
		else if(unitTwo.contains("Micro"))
		{
			amount *= 1000000;
		}
		switch(measurementType)
		{
		case "Length":
			
			//--------------English System To English System below-------------------------------------
			
			//Converts feet to inches 
			if(unitOne.equals("Foot") && unitTwo.equals("Inch"))
			{
				amount *= 12;
			}
			//Converts inches to feet
			else if(unitOne.equals("Inch") && unitTwo.equals("Foot"))
			{
				amount /= 12;
			}
			
			if(unitOne.equals("Yard") && unitTwo.equals("Inch"))
			{
				amount *= 3;
				amount *= 12;
			}
			//Converts inches to yard
			else if(unitOne.equals("Inch") && unitTwo.equals("Yard"))
			{
				amount /= 12;
				amount /= 3;
			}
			
			if(unitOne.equals("Mile") && unitTwo.equals("Inch"))
			{
				amount *= 12;
				amount *= 5280;
			}
			//Converts inches to mile
			else if(unitOne.equals("Inch") && unitTwo.equals("Mile"))
			{
				amount /= 12;
				amount /= 5280;
			}
			
			//-----------End of inch conversion----------------
			
			
			
			if(unitOne.equals("Foot") && unitTwo.equals("Yard"))
			{
				amount /= 3;
			}
			else if(unitOne.equals("Yard") && unitTwo.equals("Foot"))
			{
				amount *= 3;
			}
			
			if(unitOne.equals("Foot") && unitTwo.equals("Mile"))
			{
				amount /= 5280;
			}
			else if(unitOne.equals("Mile") && unitTwo.equals("Foot"))
			{
				amount *= 5280;
			}

			if(unitOne.equals("Yard") && unitTwo.equals("Mile"))
			{
				amount /= 1760;
			}
			else if(unitOne.equals("Mile") && unitTwo.equals("Yard"))
			{
				amount *= 1760;
			}
			
			if(unitOne.equals("Inch") && unitTwo.contains("Meter"))
			{
				amount *= 0.0254;
			}
			else if(unitOne.contains("Meter") && unitTwo.equals("Inch"))
			{
				amount /= 0.0254;
			}
			if(unitOne.equals("Foot") && unitTwo.contains("Meter"))
			{
				amount *= 0.0254 * 12;
			}
			else if(unitOne.contains("Meter") && unitTwo.equals("Foot"))
			{
				amount /= 0.0254 * 12;
			}
			if(unitOne.equals("Yard") && unitTwo.contains("Meter"))
			{
				amount *= 0.0254 * 12 * 3;
			}
			else if(unitOne.contains("Meter") && unitTwo.equals("Yard"))
			{
				amount /= 0.0254 * 12 * 3;
			}
			if(unitOne.equals("Mile") && unitTwo.contains("Meter"))
			{
				amount *= 0.0254 * 12 * 3 * 1760;
			}
			else if(unitOne.contains("Meter") && unitTwo.equals("Mile"))
			{
				amount /= 0.0254 * 12 * 3 * 1760;
			}
			break;
			
		case "Mass":
			if(unitOne.equals("Pound") && unitTwo.equals("Ton"))
			{
				amount /= 2000;
			}
			else if(unitOne.equals("Ton") && unitTwo.equals("Pound"))
			{
				amount *= 2000;
			}
			else if(unitOne.equals("Pound") && unitTwo.contains("Gram"))
			{
				amount *= 453.592;
			}
			else if(unitOne.equals("Gram") && unitTwo.contains("Pound"))
			{
				amount /= 453.592;
			}
			else if(unitOne.equals("Ton") && unitTwo.contains("Gram"))
			{
				amount *= 453.592 / 2000;
			}
			else if(unitOne.contains("Gram") && unitTwo.equals("Ton"))
			{
				amount /= 453.592 * 2000;
			}
			break;
			
		case "Volume":

			if(unitOne.equals("Pint") && unitTwo.equals("Cup"))
			{
				amount *= 2;
			}
			else if(unitOne.equals("Cup") && unitTwo.equals("Pint"))
			{
				amount /= 2;
			}
			if(unitOne.equals("Quart") && unitTwo.equals("Cup"))
			{
				amount *= 2;
				amount *= 2;
			}
			else if(unitOne.equals("Cup") && unitTwo.equals("Quart"))
			{
				amount /= 2;
				amount /= 2;
			}
			if(unitOne.equals("Gallon") && unitTwo.equals("Cup"))
			{
				amount *= 2;
				amount *= 2;
				amount *= 4;
			}
			else if(unitOne.equals("Cup") && unitTwo.equals("Gallon"))
			{
				amount /= 2;
				amount /= 2;
				amount /= 4;
			}
			
			if(unitOne.equals("Liter") && unitTwo.equals("Cup"))
			{
				amount /= 0.236588;
			}
			else if(unitOne.equals("Cup") && unitTwo.equals("Liter"))
			{
				amount *= 0.236588;
			}	
			if(unitOne.equals("Pint") && unitTwo.contains("Liter"))
			{
				amount *= 0.473176;
			}
			if(unitOne.contains("Liter") && unitTwo.equals("Pint"))
			{
				amount /= 0.473176;
			}
			if(unitOne.equals("Quart") && unitTwo.contains("Liter"))
			{
				amount *= 0.946353;
			}
			if(unitOne.contains("Liter") && unitTwo.equals("Quart"))
			{
				amount /= 0.946353;
			}
			if(unitOne.equals("Gallon") && unitTwo.contains("Liter"))
			{
				amount *= 3.78541;
			}
			if(unitOne.contains("Liter") && unitTwo.equals("Gallon"))
			{
				amount /= 3.78541;
			}
			break;
			
		case "Time":
			System.out.println("Time");
			return convertTime(unitOne, amount, unitTwo);
		}
		
		return amount;
	}
	
	/**
	 * Converts a time unit to another specified time unit.
	 * @param unitOne the unit converted.
	 * @param amount the amount of the unitOne being provided to conversion.
	 * @param unitTwo the unit we are converting unitOne to.
	 * @return the conversion.
	 */
	static double convertTime(String unitOne, double amount, String unitTwo)
	{
		if(unitOne.equals("Minute") && unitTwo.equals("Second"))
		{
			amount *= 60;
		}
		else if(unitOne.equals("Second") && unitTwo.equals("Minute"))
		{
			amount /= 60;
		}
		
		if(unitOne.equals("Hour") && unitTwo.equals("Second"))
		{
			amount *= 60;
			amount *= 60;
		}
		else if(unitOne.equals("Second") && unitTwo.equals("Hour"))
		{
			amount /= 60;
			amount /= 60;
		}
		if(unitOne.equals("Day") && unitTwo.equals("Second"))
		{
			amount *= 24;
			amount *= 60;
			amount *= 60;
		}
		else if(unitOne.equals("Second") && unitTwo.equals("Day"))
		{
			amount /= 24;
			amount /= 60;
			amount /= 60;
		}
		if(unitOne.equals("Second") && unitTwo.equals("Month"))
		{
			amount /= 60;
			amount /= 60;
			amount /= 24;
			amount /= 30.4368;
		}
		if(unitOne.equals("Month") && unitTwo.equals("Second"))
		{
			amount *= 60;
			amount *= 60;
			amount *= 24;
			amount *= 30.4368;
		}
		if(unitOne.equals("Second") && unitTwo.equals("Year"))
		{
			amount /= 60;
			amount /= 60;
			amount /= 24;
			amount /= 30.4368;
			amount /= 12;
		}
		if(unitOne.equals("Year") && unitTwo.equals("Second"))
		{
			amount *= 60;
			amount *= 60;
			amount *= 24;
			amount *= 30.4368;
			amount *= 12;
		}
		
		if(unitOne.equals("Minute") && unitTwo.equals("Hour"))
		{
			amount *= 60;
		}
		else if(unitOne.equals("Hour") && unitTwo.equals("Minute"))
		{
			amount /= 60;
		}
		if(unitOne.equals("Minute") && unitTwo.equals("Day"))
		{
			amount *= 24;
			amount *= 60;
		}
		else if(unitOne.equals("Day") && unitTwo.equals("Minute"))
		{
			amount /= 24;
			amount /= 60;
		}
		if(unitOne.equals("Minute") && unitTwo.equals("Month"))
		{
			amount /= 60;
			amount /= 24;
			amount /= 30.4368;
		}
		if(unitOne.equals("Month") && unitTwo.equals("Minute"))
		{
			amount *= 60;
			amount *= 24;
			amount *= 30.4368;
		}
		if(unitOne.equals("Minute") && unitTwo.equals("Year"))
		{
			amount /= 60;
			amount /= 24;
			amount /= 30.4368;
			amount /= 12;
		}
		if(unitOne.equals("Year") && unitTwo.equals("Minute"))
		{
			amount *= 60;
			amount *= 24;
			amount *= 30.4368;
			amount *= 12;
		}
		
		if(unitOne.equals("Hour") && unitTwo.equals("Day"))
		{
			amount *= 24;
		}
		else if(unitOne.equals("Day") && unitTwo.equals("Hour"))
		{
			amount /= 24;
		}
		if(unitOne.equals("Day") && unitTwo.equals("Month"))
		{
			amount /= 30.4368;
		}
		if(unitOne.equals("Month") && unitTwo.equals("Day"))
		{
			amount *= 30.4368;
		}
		if(unitOne.equals("Day") && unitTwo.equals("Year"))
		{
			amount /= 30.4368;
			amount /= 12;
		}
		if(unitOne.equals("Year") && unitTwo.equals("Day"))
		{
			amount *= 30.4368;
			amount *= 12;
		}
		
		if(unitOne.equals("Year") && unitTwo.equals("Month"))
		{
			amount /= 12;
		}
		if(unitOne.equals("Month") && unitTwo.equals("Year"))
		{
			amount *= 12;
		}
		return amount;
	}
	
	
}
