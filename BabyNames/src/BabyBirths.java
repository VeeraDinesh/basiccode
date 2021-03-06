import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class BabyBirths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BabyBirths b = new BabyBirths();
		// b.TestotalBirthsSample(); //TotalBirthsample
		 b.testTotalBirths(); //TotalBirths
		// b.testGetRank(); //Rank
		// b.TestgetName(); //getName
		// b.TestWhatNameInyear(); //TestWhatNameInyear
		 //b.testYearOfHighestRank(); //YearOfHighestRank
		// b.TestgetAverageRank();
		//b.TestTotalBirthsRankedHigher(); // TotalBirthsRankedHigher
		
	}

	public void TestotalBirthsSample() {
		FileResource fr = new FileResource();
		totalBirthsSample(fr);
	}

	public void totalBirthsSample(FileResource fr) {

		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			// System.out.println(numBorn);
			// if(numBorn <=100)
			// {
			System.out.println("Name " + rec.get(0) + "  Gender  " + rec.get(1) + "  Num Born  " + rec.get(2));
			// }
		}
	}

	public void totalBirths(FileResource fr) {
		int totalBirths = 0, totalBoys = 0, totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;

			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			} else if(rec.get(1).equals("F")) {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("total births Boys = " + totalBoys);
		System.out.println("total births  Girls = " + totalGirls);
	}

	public void testTotalBirths() {
		FileResource fr = new FileResource();
		totalBirths(fr);
	}

	///////////////////// getRank ////////////////
	public int getRank(int year, String name, String gender) {
		int rank = 0;
		boolean found = false;
		// String fileName = "yob" + year + "short.csv";

		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			if (rec.get(1).equals(gender)) {
				if (rec.get(0).equals(name)) {
					rank += 1;
					found = true;
					break;
				} else {
					rank += 1;
				}
			}

		}

		if (found == true) {
			return rank;
		} else {
			return -1;

		}
	}

	public void testGetRank() {
		int rank = getRank(1971, "Frank", "M");
		System.out.println("RAnk = " + rank);

	}

	////////////////////////// getName ///////////////////////

	public String getName(int year, int rank, String gender) {
		// String fileName = "yob" + year + "short.csv";

		FileResource fr = new FileResource();

		boolean found = false;
		String foundName = null;
		int c = 0;
		// String fileName = "yob" + year + "short.csv";
		for (CSVRecord rec : fr.getCSVParser(false)) {
			if (rec.get(1).equals(gender)) {
				c += 1;
				if (c == rank) {
					foundName = rec.get(0);
					found = true;
					return foundName;

				}
			}
		}

		if (found == true)
			return foundName;
		else
			return "No Name";

	}

	public void TestgetName() {
		String name = getName(1982, 450, "M");
		System.out.println("Name " + name);
		// System.out.println("Name " + getName(2012, 3, "F"));
	}

	///////////////// whatIsNameInYear //////////////
	public void whatIsNameInyear(String name, int year, int newYear, String gender) {
		int rank1 = getRank(year, name, gender);
		System.out.println(rank1);
		String newName = getName(newYear, rank1, gender);
		System.out.println(newName);
		System.out.println(name + " born in  " + year + " would be " + newName + " if he was born in year " + year);

	}

	public void TestWhatNameInyear() {
		whatIsNameInyear("Susan", 1972, 2014, "F");
		whatIsNameInyear("Owen", 1974, 2014, "M");

	}

	////////////////////////// yearOfHighestRank ///////////////
	/*
	 * public int yearOfHighestRank(String name, String gender) { double inf =
	 * Double.POSITIVE_INFINITY; int highestRank = (int) inf; int highestYear = -1;
	 * 
	 * DirectoryResource dr = new DirectoryResource();
	 * 
	 * for (File f : dr.selectedFiles()) { String year = f.getName().substring(3,7);
	 * int rank2 = getRank(Integer.parseInt(year),name,gender); if(rank2 != -1 &&
	 * rank2 <= highestRank) { highestRank = rank2; highestYear =
	 * Integer.parseInt(year);
	 * 
	 * } } return highestYear; }
	 */
	public int yearOfHighestRank(String name, String gender) {
		long highestRank = 0;
		int yearOfHighestRank = -1;
		String fileName = "";
		DirectoryResource dr = new DirectoryResource();

		// Iterate through all files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);

			// Iterate through all records in file
			for (CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);

				if (currName.equals(name) && currGender.equals(gender)) {
					long currRank = record.getRecordNumber();

					if (highestRank == 0) {
						highestRank = currRank;
						fileName = f.getName();
					} else {
						if (highestRank > currRank) {
							highestRank = currRank;
							fileName = f.getName();
						}
					}
				}
			}
		}

		// Remove all non-numeric characters from the filename
		fileName = fileName.replaceAll("[^\\d]", "");

		// Convert String fileName to Integer
		yearOfHighestRank = Integer.parseInt(fileName);

		return yearOfHighestRank;
	}

	public void testYearOfHighestRank() {
		int highestRankedYear = yearOfHighestRank("Mich", "M");
		System.out.println("Highesh Rank is " + highestRankedYear);
	}

	/*
	 * public int yearOfHighestRank(String name, String gender){ double inf =
	 * Double.POSITIVE_INFINITY; int highestRank = (int) inf; int highestYear = -1;
	 * DirectoryResource dr = new DirectoryResource(); // iterate over files for
	 * (File f : dr.selectedFiles()) { String year = f.getName().substring(3, 7);
	 * int rank = getRank(Integer.parseInt(year), name, gender); if (rank != -1 &&
	 * rank <= highestRank){ highestRank = rank; highestYear =
	 * Integer.parseInt(year); } } return highestYear; }
	 */

	public double getAverageRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		int count = 0;
		double avg = 0.0;
		for (File f : dr.selectedFiles()) {

			count++;
			avg += getRank(Integer.parseInt(f.getName()), name, gender);

		}

		return avg / count;
	}

	public void TestgetAverageRank() {
		double averageRank = getAverageRank1("Robert", "M");
		System.out.println("AverageRank " + averageRank);

	}

	public double getAverageRank1(String name, String gender) {
		// Initialize a DirectoryResource
		DirectoryResource dr = new DirectoryResource();
		// Define rankTotal, howMany
		double rankTotal = 0.0;
		int howMany = 0;
		// For every file the directory add name rank to agvRank
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			for (CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);
				if (currName.equals(name) && currGender.equals(gender)) {
					long currRank = record.getRecordNumber();
					rankTotal += (double) currRank;
					howMany += 1;
				}
			}
		}
		// Define avgRank = rankTotal / howMany
		double avgRank = rankTotal / (double) howMany;
		return avgRank;
	}

	///////////////////////// getTotalBirthsRankedHigher1/////////////////
	public int getTotalBirthsRankedHigher(int year, String name, String gender) {
		int numBorn = 0;
		int numBorn2 = 0;
		long rank = getRank(year, name, gender);
		System.out.println("Rank :" + rank);
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);
		for (CSVRecord record : parser) {
			int currBorn = Integer.parseInt(record.get(2));
			String currGender = record.get(1);
			System.out.println("Current Gender : " + currGender);
			long currRank = record.getRecordNumber();
			System.out.println("CurrentRank : " + currRank);
			if (gender.equals("F")) {
				if (gender.equals(currGender) && rank > currRank) {
					numBorn += currBorn;
				}
			}

			else if (gender.equals("M")) {
				long currRank1 = record.getRecordNumber();
				if (gender.equals(currGender) && rank > currRank1) {
					numBorn2 += currBorn;
				}
			}
		}

		return numBorn;
	}

	public void TestTotalBirthsRankedHigher() {
		int RankedHigher = getTotalBirthsRankedHigher1(1990, "Drew", "M");
		System.out.println("Two Ranked higeher than Given name :" + RankedHigher);
	}

	//////////////////////// getTotalBirthsRankedHigher1////////////////////
	public int getTotalBirthsRankedHigher1(int year, String name, String gender) {

		int cnt = 0;
		DirectoryResource dr = new DirectoryResource();

		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			if (rec.get(0).equals(name) && rec.get(1).equals(gender))
				break;
			else if (rec.get(1).equals(gender))
				cnt += Integer.parseInt(rec.get(2));
		}

		return cnt;
	}

}
