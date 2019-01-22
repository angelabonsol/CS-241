/**
 * 	Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Angela Bonsol, Marcus Wong, Conor Sullivan
 *  Collaborators: None
 *  References: Java:Software Solutions Foundations of Program Design 9th Edition by Lewis/Loftus
 *  				AVLTree.java
 *  
 *  Assignment: 6
 *  Problem: What are the running times for insertion and search in the 
 *  			Data Structures: Hashtable and AVL Tree?
 *  
 *  Description: 
 *  -Predict the asymptotic running time of inserting and searching in the 
 *  Data Structures: Hashtable and AVL Tree
 *  -Create instances of the Hashtable and AVL Tree
 *  -Measure the running time of constructing and searching the instance of Hashtable
 *  in nanoseconds
 *  -Measure the running time of constructing and searching the instance of AVL Tree
 *  in nanoseconds
 *  -Conclude if your hypothesis are correct
 * 
 *  Input: N/A
 *  Output: N/A
 *
 *  Visible data fields:
 *  private static final int DEFAULT_TABLE_SIZE
 *  private List<T>[] theLists
 *  private int currentSize
 *
 *  Visible methods:
 *	isPrime(int n), nextPrime(int n), myhash(T x), rehash(), makeEmpty(), 
 *	insert(T x), contains(T x), remove(T x)
 * 
 *   Remarks
 *   -------
 *    
 *    1)
 *   	a) In a separate-chaining hash table, adding n entries 
 *   	with consecutive keys will run on O(n^2). According to 
 *   the insert() method code provided in the textbook, containing 
 *   two if statements, which are O(1). The creation of a temporary 
 *   List runs in constant time O(1). One of the if methods executes 
 *   the rehash() method, which runs in O(n^2), due to the nested for 
 *   loops that copies the table over. The insert() method also contains 
 *   the add() method which adds an item into a List, which run in O(n). 
 *   Therefore, adding all these asymptotic running times, they will equal 
 *   to O(n^2), which is the shortest asymptotic running time out of the five. 
 *   
 *   O(1)+ O(1)+ O(1) + O(n^2) + O(n) = O(n^2)
 *   
 *   	b.) In separate-chaining hash table, searching for a key that 
 *   is not in the table will run on O(n). According to the contains() 
 *   method code provided in the textbook, which returns true or false
 *   based on the contains method of the List class. The creation of a 
 *   List in the method is a constant O(1). The contains method of the 
 *   List class runs generally in O(n), worse case scenario, checking 
 *   each item in the List. Therefore, because the contains method of 
 *   the SeparateChainingTable class directly returns the contains method 
 *   of the List class, it's running time will be the same as the one in 
 *   List class, which is O(n).
 *   
 *   O(1) + O(n) = O(n)
 *   
 *   2)
 *   	a) In an AVL Tree, adding n entries with consecutive keys will 
 *   run in O(log n), which is the height of the tree. According to the 
 *   provided code, AVLTree.java, numerous conditions are stated, which 
 *   are studied one by one. If the tree is empty, it simply makes an 
 *   AVL node, making it the first one, which runs in O(n). The compareTo 
 *   method is used, running in  O(log n), comparing the element and an 
 *   element in the tree to compare whether the element should be on the 
 *   left side or right side of the tree, which results to either to 
 *   less than 0 ( O(1) )or more than 0 ( O(1) ). It then traverses the 
 *   tree and recursively going through the method again depending which 
 *   statement is satisfied. The method ends returning a balance version 
 *   of the tree O(1).
 *   
 *   O(n) + O(log n) + O(1) + O(1) + O(1) + O(1) = O(log n)
 *      
 *   	b) In an AVL Tree, searching for a key that is not in the tree 
 *   will also run in O(log n). Because our tree is known to already be 
 *   balanced, it would not be so hard to search through it as well. 
 *   According to the internal contains method provided, inside a while 
 *   statement (O(n)) is the compareTo method once again, which compares 
 *   the left and right side of the tree. If the item is potentially on 
 *   the left side, it focuses on the left O(1), and vice versa O(1). 
 *   Thus, out of all these four complexity, O(log n) takes the shortest 
 *   amount of time. 
 *   
 *   O(n) + O(log n) +  O (1) + O(1) = O(log n)
 *   
 *   3)
 *   _________________________________________________________________________________________
 *   | Construction time |  N= 10^2  |  N=10^3   |   N=10^4   |    N=10^5   |     N=10^6     |
 *   _________________________________________________________________________________________
 *   |     Hash table    | 3,741,050 | 4,921,541 | 26,388,907 | 74,470,293  | 1,287,626,863  |
 *   _________________________________________________________________________________________
 *  	 |    AVL Tree       | 4,752,250 | 6,485,989 | 17,003,626 | 32,893,645  |  822,289,410   |
 *   _________________________________________________________________________________________
 *   
 *   _____________________________________________________________________
 *   | Search time | N= 10^2  |  N=10^3  |  N=10^4  |  N=10^5  | N=10^6  |
 *   _____________________________________________________________________
 *   |  Hash table |  11,526  |  18,740  |  39,760  |  30,562  | 33,681  |
 *   _____________________________________________________________________
 *  	 |   AVL Tree  |  23,128  |  18,626  |  71,575  |  19,535  | 26,533  |
 *   _____________________________________________________________________
 *   
 *   4)
 *   As we measured the construction time and search time of both Hash table 
 *   and AVL tree, we noticed a similarity on running times between Hash table 
 *   and Tree. 
 *   
 *   The construction time for Hash table proves our conjecture that inserting 
 *   will take O(n^2). Approximately, it shows numbers that suggest when, for 
 *   example, when n=1,000 using our running time of n^2, it should take about
 *   1,000,000 nanoseconds. 
 *   
 *   The construction time for the AVL tree was close to our conjecture, except 
 *   for the first two columns. It is visible that for the last 3 columns, the 
 *   AVL Tree took significantly less time than Hash table as we move towards 
 *   the right on the row. This confirms our conjecture that inserting in an AVL 
 *   Tree would take O(log n) because as the numbers grow, it seems that the 
 *   nanoseconds only seem grow logarithmically. 
 *   
 *   The search time for both Hashtable and AVL tree seem to be off. Searching 
 *   in Hash table, time began to increase exponentially, then drop at the 4th 
 *   trial, and slowly began to increase once more. As for the AVL tree, the 
 *   1st trial took more time than the 2nd trial even though the 2nd trial 
 *   contained more items. As we go down the row of “Search time” in tree, the 
 *   number varies per trial, from decreasing to increasing, and once again 
 *   increasing exponentially. We think that the search time for these specific 
 *   data structure depends how far off the random number is from the maximum 
 *   number of the constructed tree. Because we had set it up to generate any 
 *   number bigger than the size of the hash table/tree, which is also the 
 *   maximum number, searching a random number bigger than the maximum in a big 
 *   group of numbers will take a much longer time. 
 *    
 */
import java.util.*;

public class SeparateChainingHashtable<T> {
	
	/**
	 * Construct the hashtable.
	 */
	public SeparateChainingHashtable () {
		this (DEFAULT_TABLE_SIZE);
	}

	/**
	 * Construct the hashtable.
	 * @param size approximate table size.
	 */
	public SeparateChainingHashtable(int size) {
		theLists = new LinkedList[nextPrime(size)];
		for (int i= 0; i < theLists.length; i++)
			theLists[i] = new LinkedList<>();
	}
	/**
	 * Insert into the hash table. If the item is 
	 * already present, then do nothing
	 * @param x the item to insert.
	 */
	public void insert(T x) {
		List<T> whichList = theLists[ myhash(x) ];
		if (!whichList.contains(x)) {
			whichList.add(x);
			
				//Rehash; see Section 5.5
			if (++currentSize > theLists.length)
				rehash();
		}
	}
	
	/**
	 * Remove from the hash table.
	 * @param x the item to remove.
	 */
	public void remove(T x) {
		List<T> whichList = theLists[myhash(x)];
		if (whichList.contains(x)) {
			whichList.remove(x);
			currentSize--;
		}
	}
	
	/**
	 * Find an item in the hash table.
	 * @param x the item to search for.
	 * @return true if x is not found.
	 */
	public boolean contains(T x) {
		List<T> whichList = theLists[myhash(x)];
		return whichList.contains(x);
	}
	
	/**
	 * Make the hashtable logically empty.
	 */
	public void makeEmpty() {
		for (int i = 0; i < theLists.length; i++)
			theLists[i].clear(); 
		currentSize = 0;
	}
	
	private static final int DEFAULT_TABLE_SIZE =101;
	
	private List<T>[] theLists; 
	private int currentSize;
	
	/**
	 * Rehashing for separate chaining hash table.
	 */
	private void rehash() {
		List<T> [] oldLists = theLists;
		
		 	//Create new double-sized, empty table
		theLists = new List[nextPrime(2 * theLists.length )];
		for (int j = 0; j < theLists.length; j++)
			theLists[j] = new LinkedList<>();
		
			//Copy table over
		currentSize = 0;
		for (int i = 0; i < oldLists.length; i++)
			for (T item: oldLists[i])
				insert(item);
	}
	
	private int myhash(T x) {
		int hashVal = x.hashCode();
		
		hashVal %= theLists.length; 
		if (hashVal < 0)
			hashVal += theLists.length; 
		
		return hashVal;
	}
	
	/**
	 * Internal method to find a prime number at least as large as n. 
	 * @param n the starting number (must be positive). 
	 * @return a prime number larger than or equal to n. 
	 */
	private static int nextPrime(int n) {
		if (n % 2 == 0 )
			n++;
		
		for( ; !isPrime(n); n +=2 )
			;
		
		return n;
	}
	
	/**
	 * Internal method to test if a number is prime.
	 * @param n the number to test.
	 * @return the result of the test. 
	 */
	private static boolean isPrime(int n) {
		if ( n == 2 || n == 3)
			return true; 
		if ( n == 1 || n % 2 == 0)
			return false; 
		
		for ( int i = 3; i * i <= n ; i += 2 )
			if (n % i == 0)
				return false; 
		
		return true;
	}

}
