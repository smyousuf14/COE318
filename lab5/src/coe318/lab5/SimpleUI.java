package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface 
{
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) 
    {
        // Begin the game. Explain what the game is and its instructions.
        this.game = game;
        
        System.out.println("***************** BLACK JACK GAME *****************");
        System.out.println("INSTRUCTIONS: Both you and the House (the Casino) are dealt two cards: one is face up and the other face down.  So you can see only one of the House's cards and it can see only one of yours.  But both you and the House can discretely peek at your face down cards. ");
        System.out.println("You are asked if you want another card.  If you answer yes, you get another face down card and you will asked again.  This continues until you say \"no\".  This ends the game.");
        System.out.println("");
    
    }

  @Override
    public void display() 
    {
        //FIX THIS
        // Display the the amount of cards that you and the house hold.
        System.out.println("The House holds: ");
        System.out.println("" + game.getHouseCards());
        System.out.println("You hold: ");
        System.out.println("" + game.getYourCards());
        
        
    }
  /*
   *  You are asked if you want another card. If you answer yes, you get another face down card and
   *  you will asked again. This continues until you say "no". This ends the game.
   * 
   * @return if you want another card.
   */
  @Override
    public boolean hitMe() 
    {
        //FIX THIS
        // Local variables.
        boolean yesContinue = false;
        char input; 
        // Prompt the user.
        System.out.println("Do you want to continue and draw another card(y or n: case sensitive): ");
        input = user.next(".").charAt(0); // To strictly take in one character,
        
        // Check input.
        if(input == 'y')
        {
            yesContinue = true;
        }
        else
        {
            yesContinue = false;
        }

        return yesContinue;
    }

  @Override
    public void gameOver() 
    {
        //FIX THIS
        // Local Variables.
        
        // The game is over. 
        System.out.println("GAME OVER!");
        
        // Display the the amount of cards that you and the house hold.
        System.out.println("The House holds: ");
        System.out.println("" + game.getHouseCards());
        System.out.println("You hold: ");
        System.out.println("" + game.getYourCards());
        
        // Now print out the score.
        System.out.println("Your score is " + game.score(game.getYourCards()));
        System.out.println("The score of the House is " + game.score(game.getHouseCards()));
        
        // Check who won.
        if(  (game.score(game.getYourCards()) < 21 && game.score(game.getHouseCards()) > 21 ) 
                || ( (game.score(game.getYourCards()) + game.score(game.getHouseCards()) <= 21 )  && game.score(game.getYourCards()) > game.score(game.getHouseCards())  ) )  
        {
            // You won, against all odds. Really!
            System.out.println("YOU WIN! CONGRADULATIONS");
        }
        else
        if( (game.score(game.getYourCards()) > 21) 
                || (game.score(game.getYourCards()) == game.score(game.getHouseCards())) )
        {
            System.out.println("YOU .... LOSE. ");  
        }
        else
        {
            System.out.println("No one wins.");
        }
        
        
    }

}