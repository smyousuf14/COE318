/*
 * This class will track all the account information of different owners/users.
 */
package coe318.lab4;

/**
 *
 * @author Syed Yousuf
 */
public class Account 
{
    /*Instance Variables*/
    private int AccountNumber;
    private double CurrentBalance;
    private String OwnerName;
    
    // Constructors
    
    /*
    * The Constructor for the Account class
    *
    * @param name The name of the owner
    * @param number The number of the account
    * @param initialBalance The initial amount of money in the account.
    */
    public Account(String name, int number, double initialBalance)
    {
        // Sets the values for the instance variables
        OwnerName = name;
        AccountNumber = number;
        CurrentBalance = initialBalance;
    }
    
    
    /*Method list*/
    
    /*
    * Gets the name of the Owner of the account.
    *
    * @return The name of the owner.
    */
   public String getName()
   {
        /*Return the name of the owner*/
       return OwnerName;
   }
   
   /*
   * Gets the current balance value of the owners account.
   *
   * @return The current balance
   */
   public double getBalance()
   {
       return CurrentBalance;
   }
   
   /*
   * Gets the account number of the owners account.
   *
   * @return The Account number
   */
   public int getNumber()
   {
       return AccountNumber;
   }
    
   /*
   * Add to the balance by the amount specified by the user.
   *
   * @param amount The amount of money to deposit
   * @return If the operation is successful
   */
   public boolean deposit(double amount)
   {
       // Local Variables
       boolean successful = false;
       
       // Remove the specifed amount from the balance if it is possible.
       if((CurrentBalance + amount)>= 0 && amount >= 0)
       {    
            CurrentBalance += amount;
            successful = true;
       }
       
       return successful;
   }

   /*
   * Remove the specified amount from the current balance of the user.
   *
   * @param amount The amount to remove.
   * @return If the operation is successful
   */
   public boolean withdraw(double amount)
   {
       // Local Variables
       boolean successful = false;
       
       // Make sure the transaction can be made without the balance becoming negative
       if((CurrentBalance - amount) >= 0 && amount >= 0)
       {
            // Remove the specifed amount from the balance
            CurrentBalance -= amount;
            successful = true;
       }
       
       return successful;
   }
   
   
@Override
public String toString() 
{
return "(" + getName() + ", " + getNumber() + ", " +
String.format("$%.2f", getBalance()) + ")";
}
   
   
}
