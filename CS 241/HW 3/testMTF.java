
/*
 * 	Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Angela Bonsol, Marcus Wong, Conor Sullivan
 *  Collaborators: None
 *  References: Java:Software Solutions Foundations of Program Design 9th Edition by Lewis/Loftus
 *  				
 *  Assignment: 3
 *  Problem: Does your methods in MovetoFront.java work?
 *  
 *  Description: 
 * 	This is a main class to test MoveToFront.java. It allows the user 
 * 	to choose if they want to add, remove, check to see if a certain 
 * 	item is present, or if the collection is empty. We used a while loop 
 * 	to constantly keep asking the user for more actions for the collection.
 * 	This class tests all methods used in MoveToFront.java. 
 *  
 *  Input: String answer, String addItem, String checkItem
 *  Output: String
 *
 *  Visible data fields:
 *  LinkedList<T> line, final int loop, String answer, String addItem, String checkItem, and T item
 *
 *  Visible methods:
 *  public void push, public T pop, public boolean contains,
 *  public boolean isEmpty, public StringtoString
 *  
 *   Remarks
 *   -------
 * 	The big-O running time for the push method in LinkedList would be O(N) 
 *	with the removing previous occurrences, because it contains the contain 
 *	method which would have to go through the list to find any duplicates.
 *	However, for ArrayList, the big-O running time for the push method would 
 *	be O(N), because it contains the contain method, and it would have to 
 *	shift all the elements after a new element is added. O(N) + O(N) = O(N)
 *
 *  The big-O running time for the pop method in LinkedList would be O(1), 
 *  because elements are linked together, they won't have to move. 
 *  However, for ArrayList, the big-O running time for the pop method would be O(N), 
 *  because every element on the list would have to shift back. 
 *  
 *  The big-O running time for the contains method would be O(1) in the ArrayList and O(N) in the LinkedList.
 *  
 *  The big-O running time for the isEmpty method in both the LinkedList and the ArrayList would be O(1).
 *
 */

import java.util.*;

public class testMTF {
	public static void main(String[] args) {
		// tests all operations of the MoveToFront.java
		MoveToFront<String> collection = new MoveToFront<String>();
		Scanner scan = new Scanner(System.in);
		final int loop = 1;

		while (loop == 1) {
			System.out.println(
					"What would you like to do? (1-4) \n1:Add \n2:Remove \n3:Check if an item is presence \n4:Check if its empty");
			String answer = scan.nextLine();

			if (answer.equals("1")) {
				System.out.println("Enter the item you want to add:");
				String addItem = scan.nextLine();
				collection.push(addItem);
			}

			else if (answer.equals("2")) {
				collection.pop();
				System.out.println("An item has been removed.");
			}

			else if (answer.equals("3")) {
				System.out.println("Enter the item you want to check:");
				String checkItem = scan.nextLine();
				if (collection.contains(checkItem) == true)
					System.out.println(checkItem + " is in the collection");
				else
					System.out.println(checkItem + " is NOT in the collection");
			}

			else if (answer.equals("4")) {
				if (collection.isEmpty() == true)
					System.out.println("The collection is empty");
				else
					System.out.println("The collection is NOT empty");
			}

			else {
				System.out.println("Not an option. Enter another number.");
			}
			System.out.println(collection.toString());
		}

	}

}
