package duplicate;

import java.util.Arrays;
public class CheckSame {
    //function to check whether they have same set of numbers
	public static boolean samenum(int[] check1, int[] check2) {
		//sort both of the arrays
		Arrays.sort(check1);
		Arrays.sort(check2);
		//check for equality
		return Arrays.equals(check1, check2);
		
		
	}
	public static void main(String args[])
	{
		int ch1[]= {1,3,4,1,7,8};
		
		int ch2[]= {1,3,4,1,7,8};
		//print out the result of whether the arrays have same numbers
		System.out.println(samenum(ch1,ch2));
		
		
		
	}


}
