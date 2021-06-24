
public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Part3 pr1 = new Part3();
pr1.testing();
pr1.testingLastPart();
	}
	
	
	public boolean twoOccurrences(String stringa,String stringb){
		int occurrence = stringb.indexOf(stringa);
		System.out.println(occurrence);
		if(occurrence == -1)
		{
			return false;
		}
		else {
			System.out.println("occurrence= "+occurrence);
			return true;
		}
		
	}
	
	public String lastPart(String stringa,String stringb)
	{
		int occurrence = stringb.indexOf(stringa);
		int startFrom = stringa.length();
		System.out.println(startFrom);
		String finalPart = stringb.substring(startFrom + occurrence);
		if(occurrence == -1)
		{
			return stringa;
			
		}
		else {
			return finalPart;
		}
	}
	
	
	public void testing()
	{
		String stringa = "by";
		String stringb = "A story by Abby Long";
		System.out.println("stringa ="+ stringa + "and stringb = "+ stringb);
		System.out.println(twoOccurrences(stringa,stringb));
		//System.out.println(lastPart(stringa,stringb));
		
	}

	public void testingLastPart()
	{
		String stringa = "an";
		String stringb = "banana";
		System.out.println("The part of the string after " + stringa + "in " + stringb +" is "+lastPart(stringa,stringb));
		
		stringa = "rest";
		 stringb = "deforestation";
		System.out.println("The part of the string after " + stringa + "in " + stringb +" is "+lastPart(stringa,stringb));
	}
}
