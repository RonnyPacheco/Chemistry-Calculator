package com.mdc.conversion;

public class UnitConverter {

	enum ConversionKey
	{
		CENTIMETER(2.54);
		
		double value;
		
		private ConversionKey(double value)
		{
			this.value = value;
		}
	}
	
	public static double convert(String unitOne, double amount, String unitTwo)
	{
		switch(unitOne)
		{
		case "Inches":
		case "Foot":
		case "Yard":
		case "Mile":
			String measurementType = "Length";
			return convert(measurementType, unitOne, amount, unitTwo);
		}
		return 0.0;
	}
	
	static double convert(String measurementType, String unitOne, double amount, String unitTwo)
	{
		switch(measurementType)
		{
		case "Length":
			
			if(unitOne.equals("Inch") && unitTwo.equals("Gigameter"))
			{
				amount *= ConversionKey.CENTIMETER.value / 1000000000;
			}
			if(unitOne.equals("Inch") && unitTwo.equals("Megameter"))
			{
				amount *= ConversionKey.CENTIMETER.value / 1000000;
			}
			if(unitOne.equals("Inch") && unitTwo.equals("kilometer"))
			{
				amount *= ConversionKey.CENTIMETER.value / 1000;
			}
			if(unitOne.equals("Inch") && unitTwo.equals("Decimeter"))
			{
				amount *= ConversionKey.CENTIMETER.value / 10;
			}
			else if(unitOne.equals("Inch") && unitTwo.equals("Centimeter"))
			{
				amount *= ConversionKey.CENTIMETER.value;
			}
			else if(unitOne.equals("Inch") && unitTwo.equals("Millimeter"))
			{
				amount *= ConversionKey.CENTIMETER.value * 10;
			}
			else if(unitOne.equals("Inch") && unitTwo.equals("Millimeter"))
			{
				amount *= ConversionKey.CENTIMETER.value * 10;
			}
			
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
			break;
			
		case "Mass":
			if(unitOne.equals("Pound") && unitTwo.equals("ShortTon"))
			{
				amount *= 2000;
			}
			else if(unitOne.equals("ShortTon") && unitTwo.equals("Pound"))
			{
				amount /= 2000;
			}
			break;
		}
		return amount;
	}
	
	double convertTime(String unitOne, double amount, String unitTwo)
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
		
		if(unitOne.equals("Hour") && unitTwo.equals("Day"))
		{
			amount *= 24;
		}
		else if(unitOne.equals("Day") && unitTwo.equals("Hour"))
		{
			amount /= 24;
		}
		return amount;
	}
	
	
}
