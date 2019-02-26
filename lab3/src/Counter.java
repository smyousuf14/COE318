/**
 *
 * @author Syed Yousuf
 */
package coe318.lab3;
public class Counter {
    //Instance variables here
    private int digitValue;
    private int modulusValue; /*Maximum possible value*/
    private Counter leftNeighbour; /*The left neighbour to this counter digit*/
    
    /*Constructors*/
    public Counter(int modulus, Counter left) 
    {
        /*Initialize the instance vsariables*/
        modulusValue = modulus;
        leftNeighbour = left;
        
    }


    /**
     * @return the modulus
     */
    public int getModulus() 
    {
        return modulusValue;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() 
    {
        return leftNeighbour;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digitValue;
    }

    /**
     * Set the digit value of the counter
     * @param digit the digit to set
     */
    public void setDigit(int digit) 
    {
        digitValue = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() 
    {
        /*Increment the digit value of this Counter and check*/
        digitValue++;
        if(digitValue == modulusValue)
        {
           
            /*Reset the digit of this counter and roll over */
            digitValue = 0;
            
            if(leftNeighbour != null)
            {
                leftNeighbour.setDigit(leftNeighbour.getDigit() + 1);
            }
        }
    
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() 
    {
        /*Local Variable*/
        int count;
        
        if(leftNeighbour != null)
        {
            count = (digitValue + modulusValue * leftNeighbour.getDigit());
        }
        else
        {
            count = digitValue;
        }
        return count;
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() 
    {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
