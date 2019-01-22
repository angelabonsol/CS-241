
/*
 * 	Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Angela Bonsol, Marcus Wong, Conor Sullivan
 *  Collaborators: None
 *  References: Java:Software Solutions Foundations of Program Design 9th Edition by Lewis/Loftus
 *  			   	BinarySearchTree.java
 *  				
 *  Assignment: 4
 *  Problem: How long does it take to search the Skewed Tree and Balanced Tree implemented in BST.java?
 *  
 *  Description: 
 *  In the Skewed Tree, the time it takes to search a number that is not in the tree is measure. 
 *  Using the generator to generate a number that is not in the tree. In Balanced Tree, a new random 
 *  number is generated to search in the tree, also measuring the time it takes to do so. 
 *  
 *  Input: int x
 *  Output: long time
 *
 *  Visible data fields:
 *  BST<Integer> tree, int x, int searchS, int searchR, long time
 *
 *  Visible methods:
 *	sMaker(), makeEmpty(), rMaker(), contains()
 * 
 *   Remarks
 *   -------
 *    
 *  1) 
 * 	Looking into the contains method of the BinarySearchTree class, 
 * 	which we will use to search  for any kind of BST, we have calculated 
 * 	that it has a running time of O(log n). As we evaluated the internal 
 * 	method to find an item in a subtree in the BinarySearchTree class, 
 * 	we recognized 4 if/else statements in total, declaring certain conditions 
 * 	in which it returns true, false, or recursively going through the method 
 * 	again. Each if/else statement is O(n) because it will only iterate n 
 * 	times that the statement is true. Meanwhile , a certain line states 
 * 	“int compareResult = x.compareTo(t.element);” which contains a compareTo method. 
 * 	The compareTo method is used to compare whether the element is part of the left 
 * 	or right side of the tree, making it's running time O(log n). Therefore, 
 * 	calculating the whole contain’s method, it would be O(log n) because it 
 * 	is the shortest running time out of all 5 calculated running times for 
 * 	the method. 
 * 	
 * 	O(n)+O(n)+O(n)+O(n)+O(log n) = O(log n)
 * 
 * 	Searching a Skewed tree would have a O(n) running time since there is 
 * 	only one node per level, we would have to check all nodes in the tree not 
 * 	really needing to constantly comparing to one side of a tree to another. 
 * 	The contains method is forced to iterate n times, for n items. However, 
 * 	for a Balanced Tree, it would take a O(log n) running time because each 
 * 	side of the tree is compared to check if a certain item is present. The 
 * 	compareTo method is constantly used to compare one side of a tree to another. 
 * 	This running time tends to be faster because it avoids some elements of 
 * 	the tree.
 *   
 *   2)
 *   _________________________________________________________
 *   |			   | N= 10^3  | N=10^4  | N=10^5  | N=10^6  |
 *   _________________________________________________________
 *   |Skewed BST   |  88,514  | 118,485 |   StackOverFlow	   |	
 *   _________________________________________________________
 *  	 |Balanced BST |  2,531   |  3,656  |  4,508  |	1,218  |
 *   _________________________________________________________
 *   
 *   3)
 *  Our table supports our conjecture that a Skewed Tree would run in O(n) 
 *  and a Balanced Tree in O(log n). Although the Skewed Tree has reached 
 *  a stackoverflow, we can still notice the linear increase when n=1,000 
 *  then n=10,000. Meanwhile, in a Balanced Tree, the time to search a random 
 *  generate number increases logarithmically for each increase in n, going 
 *  to the right of the row. 
 *  
 *  From the table we can see a large difference between searching in a Skewed 
 *  Tree and a Balanced Tree, just like how different a y=n graph would be from 
 *  a y=log n graph. We can conclude that the more numbers in a Skewed Tree, 
 *  searching time would increase linearly, which would be more time than a Balanced 
 *  Tree would take. In fact, whether n equals a small number or a large one, 
 *  a Balanced Tree would take less time to be searched than a Skewed Tree. 
 *  The searching time of Balanced Tree increases in logarithmic time, with respect 
 *  to the number of items on the tree.
 *
 */

import java.util.*;

public class testBST {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random generator = new Random();

		System.out.println("Enter an integer:");
		int num = scan.nextInt() + 1;

		// Make a Skewed Tree
		BST<Integer> skewed = new BST<Integer>();
		for (int i = 1; i < num; i++) {
			skewed.insert(i);
		}

		// Make a Balanced Tree
		BST<Integer> balanced = new BST<Integer>();
		for (int i = 1; i < num; i++) {
			int bal = generator.nextInt() + 1;
			// add each integer

			// if number is already present (use contains method)
			// multiply the value returned by random() by a big number
			if (balanced.contains(bal)) {
				bal = bal * 25;
				balanced.insert(bal);
			}

			else {
				balanced.insert(bal);
			}
		}

		// Test Search in a Skewed Tree: a number that is not in the tree

		int searchS = generator.nextInt(num); // searches for a number more than s,
		// which is not in the tree

		long startS = System.nanoTime();

		skewed.contains(searchS);

		long endS = System.nanoTime();

		long timeS = endS - startS;

		System.out.println("The time taken by a Skewed Tree to search is: " + timeS + " nanoseconds");

		// Test Search in Balanced Tree: a NEW random number
		// (so if the number is in the tree,generate a new one)

		int searchR = generator.nextInt();

		// if the generated number is in the tree, generate a new one
		if (balanced.contains(searchR)) {
			searchR = generator.nextInt();
		}

		long startR = System.nanoTime();

		balanced.contains(searchR);

		long endR = System.nanoTime();

		long timeR = endR - startR;

		System.out.println("The time taken by a Balanced Tree to search is: " + timeR + " nanoseconds");

	}
}
