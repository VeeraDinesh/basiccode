
public class HowManyGenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HowManyGenes h1 =new HowManyGenes();
		h1.testCountGenes();
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
			return dna.length();
			

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
			/*String dna= "AGDEGAASZZATAAAAA";
		     System.out.println("The dna string is :" + dna);	
		     String gene = findGene(dna);
		    // System.out.println("Gene found is :" + gene);

		     
		     
		       dna= "ATGCCTCTTGAGCTGCTCTATGGGTTGAATGCCCTAG";
		        System.out.println("The dna string is :" + dna);
		        gene = findGene(dna);
		        System.out.println("Gene found is :" + gene);*/
			
		}
		
		public void countGene(String dna)
		{
			int startIndex = 0;
			while(true)
			{
				 String wholeGene = findGene(dna);
		            if (wholeGene.isEmpty()){
		                break;
		            }
		            System.out.println("Gene found: " + wholeGene);
		            startIndex = dna.indexOf(wholeGene,startIndex)+wholeGene.length();
		break;
			}
		}
			public void testCountGenes(){
		        String dna1= "ATGATCTAATTTATGaaaaaaaaaTGAAGA";
		        System.out.println("I should find 2 and found these amount of genes:" + dna1 );
		        countGene(dna1);
		        
		        dna1= "ATGTAGATGTAAATGTAA";
		        System.out.println("I should find 3 and found these amount of genes:" + dna1);
		        countGene(dna1);

			}
		
}
