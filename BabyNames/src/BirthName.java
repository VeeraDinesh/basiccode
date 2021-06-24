import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class BirthName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BirthName br = new BirthName();
br.testGetName();
	}
	public String getName(int year, int rank, String gender){
	  //  String fileName = "yob" + year + "short.csv";
	    FileResource fr = new FileResource();
	    int r = 0;
	    String foundName = null;
	    boolean found = false;
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	         if (rec.get(1).equals(gender)){
	             r += 1;
	             if (r == rank){
	               foundName = rec.get(0);    
	               found = true;
	               break;
	             }
	         }
	    }
	    if (found == true ) return foundName;
	    else return "NO NAME";
	}
	
	public void testGetName(){
	   String name = getName(2012, 2 , "M");
	   System.out.println("Name  = " + name );
	   String name1 = getName(2012, 2 , "F");
	   System.out.println("Name  = " + name1 );
	}
	

}
