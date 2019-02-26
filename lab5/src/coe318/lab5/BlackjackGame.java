package coe318.lab5;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/*
 * A standard Blackjack game. 
 */
public class BlackjackGame 
{

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p The card pile.
   * @return the score
   */
  public int score(CardPile p) 
  {
      // Local Variables
      int score = 0; // The score of the cardpile that will be calculated.
      int counter; // The counter for the filter for loop.
      ArrayList<Card> temporaryPile = new ArrayList<Card>(); // This ArrayList will temporaryly store p cardpile. 
      
      // Now get the card from cardpile p.
      temporaryPile = p.getCards();
      
      // Filter through the cards and calculate the score.
      for(counter = 0; counter < temporaryPile.size(); counter++)
      {
          /*
           * The scre is calculated based the card. An Ace has a score of 1. A Jack, 
           * King, or Queen has  a score of 10, and all other cards have a score which is
           * based upon their rank. So, check for the rank of each card and assign a
           * score respectively.
           */
          
          if(temporaryPile.get(counter).getRank() == 14)
          {
              // Then it is an Ace.
              score += 1;
          }
          else
          if(temporaryPile.get(counter).getRank() >= 11 && temporaryPile.get(counter).getRank() <= 13)
          {
              // Then it is either Jack, King, or Queen.
              score += 10;
          }
          else
          if(temporaryPile.get(counter).getRank() >= 2 && temporaryPile.get(counter).getRank() <= 10)
          {
              // Then it is a Jack, King, or Queen.
              score += temporaryPile.get(counter).getRank();
          }
              
      }
      
    
      
    return score;
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}