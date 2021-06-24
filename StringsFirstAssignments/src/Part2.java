
public class Part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part2 pr = new Part2();
		pr.testFindSimpleGene();

	}

	public static  String findSimpleGene(String dna,String startCodon, String stopCodon)
	{
		String result = "";
		int startIndex = dna.indexOf("ATG");
		System.out.println(startIndex);
		int stopIndex = dna.indexOf("TAA", startIndex + 3);
		System.out.println(stopIndex);
		if(startIndex == -1 && stopIndex == -1) {
			 return "There is no ATG or TAA strand";
			}
		if(startIndex == -1)
		{
			return "There is no ATG strand";
		}
		 if(stopIndex == -1)
		 {
			 return "There is no TAA strand";
		 }
		 else {
			 
			 result = dna.substring(startIndex, stopIndex+3);
			 String resultOrg = result.toLowerCase();
			 int compare = result.length() % 3;
			 if(compare == 0)
			 {
				 return resultOrg;
			 }
			 else {
				 return "no Gene found in upper and lower";
			 }
		 }
		 
		
		
		//return result;
	}
	public void testFindSimpleGene() {
		String dna = "AATGCGATAATATGGT";
		String startCodon ="ATG";
     	String stopCodon = "TAA";
		System.out.println("DNA strand is " + dna);
		String gene = findSimpleGene(dna,startCodon,stopCodon);
		System.out.println("Gene is " + gene +"\n");
	
		 dna = "AATGCTAGGGTAATATGGT";
		 startCodon ="ATG";
	     stopCodon = "TAA";
		System.out.println("DNA strand is " + dna);
	     gene = findSimpleGene(dna,startCodon,stopCodon);
		System.out.println("Gene is " + gene +"\n");
		
		dna = "ATCCTCTTCGGCTGCTCTATGGT"; //NO ATG or TAA
		startCodon ="ATG";
	     stopCodon = "TAA";
		System.out.println("DNA strand is " + dna);
	     gene = findSimpleGene(dna,startCodon,stopCodon);
		System.out.println("Gene is " + gene +"\n");
		
		 dna = "ACTAGGGTATATGGTAA"; //NO ATG
		 startCodon ="ATG";
	     stopCodon = "TAA";
			System.out.println("DNA strand is " + dna);
		     gene = findSimpleGene(dna,startCodon,stopCodon);
			System.out.println("Gene is " + gene +"\n");
			
			 dna = "ATGCTAGGG";  // NO TAA
			 startCodon ="ATG";
		     stopCodon = "TAA";
				System.out.println("DNA strand is " + dna);
			     gene = findSimpleGene(dna,startCodon,stopCodon);
				System.out.println("Gene is " + gene +"\n");
				
				dna = "ATGCTTAA";  // NO TAA
				startCodon ="ATG";
			     stopCodon = "TAA";
				System.out.println("DNA strand is " + dna);
			     gene = findSimpleGene(dna,startCodon,stopCodon);
				System.out.println("Gene is " + gene +"\n");
	}
}

