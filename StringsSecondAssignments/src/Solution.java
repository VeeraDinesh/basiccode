import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name= "    Java Programming";

		
		
		System.out.println(name.trim());
		
		
	    // creating a char array
		for(char c : name.toCharArray()) {

		      // access each character
		      System.out.print(c + ", ");
		    }
	}
	

}

