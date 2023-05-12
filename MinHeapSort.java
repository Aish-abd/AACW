package heap;

import java.util.Arrays;

public class MinHeapSort {

	public static void sortarr(int[] heapminar) {
//	  
        makeminh(heapminar);
	    // iterate and add the root at the end 
	    for (int i = heapminar.length - 1; i >= 0; i--) {
	       
	       interchange(heapminar,0,i);

	      // use the minimum heap method
	      minheapiFy(heapminar, i, 0);
	    }
	  }
	
	private static void makeminh(int[] arr) {
	    int l=arr.length;
	    for (int i = l/2 - 1; i >= 0; i--) {
	        minheapiFy(arr,l,i);
	    }
	}
	//swap elements 
	private static void interchange(int arr[],int first,int second)
	{
		int swap=arr[first];
		arr[first]=arr[second];
		arr[second]=swap;
	}
	//using minimum heap sort array 
	public static void minheapiFy(int arr[],int size,int ind)
	{
//		
//	    //left child
		int childleftindex=(ind*2+1);
		//right child
		int childrindex=(ind*2)+2;
		//store root as minimum element
		int min=ind;
		//check if left child is smaller than root
		if(childleftindex<size  && arr[childleftindex]<arr[min])
		{
			min=childleftindex;
		}
		//check if right child is smaller than current minimum
		if(childrindex<size && arr[childrindex]<arr[min])
		{
			min=childrindex;
		}
		//if root is not minimum swap root with minimum
		if(min!=ind)
		{
			
			interchange(arr,ind,min);
			
//			
			minheapiFy(arr,size,min);
		}
		
		
	}
		public static void main(String[] args) {
			//array to be sorted
		    int[] samplear = {2, 0, 9, -5, 8, 3};
            //print array output before sorting using min heap 
		    System.out.println("The array before minheapsort: "+Arrays.toString(samplear));
		   //sort using heap
		    MinHeapSort.sortarr(samplear);
           //print array output after sorting using min heap
		    System.out.println("The array after minheapsort: "+Arrays.toString(samplear));
		    
    }
	
	
	
	

}
