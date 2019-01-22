/*
 *  Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Angela Bonsol, Marcus Wong, Conor Sullivan
 *  Collaborators: None
 *  References: Java:Software Solutions Foundations of Program Design 9th Edition by Lewis/Loftus
 *  				http://www.csc.villanova.edu/~helwig/BigOLinkedListVsArrayList.doc
 *
 *  Assignment: 1
 *  Problem: Implement a LinkedList containing a set of generic types
 *  Running Time of LinkedList v. ArrayList
 *  
 *  Description: Implementing a generic class Set⟨T⟩ that maintains a set of items of generic type T using the class LinkedList⟨T⟩.
 *  The Set class provides an add method, delete method, membership method and a ToString method to interact with the items in the set.
 *  We also implement a testSet class with a main method to test each operation in the Set Class
 *  Then we explain whether or not if implementing an ArrayList would have been better than a LinkedList using the big-O run time.
 *  
 *  Input: integers and strings
 *  Output: LinkedList
 *
 *  Visible data fields:
 *  Set<Integer> list, final int repeat, String choice, Integer num
 *
 *  Visible methods:
 *  add, delete, membership, toString, IsEmpty
 *
 *   Remarks
 *   -------
 *	  3)
 *  The add method that we used in each list inserts a new item at the end of this list 
 *  if the list does not contain so already, using the contains method, which runs in O(n). 
 *  Therefore, the big-O run time is O(n) for the Linked List we had created. Meanwhile, 
 *  for ArrayList, it runs in O(1) if we were to add a new item at the end of the list. 
 *  
 *  The delete method in the unsorted ArrayList and LinkedList differ from each other 
 *  because in the LinkdList, our delete method finds the target item to place a current 
 *  at the item to be deleted and uses the current to remove item. The big-O run time for 
 *  that method would be O(n) + O(1) which ends up to be O(n). While the unsorted ArrayList 
 *  finds the target item to delete and moves the target up or down. The big-O run time for 
 *  that method would be O(n) + O(n) which ends up to be O(n). Although the ArrayList and 
 *  LinkedList uses different steps to delete an item, the big-O run time remains the same. 
 *  
 *  The last two methods, the ToString method and the membership method,for both ArrayList 
 *  and LinkedList, both run in O(n). The membership method an if-else statement (O(1)) 
 *  that if the list contains item, using the contains method(O(n)), it would return true. 
 *  The ToString method, which prints out the items of the list, run in O(n) because it goes 
 *  through each element on the list, which are the same for both LinkedList and ArrayList. 
 *  
 *  Therefore implementing an ArrayList would only be better than LinkedList depending on 
 *  what we use the data structure for because ArrayList only takes less time when it comes 
 *  to inserting at the end of the list, otherwise, both List run almost the same. 
 *
 */
import java.util.Scanner; 

public class testSet {
	
	public static void main(String[]args) {

		Set<Integer> list = new Set<Integer>();
		Scanner scan = new Scanner(System.in);
		final int repeat= 0;
		
		//adds integers into the LinkedList
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		//prints the integers in the list
		System.out.println("Integers in the List:" + list.toString());
		
		do {  
			//asks user if they want to add or delete
			System.out.println("Would you like to add or delete?");
	        String choice = scan.next();
	       //add method
	        		if (choice.equalsIgnoreCase("add")) {
	        			System.out.println("Enter the integer you want to add:");
	       //scans input 			
	        			Integer num =scan.nextInt();
	       //membership check
	        			if (list.membership(num) == true)
	       //outputs if present
	        				System.out.println("Integer is already present.");
	       //adds number if not present
	        			else
	        				list.add(num);
	        		}
	       //delete method	
	        		else if (choice.equalsIgnoreCase("delete")) {
	        			System.out.println("Enter the integer you want to delete:");
	       //scans input 			
	        			Integer num = scan.nextInt();
	       //membership check 			
	        			if (list.membership(num) == false)
	       //output if not present 				
	        				System.out.println("Integer is not on the list.");
	       //delete number if present 			
	        			else 
	        				list.remove(num);
	        		}
	       //outputs list after add/delete method
	        System.out.println("\nUpdated List:" + list.toString());
	        
	       }
		   //loops
	        while (repeat==0);	
	}
}