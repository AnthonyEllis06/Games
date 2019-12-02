/*
 *  ---------------------------------------------------------------------------
 *  File name: BlackJack.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 30-Nov-19
 *  ---------------------------------------------------------------------------
 */

package BlackJack;
import GameUtil.*;
import GameUtil.Cards.Deck;

/**
 * Class Name: BlackJack<br>
 * Class Purpose: Contains all the methods necessary for a game of Black Jack<br>
 *
 * <hr>
 * Date created: 26 NOV 19 <br>
 * Date last modified: 26 NOV 19
 * @author Thomas Roberts
 */
public class BlackJack implements GameInterface
{
    // class level variables
    Deck deck;
    BlackJackPlayer player;
    BlackJackPlayer dealer;
    Hand playerHand;

    /**
     * Method Name: BlackJack(BlackJackPlayer dealer, BlackJackPlayer player, Deck deck)<br>
     * Method Purpose: A default constructor a game of Black Jack<br>
     *
     * <hr>
     * Date created: 26 NOV 19 <br>
     * Date last modified: 1 DEC 19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     * @param dealer a Black Jack Player to represent a dealer
     * @param player a Black Jack Player to represent a player
     * @param deck a Deck of cards to play with
     */
    public BlackJack(BlackJackPlayer dealer, BlackJackPlayer player, Deck deck)
    {
        this.dealer = dealer;
        this.player = player;
        this.deck = deck;
    }//end BlackJack(BlackJackPlayer dealer, BlackJackPlayer player, Deck deck)

    /**
     * Method Name: bust(Hand someoneHand)<br>
     * Method Purpose: The logic for if either players busts<br>
     *
     * <hr>
     * Date created: 26 NOV 19 <br>
     * Date last modified: 1 DEC 19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   Returns a boolean to let the programmer know if the someone's had busts.
     *
     * <hr>
     * @param someoneHand You pass this method someone's hand to check.
     */
    public boolean bust(Hand someoneHand)
    {
        boolean result = false;

        if(someoneHand.getHandValue() > 21)
        {
            result = true;
        }// end if(someoneHand.getHandValue() > 21)
        return result;
    }// end bust(Hand someoneHand)

    /**
     * Method Name: dealerAI()<br>
     * Method Purpose: The AI for the dealer to keep playing when the player chooses to stay.<br>
     *
     * <hr>
     * Date created: 26 NOV 19 <br>
     * Date last modified: 26 NOV 19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   If the dealer hand contains a value of less than 16, then draw a card until it doesn't.
     *
     * <hr>
     *
     */
    public void dealerAI()
    {
        while(dealer.getPlayerHand().getHandValue() < 16)
        {
            dealer.getPlayerHand().addCard(deck.dealACard());
        }// end while(dealer.getPlayerHand().getHandValue() < 16)
    }// end dealerAI()

    /**
     * Method Name: winner()<br>
     * Method Purpose: A method used for determining the winner.<br>
     *
     * <hr>
     * Date created: 26 NOV 19 <br>
     * Date last modified: 26 NOV 19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   If statement that calculates each player's hand to determine who wins.
     *
     * <hr>
     *
     */
    public String winner()
    {
        String result = "";
        if(player.getPlayerHand().getHandValue() < dealer.getPlayerHand().getHandValue() && dealer.getPlayerHand().getHandValue() <= 21)
        {
            result = "Lose";
        }// end if(player.getPlayerHand().getHandValue() < dealer.getPlayerHand().getHandValue() && dealer.getPlayerHand().getHandValue() <= 21)
        else if(player.getPlayerHand().getHandValue() == dealer.getPlayerHand().getHandValue() && dealer.getPlayerHand().getHandValue() <= 21)
        {
            result = "Push";
        }// end else if(player.getPlayerHand().getHandValue() == dealer.getPlayerHand().getHandValue() && dealer.getPlayerHand().getHandValue() <= 21)
        else
        {
            result = "Win";
        }// end else
        return result;
    }// end winner()

    @Override
    public void play()
    {

    }

    @Override
    public Player getCurrPlayer()
    {
        return player;
    }

    @Override
    public void addPlayer(Player newPlayer)
    {
        player.setName(newPlayer.getName());
    }

    @Override
    public void nextPlayerTurn()
    {

    }

    @Override
    public Boolean gameWon()
    {
        return null;
    }

    @Override
    public int getNumPlayers()
    {
        return 1;
    }

    @Override
    public Boolean gameOver()
    {
        return false;
    }

    @Override
    public void CallCommand()
    {

    }
}//end BlackJack
