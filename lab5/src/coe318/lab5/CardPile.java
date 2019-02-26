package coe318.lab5;
/**
 *
 * @author Syed Yousuf 
 */

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A pile of cards.
 *
 */
public class CardPile 
{
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() 
    {
        //Initialize the instance variable.
        cards = new ArrayList<Card>();

    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) 
    {
      // Add a card to the arraylist
        cards.add(card);
      
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return a random card
     */
    public Card removeRandom() 
    {
        
        // Local Variables
        int randomNum = ThreadLocalRandom.current().nextInt(0, cards.size());
        
        return cards.get(randomNum); //FIX THIS
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return String Representation
     */
    @Override
    public String toString() 
    {
        // Local Variable
        String stringRep = "";
        int counter;

        for(counter = 0; counter < cards.size(); counter++)
        {
            if(cards.get(counter).isFaceUp() == false)
            {
                stringRep += "?  , "; 
            }
            else
            {    
            
                stringRep += cards.get(counter).getRankString() + " of " + cards.get(counter).getSuitString() + "  , ";
            }
        }
        return stringRep;
    }
    
    /**
     * Get a pile of cards.
     * 
     * @return the cards
     */
    public ArrayList<Card> getCards() 
    {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}