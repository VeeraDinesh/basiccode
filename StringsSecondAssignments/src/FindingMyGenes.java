import edu.duke.*;
public class FindingMyGenes {
	
	 public static void main(String[] args)
	    {
		 FindingMyGenes f1 = new FindingMyGenes();
		 f1.testFindGene();
	//	 String dna= "AGDEGAASZZATAAAAA";
		// f1.getAllGenes(dna);
	    }
	 
	 
	 
	public int findStopCodon(String dna,int startIndex, String stopCodon){
	//	startIndex = dna.indexOf("ATG"); //starting by searchin "ATG"
		//
		int currIndex = dna.indexOf(stopCodon, startIndex + 3);
		
		//System.out.println(currIndex);
		while (currIndex != -1)
		{
			int diff = (currIndex - startIndex) % 3;
			if(diff == 0)
			{
				return currIndex;
			}
			else {
				currIndex = dna.indexOf(stopCodon,currIndex +1);
			}
		}
		return startIndex;
		

	}

	public String findGene(String dna)
	{
		int atgCodon = dna.indexOf("ATG");
		System.out.println(atgCodon);
		if(atgCodon == -1)
		{
			return "NO ATG CODON FOUND";
		}
		int taaCodon = findStopCodon(dna, atgCodon ,"TAA");
		//System.out.println(taaCodon);
		int tagCodon = findStopCodon(dna, atgCodon, "TAG");
		//System.out.println(tagCodon);

		int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
		//System.out.println(tgaCodon);

		int tempCodon = Math.min(taaCodon, tagCodon);
		
		int dnaFin = Math.min(tempCodon, tgaCodon);
		
		if(dnaFin == dna.length())
		{
			return "NO GENE FOUND";
		}
		return dna.substring(atgCodon,dnaFin+3);
	}


	public void testFindGene()
	{
		String dna= "AGDEGAASZZATAAAAA";
	     System.out.println("The dna string is :" + dna);	
	     String gene = findGene(dna);
	    // System.out.println("Gene found is :" + gene);

	     
	     
	     dna= "AATGCTAACTAGCTGACTAAT";
	        System.out.println("The dna string is :" + dna);
	        gene = findGene(dna);
	        System.out.println("Gene found is :" + gene);
	        
	    /*    dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
	        System.out.println("The dna string is :" + dna);
	        gene = findGene(dna);
	        System.out.println("Gene found is :" + gene);
	        
	        dna= "aaaaaaATGaaaaaaaaaAAAAaaa";
	        System.out.println("The dna string is :" + dna);
	        gene = findGene(dna);
	        System.out.println("Gene found is :" + gene);
	        
	        
	        
	        dna = "AATGCTAGGGTAATATGGT";
			System.out.println("DNA strand is " + dna);
		     gene = findGene(dna);
			System.out.println("Gene is " + gene +"\n");
			
			dna = "ATCCTCTTCGGCTGCTCTATGGT"; //NO ATG or TAA
			System.out.println("DNA strand is " + dna);
		     gene = findGene(dna);
			System.out.println("Gene is " + gene +"\n"); */

	}

	public StorageResource getAllGenes(String dna){
	   // String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa"; 
	  //  dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
	 //   dna = "AGDEGAASZZATAAAAA";
	    while (true) {
	        System.out.println("printing genes" + findGene(dna));
	        if (findGene(dna).length() == -1) {
	            break;
	        }
	        break;
	    }
		return null;
	}
}
