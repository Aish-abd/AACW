package duplicate;


import java.util.*;

public class RemoveSimilar {
	
	public static void removedup(char befarr[],int s)
	{
		
		//sort the array
		Arrays.sort(befarr);
		//create list to store non-repeated elements
		List<Character> l= new ArrayList<>();
	
	    int j=0;
	 // Iterate through the sorted array
		for(int i=0;i<s-1;i++)
		{
			// check if the current character is not equal to the next character
			if(befarr[i]!=befarr[i+1])
			{
				//add it to the list if it is
				l.add(befarr[i]);
			}
			j++;
		}
		// Add the last character to the list
		l.add(befarr[j]);
		
		//print the list
		System.out.println(l);
		
	}
	
	public static void main(String args[])
	{
		// Create an array of characters with duplicates
		char arr1[]= {'a','b','a','d','b','c'};
		// Print original array
		System.out.println("Array before duplicates: "+Arrays.toString(arr1));
		int size=arr1.length;
		System.out.print("Arrays after removing duplicates:");
		// Call the removedup method to remove duplicates
		removedup(arr1,size);

		
		
	}
	



}
