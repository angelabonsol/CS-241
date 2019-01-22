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
 *  LinkedList<T> line and T item
 *
 *  Visible methods:
 *  enqueue, dequeue, inQueue, toString, isEmpty 
 *  
 *
 *   Remarks
 *   -------
 *	Enqueue method 
 *	In the addLast method, a node is created at the end of the 
 *	list and assigns the tail to reference to it. This links a 
 *	new element to another element on the back of the list, 
 *	without having to move any element nor the front index; 
 *	thus, the running time of this method would be constant. 
 *
 *	Dequeue method 
 *	The running time of the dequeue method will also be constant, 
 *	O(1), because deleting a number on the front of the list does 
 *	not require going through the list, it simply unlinks the first 
 *	node from the list. 
 *	
 *	inQueue method
 *	Because this method uses a boolean if/else statement, that the 
 *	list can either contain the element or not, the running time 
 *	would be proportional. The loop could iterate to run n times only; 
 *	thus, the running time of this method O(n). 
 *	
 *	isEmpty method
 *	The isEmpty method runs in O(1) because it only contains an 
 *	if-else statement that if the list equals null, it will return 
 *	true, otherwise false. 
 *
 */

import java.util.LinkedList;

public class Queue<T> {
	LinkedList<T> line = new LinkedList<T>();

	//adds an item on the back of the line
    public void enqueue(T item){
    		line.addLast(item);
    }
    
    //removes an item on the front of the line
    //O(1)
    public void dequeue(){
        line.removeFirst();
    }

    //checks if an item is on the line 
    public boolean inQueue(T item){
    		if (line.contains(item) == true)
    			System.out.println(item + " is already in the line");
    		else 
    			System.out.println(item + " is not on the line");
    	
    		return line.contains(item);

    }

    //checks if the line is empty or not  
    public boolean isEmpty(){
           if ( line.isEmpty() == true )
        	   	System.out.println("There is no line");
           else
              System.out.println("There is a line");
           return line.isEmpty(); 
    }
    
    //overrides the toString() method of the object class to output the line
    @Override
    public String toString() {
 
    		String result= line.toString(); 
 
    		return result; 
    }
    
}
