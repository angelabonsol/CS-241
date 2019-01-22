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
 *  Assignment: 4
 *  Problem: How to implement methods that make a Skewed Tree and Balanced Tree?
 *  
 *  Description: 
 *  Implement a Binary Search Tree that will contain numbers 1, 2, ..., x, 
 *  where x is the input of user, this will act as a Skewed Tree. 
 *  Implement a Binary Search Tree that will contain x numbers generated randomly,
 *  where x is the input of user. If a number repeats itself, it is multiplied 
 *  by a big number, where it is assumed that the tree will be a Balanced Tree, 
 *  since the numbers are more spread out and inserted at random order.
 *  
 *  Input: N/A
 *  Output: N/A
 *
 *  Visible data fields:
 *  BinaryNode<T> root, 
 *
 *  Visible methods:
 *	public void BinarySearchTree, public void insert, public boolean contains, 
 *	BinaryNode<T> insert, public void makeEmpty, public void rMaker, public void sMaker, 
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

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BST<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BST( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<AnyType>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;

}
