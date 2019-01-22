/*
 * 	Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Angela Bonsol, Marcus Wong, Conor Sullivan
 *  Collaborators: None
 *  References: Java:Software Solutions Foundations of Program Design 9th Edition by Lewis/Loftus
 *  				Assignment #2 
 *  				
 *  Assignment: 3
 *  Problem: How to implement a collection of items, in LIFO Order, using LinkedList<T>?
 *  
 *  Description: 
 *  This class contains the 5 methods: push, pop, contains, isEmpty, and toString. 
 *  The push method adds a certain item on the front of the collection and removes 
 *  if the item has a duplicate in the collection. 
 *  The pop method removes an item on the front of the collection.
 *  The contains method checks to see if a certain item is present in the collection, returning true or false.
 *  The isEmpty method checks to see if the collection is empty, returning true or false.
 *  The toString method displays the present items in the collection.
 *  		
 *  LIFO (Last-In, First-Out) order
 * 	similar to a Stack but without duplicates 
 *  
 *  Input: N/A
 *  Output: N/A
 *
 *  Visible data fields:
 *  LinkedList<T> line and T item
 *
 *  Visible methods:
 *  public void push, public void pop, public boolean contains,
 *  public boolean isEmpty, public String toString
 * 
 *   Remarks
 *   -------
 *	The big-O running time for the push method in LinkedList would be O(N) 
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

import java.util.LinkedList;

public class MoveToFront<T> {

	LinkedList<T> collection = new LinkedList<T>();

	// adds an item to the collection, removing previous occurences
	public void push(T item) {
		if (contains(item))	// removes previous occurences
			collection.remove(collection.indexOf(item));
		collection.add(item);
	}

	// removes the item added the latest to the collection
	public void pop() {
		collection.removeLast();
	} 

	// returns true if a given item is in the collection, or false otherwise
	public boolean contains(T item) {
		return collection.contains(item);
	}

	// returns true if the collection is empty, or false otherwise
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	// prints out the collection 
	@Override
	public String toString() {
		String result = collection.toString();
		return result;
	}

}
