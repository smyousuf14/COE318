/**
 *
 * @author Syed Yousuf
 */
package coe318.lab4;

public class Bank 
{
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts;
    private int numAccounts; //number of active accounts
    
    /*Constructors*/
    public Bank(String name, int maxNumberAccounts) 
    {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
    }


    /**
     * @return the name
     */
    public String getName() 
    {
        return name;  
    }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() 
    {
        return numAccounts; 
    }


    public Account[] getAccounts() 
    {
        return accounts; 
    }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return If it has an account with this number
     */
    public boolean hasAccountNumber(int accountNumber) 
    {
        // Local Variable
        boolean successful = false; 
        int counter;
        
        // Check if the bank already has an account with the accountnumber
        for(counter = 0; counter <= (numAccounts - 1); counter++)
        {
            // Check if the bank account already has this number
            if(accounts[counter].getNumber() == accountNumber)
            {
                successful = true;
            }
            
        }
        return successful; 
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) 
    {
        
        // Local Variable list
        boolean successful = true;
        int counter;
        
        // Check if the account can be successfully added to the bank
        // Check if the bank already has an account with the accountnumber
        for(counter = 0; counter <= (numAccounts - 1); counter++)
        {
            // Check if the bank account already has this number
            if(accounts[counter].getNumber() == account.getNumber())
            {
                successful = false;
                break;
            }
            
            
        }
        
        if(successful == true) 
        {
            if ((numAccounts - 1) <= (accounts.length)) // If the account number does not exist, nor has the bank reached max
            {
                // Add account to bank
                this.accounts[numAccounts] = account;
             
                // Increment the amount of active accounts that are currently in the bank system
                numAccounts++;
             
                //Make sure to set successful
                 successful = true;
             
            }
            else
            {
                successful = false; // Could not add.
            }
        
        }
        return successful; //If it was successful and added the account or not.
    }

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}
