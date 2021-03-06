import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class CSVTemparature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVTemparature c1 = new CSVTemparature();
		//c1.testColdestHourInFile();
		c1.testFileWithColdestTemperature();  // (ManyFiles) for whole Year Eg: 2014,2013
       //c1.testLowestHumidityInFile();  // For Particular File
      // c1.testLowestHumidityInManyFiles();//(ManyFiles)  for whole Year Eg: 2014,2013
		
	}
//////////////////////////   coldestHourInFile ///////////////////
	public CSVRecord coldestHourInFile(CSVParser parser)
	{
		CSVRecord smallestSoFar = null;
		
		for(CSVRecord currentRow : parser)
		{
			if(smallestSoFar == null)
			{
				smallestSoFar = currentRow;
			}
			else
			{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
				if(currentTemp < smallestTemp)
				{
					smallestSoFar = currentRow;
				}

			}
			
		}
		return smallestSoFar;
	}
	public void testColdestHourInFile()
	{
		FileResource fr = new FileResource();
		CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
		System.out.println("Coldest  temperature  was "+smallest.get("TemperatureF")+" at " +smallest.get("TimeEST"));
	}
	
	///////////////////////   fileWithColdestTemperature   //////////
	
	public String fileWithColdestTemperature()
	{
		CSVRecord smallestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		
		String coldestFile = "";
		double smallest = 99.9;
		for(File f : dr.selectedFiles())
		{
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			if(smallestSoFar == null)
			{
				smallestSoFar = currentRow;
			}
			else
			{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
				if(currentTemp < smallestTemp)
				{
					smallestSoFar = currentRow;
				}

			}
			 //if smallest returned temp is lower than smallest, get the filename
			
			if(Double.parseDouble(smallestSoFar.get("TemperatureF")) < smallest)
			{
				coldestFile = f.getPath();
			}
			
		}
		return coldestFile;
	}
	
	public void testFileWithColdestTemperature()
	{
	  String coldestFileName = fileWithColdestTemperature();
	  System.out.println("Coldest day from selected files: "+ coldestFileName);
	  FileResource fr1 = new FileResource(coldestFileName);
	  CSVRecord smallestTemp = coldestHourInFile(fr1.getCSVParser());
	  System.out.println("Coldest temperature on that day was "+ smallestTemp.get("TemperatureF"));
	  
	  System.out.println("All the Temperatures on the coldest day were:");
	  
	  for(CSVRecord p : fr1.getCSVParser())
	  {
		  System.out.println(p.get("DateUTC") +": "+ p.get("TemperatureF"));
	  }
	}
	
//////////////////////////////////  lowestHumidityInFile /////////////////////////////	
	public CSVRecord lowestHumidityInFile(CSVParser parser)
	{
		CSVRecord lowestHumSoFar = null;
		for(CSVRecord record : parser)
		{
			lowestHumSoFar = getLowestHumidityOfTwo(lowestHumSoFar,record);
		}
		return lowestHumSoFar;
	}
	
	public CSVRecord getLowestHumidityOfTwo(CSVRecord lowestHumSoFar,CSVRecord currentValue)
	{
		double lowestSoFar = 0, lowcurr = 0;
		if(lowestHumSoFar == null)
		{
			lowestHumSoFar = currentValue;
			
		}
		else {
			// check is temperature in both record not equlas to "N/A"
			if((currentValue.get("Humidity").equals(("N/A")))) {
				System.out.println("N/A");
			}
			else {
				try {
					lowestSoFar = Double.parseDouble(lowestHumSoFar.get("Humidity"));
				lowcurr = Double.parseDouble(currentValue.get("Humidity"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if(lowestSoFar > lowcurr)
				{
					lowestHumSoFar = currentValue;
				}
			}
		}
		return lowestHumSoFar;
		
	}
	
	public void testLowestHumidityInFile()
	{
		FileResource fr = new FileResource();
	CSVParser parser = fr.getCSVParser();
	CSVRecord csv = lowestHumidityInFile(parser);
	
	System.out.println("Lowest Humidity was "+ csv.get("Humidity") + " at " + csv.get("DateUTC"));
	}
	 
	
////////////////////// lowestHumidityInManyFiles ////////////////////	
	
	public CSVRecord lowestHumidityInManyFiles()
	{
		CSVRecord lowestSoFar = null, currentHum = null;
		DirectoryResource dr = new DirectoryResource();
		CSVParser parser;
		for(File r : dr.selectedFiles())
		{
			FileResource fr=new FileResource(r);
			parser=fr.getCSVParser();
			currentHum=lowestHumidityInFile(parser);
			lowestSoFar =getLowestHumidityOfTwo(lowestSoFar,currentHum);
		}
		{
			
		}
		return lowestSoFar;
	}
	
	public void testLowestHumidityInManyFiles()
	{
		CSVRecord lowestSoFar=lowestHumidityInManyFiles();
		System.out.println("Lowest humidity in the file is at "+lowestSoFar.get("Humidity")+" Time is:"+lowestSoFar.get("DateUTC"));
	}
	
}
