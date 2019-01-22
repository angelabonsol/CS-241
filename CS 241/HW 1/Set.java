/*
 *   Pace University
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
 *  Input: N/A
 *  Output: N/A
 *
 *  Visible data fields:
 *  LinkedList<T> list
 *
 *  Visible methods:
 *  add, delete, membership, toString, IsEmpty
 *
 *
 *   Remarks
 *   -------
 *	 3)
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

import java.util.LinkedList;

public class Set<T>{
	
	// data 
		LinkedList <T> list = new LinkedList<T>(); 
		// default constructor 
		//other methods 

	//add 	
		public void add (T item){
			// if (list == null)	 list = new Linked List<T>();
				if (list.contains(item)== false)
					list.add(item);
		}

	//remove 
		public void remove(T item) {
			if (list.contains(item)== true)
				list.remove(item);
		}
		
	//membership 
		public boolean membership(T item) {
			if (list.contains(item)== true)
				return true;
			else 
				return false;
		}
		
	//toString 
		public String toString() {
			return list.toString();
		}

	//isEmpty 
		public boolean isEmpty(T item) {
			if(list == null)
				return true;
			else
				return false;
		}	
	}
