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
 *  Assignment: 2
 *  Problem:  What is the running time of each method implemented?
 *  
 *  Description: 
 *  	Create a starbucks line that enqueue and dequeue a customer on the line. 
 *  Add methods that will check if a specific item is on the list and if the line is empty.
 *  Test all four operations on a main class. 
 *  Compute the Big O running time of each methods.
 *  
 *  Input: Strings
 *  Output: LinkedList
 *
 *  Visible data fields:
 *  Queue<String> starbucks and String name
 *
 *  Visible methods:
 *  enqueue, dequeue, inQueue, toString, isEmpty 
 *
 *   Remarks
 *   -------
 *   In Queue.java. 
 *
 */

public class testQueue {
	
	public static void main(String[]args) {
		
		Queue<String> starbucks = new Queue<String>();
	
		starbucks.enqueue("Elysha");
		starbucks.enqueue("Conor");
		starbucks.enqueue("Marcus");
		starbucks.enqueue("Laurie");
		System.out.println(starbucks.toString() + "\n");
	
		System.out.println("Elysha is getting out of the line.");
		starbucks.dequeue();
		System.out.println(starbucks.toString() + "\n");
		
		System.out.println("Conor is getting out of the line.");
		starbucks.dequeue();
		System.out.println(starbucks.toString() + "\n");

		starbucks.isEmpty();
		System.out.println(starbucks.toString() + "\n");
		
		starbucks.inQueue("Marcus");
		System.out.println(starbucks.toString() + "\n");
		
		starbucks.inQueue("Anthony");
		System.out.println(starbucks.toString() + "\n");
		
		System.out.println("Marcus and Laurie are getting out of the line.");
		starbucks.dequeue();
		starbucks.dequeue();

		starbucks.isEmpty();	
		System.out.println(starbucks.toString() + "\n");
	}
	
}
