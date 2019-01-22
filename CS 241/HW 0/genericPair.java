
/*************************************************************************
 *
 *  Pace University
 *  Fall 2018
 *
 *  Course: CS 241
 *  Author: Miguel Mosteiro
 *  Collaborators: the class
 *  References: Weiss book
 *
 *  Assignment:
 *  Problem: 
 *  Description: generic pair data structure
 *
 *  Input: 
 *  Output: 
 *
 *  Visible data fields:
 *  none.
 *
 *  Visible methods:
 *  read() : method to read each object
 *  write() : method to write each object
 *  toString()
 *  equals()
 *
 *   Remarks
 *   -------
 *
 *
 *************************************************************************/

public class genericPair< X,Y >{

    // placeholders for the data
    private X first;
    private Y second;

    // public methods
    public X readFirst(){
        return first;
    }
    public Y readSecond(){
        return second;
    }
    public void writeFirst(X newFirst){
        first = newFirst;
    }
    public void writeSecond(Y newSecond){
        second = newSecond;
    }
    
    public String toString(){
        return "("+first.toString()+","+second.toString()+")";
    }

    // test method
    public static void main(String[] args){
        // create a pair
        genericPair<Integer,String> myPair = new genericPair<Integer,String>();

        // assign some values
        myPair.writeFirst(23);
        myPair.writeSecond("John");

        // display the value stored
        System.out.println("The values stored are (" + myPair.readFirst() +","+ myPair.readSecond() +")");
        System.out.println("The values stored are " + myPair.toString() );


    }

}
