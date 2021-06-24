
import edu.duke.*;


public class Part1 {
	 public static void main(String[] args)
	    {
		 Part1 f1 = new Part1();
		 f1.testFindGene();
		 String dna= "xxxyyyzzzTAAxxxyyyzzzTAAxx";
		 f1.testOn(dna);
	    }
	 
	
public int findStopCodon(String dna,int startIndex, String stopCodon){
	//startIndex = dna.indexOf("ATG");
	int currIndex = dna.indexOf(stopCodon, startIndex + 3);
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

public String findGene(String dna, int where)
{
	int atgCodon = dna.indexOf("ATG",where);
	
	if(atgCodon == -1)
	{
		return "NO ATG CODON FOUND";
	}
	int taaCodon = findStopCodon(dna, atgCodon ,"TAA");
	int tagCodon = findStopCodon(dna, atgCodon, "TAG");
	int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
	int tempCodon = Math.min(taaCodon, tagCodon);
	
	int dnaFin = Math.min(tempCodon, tgaCodon);
	
	if(dnaFin == dna.length())
	{
		return "NO GENE FOUND";
	}
	return dna.substring(atgCodon,dnaFin+3);
}


public void testFindGene()
{  //             01234567890123456789012345               
	String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
	int dex = findStopCodon(dna,0,"TAA");
	if(dex != 10 )System.out.println("error on 9");
	dex = findStopCodon(dna,9,"TAA");
	if(dex != 21 )System.out.println("error on 21");
	dex = findStopCodon(dna,1,"TAA");
	if(dex != 26 )System.out.println("error on 26");
	dex = findStopCodon(dna,0,"TAG");
	if(dex != 26)System.out.println("error on 26 TAG");
System.out.println("Test Finished");


 String dna1 = "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
// String gene = findGene(dna1);
// System.out.println(gene);
}

public void printAllGenes(String dna)
{
	int startIndex = 0;
	while(true)
		{
		String currentGene = findGene(dna,startIndex);
		if(currentGene.isEmpty())
		{
			break;
		}
		System.out.println(currentGene);
		startIndex = dna.indexOf(currentGene,startIndex) + currentGene.length();
		System.out.println(startIndex);
		}
	}

public StorageResource getAllGenes(String dna){
   // String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa"; 
  //  dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
 //   dna = "AGDEGAASZZATAAAAA";
	StorageResource geneList = new StorageResource();
	int startIndex = 0;
    while (true) {
    	String currentGene = findGene(dna,startIndex);
    	if(currentGene.isEmpty())
    	{
    		break;
    	}
    	geneList.add(currentGene);//It adds gene one by one from currentGene
        System.out.println(currentGene);
        startIndex = dna.indexOf(currentGene, startIndex) + 
                currentGene.length();
    }
	return geneList;
}

public void testOn(String dna)
{
	System.out.println("Testing printAllgenes on "+ dna);
StorageResource genes = getAllGenes(dna);
for(String gene : genes.data())
{
	System.out.println("This is the list of genes: "+ gene);}
}

}
	
	


