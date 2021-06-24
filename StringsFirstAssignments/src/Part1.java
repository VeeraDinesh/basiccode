
public class Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part1 p=new Part1();
		p.testFindSimpleGene();

	}

	public static  String findSimpleGene(String dna)
	{
		String result = "";
		int startIndex = dna.toUpperCase().indexOf("ATG");
		System.out.println(startIndex);
		int stopIndex = dna.toUpperCase().indexOf("TAA", startIndex + 3);
		System.out.println(stopIndex);
		if(startIndex == -1 || stopIndex == -1) {
			 return "";
			}
		result = dna.substring(startIndex, stopIndex+3);
		
		return result;
	}
	public void testFindSimpleGene() {
		String dna = "AAATGCCCTAACTAGATTAAGAAACC";
		System.out.println("DNA strand is " + dna);
		String gene = findSimpleGene(dna);
		System.out.println("Gene is " + gene +"\n");
		
		 dna = "AATGCTAGGGTAATATGGT";
		System.out.println("DNA strand is " + dna);
	     gene = findSimpleGene(dna);
		System.out.println("Gene is " + gene +"\n");
		
		dna = "ATCCTCTTCGGCTGCTCTATGGT"; //NO ATG or TAA
		System.out.println("DNA strand is " + dna);
	     gene = findSimpleGene(dna);
		System.out.println("Gene is " + gene +"\n");
		
		 dna = "ACTAGGGTATATGGTAA"; //NO ATG
			System.out.println("DNA strand is " + dna);
		     gene = findSimpleGene(dna);
			System.out.println("Gene is " + gene +"\n");
			
			 dna = "ATGCTAGGG";  // NO TAA
				System.out.println("DNA strand is " + dna);
			     gene = findSimpleGene(dna);
				System.out.println("Gene is " + gene +"\n");
				
				dna = "ATGCTTAA";  // NO TAA
				System.out.println("DNA strand is " + dna);
			     gene = findSimpleGene(dna);
				System.out.println("Gene is " + gene +"\n");
	}
}
