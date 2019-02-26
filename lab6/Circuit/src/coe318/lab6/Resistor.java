/*
 * A resistor which is connected to two nodes.
 */
package coe318.lab6;

/**
 *
 * @author Syed Yousuf
 */
public class Resistor 
{
    // Instance Variables.
    private static int nextid = 1; // Helps in setting the unique id of each resistor.
    private int id = 0;
    private double resistance; // Resistance in ohms
    private Node node1; // The first node that is connecteed to the resistor.
    private Node node2; // The second node that is connected to the resistor.
    
    // Constructor.
    
    /*
    * Creates a resistor initialized with default values.
    * 
    * @param resistance The resistance of this Resistor.
    * @param node1 The first node.
    * @param node2 The second node.
    */
    public Resistor(double resistance, Node node1, Node node2)
    {
        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;
        
        id = nextid;
        nextid++;
        
    }
    
    /*
    * Get the two nodes of this resistor as an array of Nodes.
    * 
    * @return Node[] An Array of Nodes.
    */
    public Node[] getNodes()
    {
        // Local Variable
        
    }
}
