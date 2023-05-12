package t3;



public class Twoadt {
	    //variables to store the stacks and their top elements
	    private int[] stackadt;
	    private int tr;
	    private int tb;
        //constructor to initialize the stacks
	    public Twoadt(int size) {
	        stackadt = new int[size];
	        tr = -1;
	        tb = size;
	    }
	 //method to push element onto stack
     public void elementpush(String color,int elem)
     {
     	//check if there is space left 
     	if (tb-1==tr) {
             throw new IllegalStateException("Stacks are full");
         }
     	 //push element into appropriate stack based on color
         if (color.equals("red")) {
             stackadt[++tr] = elem;
         } else if (color.equals("blue")) {
             stackadt[--tb] = elem;
         } else {
             throw new IllegalArgumentException("Invalid color");
         }
     	
     	
     }
     
     //method to pop element from stacks
     public int elementpop(String color) {
    	 //check if red stack is empty
	        if (tr == -1 && color.equals("red") ) {
	            throw new IllegalStateException("Red stack is empty");
	        }
	        //pop red
	        else if(tr != -1 && color.equals("red")) {
	              return stackadt[tr--];
         }
	        //check if blue stack is empty 
         else if(tb == stackadt.length && color.equals("blue"))
         {
         	throw new IllegalStateException("Blue stack is empty");
         }
	        //pop blue
         else if(tb != stackadt.length && color.equals("blue"))
         {
         	 return stackadt[tb++];
         }
	        //throw exception if color is not red or blue
         else
         {
         	throw new IllegalArgumentException("Invalid color");
         }
     
	    }
  // Method to peek at the top element of one of the stacks
     public int elementpeek(String color)
     {
    	//check if red stack is empty
     	 if (tr == -1 && color.equals("red") ) {
	            throw new IllegalStateException("Red stack is empty");
	           }
     	 //return element at red top
     	 else if(tr != -1 && color.equals("red")) {
     		 return stackadt[tr];
           }
     	//check if blue stack is empty
     	 if (tb == stackadt.length && color.equals("blue")) {
	            throw new IllegalStateException("Blue stack is empty");
	         }
     	 //return element at blue top
     	 else if(tb != stackadt.length && color.equals("blue"))
          {
          	 return stackadt[tb];
          }
     	//throw exception if color is not red or blue
     	 else
          {
          	throw new IllegalArgumentException("Invalid color");
          }
     	 
     	 
	        
     }
     // Method to check if one of the stacks is empty
     public boolean checkemp(String color)
     {
    	//check blue 
     	if(color.equals("blue"))
     	{
     		return tb == stackadt.length;
     	}
     	//check red
     	else if(color.equals("red"))
     	{
     		return tr == -1;
     	}
     	else
     	{
     		throw new IllegalArgumentException("Invalid color");
     	}
     }
//	    
//
//
	    public static void main(String args[])
		{
			Twoadt tk = new Twoadt(5);
			tk.elementpush("red",2);
			tk.elementpush("red",3);
			tk.elementpush("blue",9);
			tk.elementpush("blue",4);
			
			System.out.println("Peek element at the  blue stack : "
							 + tk.elementpeek("blue"));
			
			System.out.println("Peek element at the red stack: "
							 + tk.elementpeek("red"));
			System.out.println("Pop element from the red stack: "
					 + tk.elementpop("red"));
	
	        System.out.println("Peek element after popping from blue stack: "
					+ tk.elementpeek("red"));
			
		}
	    
}


