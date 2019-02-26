package coe318.lab5;

public class Card implements Comparable 
{
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  
  // Instance Variables
  private int rank;
  private int suit;
  private boolean faceUp;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) 
  {
      // Initilize the instance variables of a Card.
      this.rank = rank;
      this.suit = suit;
      this.faceUp = faceUp;
    
  }

  /**
   * Get the faceUp value of the card.
   * @return the faceUp
   */
  public boolean isFaceUp() 
  {
    return faceUp; 
  }

  /**
   * Set the faceUp value.
   * 
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) 
  {
      this.faceUp = faceUp;
      
  }

  /**
   * Get the rank of the card.
   * 
   * @return the rank
   */
  public int getRank() 
  {
    return rank; 
  }

  /**
   * Get the suit value of the card.
   * 
   * @return the suit
   */
  public int getSuit() 
  {
    return suit;
  }

  @Override
  public boolean equals(Object ob) {
    
    boolean isTrue = false;  
    if ((ob instanceof Card)) 
    {
        // Now check the instance variables of ob object.
        if(((Card) ob).getRank() == this.rank && ((Card) ob).getSuit() == this.suit)
        {
            isTrue = true;
        }
    }
    else
    {
        isTrue = false;
    }
     return isTrue;//FIX THIS
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) 
  {
      int value = 0; // The value that the method will return.
    
    /* 
    * Check the card parameter with the current card values. 
    * The order of importance is rank, then suit(Clubs, Diamonds, Hearts, Spades)
    */
    if(this.rank > c.getRank())
    {
        // It is obviously larger. So the return value should be positive.
        value = 1;
        
    }
    else
    if(this.rank == c.getRank())
    {
        // It is obviously the same, so check the suit order.
        if(this.suit > c.getSuit())
        {
            value = 1;
        }
        else
        if(this.suit == c.getSuit())
        {
            value = 0;
        }
        else
        {
            value = -1;
        }
    }
    else
    if(this.rank < c.getRank())
    {
        value = -1;
    }
    
    return value;//FIX THIS
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() 
  {
    String stringRepresentation = "";
    
    // Check if the rank is an integer
    if( this.rank >= 2 && this.rank <= 10)
    {
        stringRepresentation = "" + rank;
    }
    else
    if(this.rank == 11)
    {
        stringRepresentation = "Jack";
    }
    else
    if(this.rank == 12)
    {
        stringRepresentation = "Queen";
    }
    else
    if(this.rank == 13)
    {
        stringRepresentation = "King";
    }
    else
    if(this.rank == 14)
    {
        stringRepresentation = "Ace";
    }
    return stringRepresentation;
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() 
  {
    String stringRepresentation = "";
    
    // Check the suit value and assign a proper repsentation.
    switch(this.suit)
    {
        case 0: stringRepresentation = "Clubs";
        break;
        case 1: stringRepresentation = "Diamond";
        break;
        case 2: stringRepresentation = "Hearts";
        break;
        case 3: stringRepresentation = "Spades";
        break;        
    
    }
    
    return stringRepresentation; //FIX THIS
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() 
  {
      String stringRep = ""; // The string representation
      
      if(this.faceUp == false)
      {
          stringRep += "?";
      }
      else
      {
          stringRep += this.rank + " " + this.suit;
      }    

    return stringRep; //FIX THIS
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
