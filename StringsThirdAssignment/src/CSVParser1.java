import edu.duke.*;
import org.apache.commons.csv.*;
public class CSVParser1 {

	public static void main(String[] args) {
		CSVParser1 c1 = new CSVParser1();
		c1.Tester();
		
	}
	
	
	public void Tester()
	{
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		countryInfo(parser,"Nauru");
		
		parser = fr.getCSVParser();
		listExportersTwoProduct(parser,"cotton","flowers");
		
		parser = fr.getCSVParser();
		numberofExporters(parser,"cocoa");
		
		parser = fr.getCSVParser();
		bigExporters(parser,"$999,999,999,999");
	//	parser = fr.getCSVParser();
	}
	
	public void countryInfo(CSVParser parser,String country)
	{
		boolean found = false;
		for(CSVRecord record1 : parser)
		{//look at the "Country" column
			String  country_csv = record1.get("Country");
			if(country_csv.contains(country))
			{//look at the "Value (dollars)" column
				String value = record1.get("Value (dollars)");
				System.out.println("Parsing Export Data");
				System.out.println(country + ": " +record1.get("Exports") +": "+value);
				System.out.println(" ");
			found = true;
			}
		}
			 if(!found)
			{
				System.out.println("NOT FOUND");
			}
		
	}
	
	public void listExportersTwoProduct(CSVParser parser,String exportItem1,String exportItem2)
	{
		System.out.println("listExportersTwoProduct ");
		for(CSVRecord r1 : parser )
		{
			//look at the "Exports" column
		String export = r1.get("Exports");
		
		if(export.contains(exportItem1) && export.contains(exportItem2))
		{				

			System.out.println(r1.get("Country"));
		}
		}
	}
	
	public void numberofExporters(CSVParser parser,String exportitem)
	{
		int num = 0;
		for(CSVRecord r2 : parser ) {
			String export = r2.get("Exports");
			if(export.contains(exportitem))
			{
				num++;
			}
		}
		System.out.println("  ");
		System.out.println("How many countries export "+ exportitem + ": "+ num);
		
		System.out.println("  ");

	}
	
	public void bigExporters(CSVParser parser,String totalAmount)
	{
		
		System.out.println(" bigExporters ");
		//String totalAmount = "$999,999,999";
		for(CSVRecord r3 : parser)
		{
			String value = r3.get("Value (dollars)");
			if(value.length() > totalAmount.length())
			{
				
				System.out.println(r3.get("Country")+" "+ value);
			}
		}
	}
}
