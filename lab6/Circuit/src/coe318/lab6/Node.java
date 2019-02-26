/*
 * A Node that will connect to the two ends of a resistor.
 */
package coe318.lab6;

/**
 *
 * @author Syed Yousuf
 */
public class Node 
{
    // Instance variables.
    private static int nextid = 0; // The identification number of the next node.  
    private int id = 0; // The identifying number of the node.
    
    
    // Constructor (no arguments)
    /*
    * Constructs a Node and initializes it. That way the first Node created will have
    * an id value of 0 and the next Node created will have an id value of 1. 
    */
    public Node()
    {
        // Determine the id of the first node and the subsequent next node.
        id = nextid;
        nextid++ ; 
    }
    
    /*
    * A toString method for the Node class.
    *
    * @return A to-string representation of the Node class, the id number as a String.
    */
    @Override
    public String toString()
    {
        
        return "" + id;
    }
    
}
