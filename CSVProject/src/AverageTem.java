import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class AverageTem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AverageTem avg = new AverageTem();
		//avg.testAverageTemperatureInFile();
		avg.testAverageTemperatureWithHighHumidityInFile();
	}
	
	//////////////////////////////////  averageTemperatureInFile ////////////////////////
public double  averageTemperatureInFile(CSVParser parser)
{
	double avgTemp = 0;
	int count = 0;
	for(CSVRecord p : parser)
	{
		count++;
		avgTemp+=Double.parseDouble(p.get("TemperatureF"));
	}
	
	return (avgTemp/count);
	
}

public void testAverageTemperatureInFile()
{
	FileResource fr = new FileResource();
	CSVParser parser = fr.getCSVParser();
	double csv = averageTemperatureInFile(parser);
	
	System.out.println("Average temperature in file is "+csv);
	}


//////////////////////////// averageTemperatureWithHighHumidityInFile  /////////////////////

public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
{
	double sum =0;
	double avgTemp = 0;
	int count = 0;
	for(CSVRecord p : parser)
	{
		double currentHumidity = Double.parseDouble(p.get("Humidity"));
		double currentTemp = Double.parseDouble(p.get("TemperatureF"));
		if(currentHumidity>=value){
            sum += currentTemp;
            avgTemp =sum/count;
            count++;
        }
		/*count++;
		try {
		if(p.get("Humidity").equals("N/A")== false)
		{
			if(Double.parseDouble(p.get("Humidity")) >= value)
			{
				
		avgTemp+=Double.parseDouble(p.get("TemperatureF"));
	}
		}
	}catch(Exception e) {
		e.printStackTrace();
	
	}*/
	//double avg = (avgTemp/count);
	
	
	}
	return avgTemp;
}
public void testAverageTemperatureWithHighHumidityInFile()
{
	FileResource fr = new FileResource();
	CSVParser parser =null;
	
	try {
		parser =  fr.getCSVParser();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	double csv = averageTemperatureWithHighHumidityInFile(parser,80);
	
	//System.out.println("Average Temp when high Humidity "+csv);
	if(csv == 0) {
		System.out.println("No temperatures with that humidity");
	}else {
		System.out.println("Average Temp when high Humidity is: "+csv);
	}
	
	}


}
