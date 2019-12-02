/*
 *  ---------------------------------------------------------------------------
 *  File name: Player.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 30-Nov-19
 *  ---------------------------------------------------------------------------
 */

package BlackJack;

import GameUtil.Cards.Card;
import GameUtil.Player;

/**
 * Class Name: BlackJackPlayer<br>
 * Class Purpose: Contains all the methods necessary for a black jack player.
 *  It also tends the player class.<br>
 *
 * <hr>
 * Date created: 1 DEC 19 <br>
 * Date last modified: 1 DEC 19
 * @author Thomas Roberts
 */
public class BlackJackPlayer extends Player
{
	//class level variables
	private Hand playerHand = new Hand(52);

	/**
	 * Method Name: BlackJackPlayer(String name)<br>
	 * Method Purpose: A default constructor for a black jack player.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   A name is supplied from the player class. Just a string to represent a player's name.
	 *
	 * <hr>
	 * @param name this will let the programmer decide a maximum hand size
	 */
	public BlackJackPlayer(String name)
	{
		super(name);
	}// end BlackJackPlayer(String name)

	/**
	 * Method Name: drawACardToPlayerHand(Card card)<br>
	 * Method Purpose: This method is responsible for dealing a card and adding it to the player's hand.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   If the player's hand does NOT contain the card that is passed, add it to the player's hand.
	 *   If it does contain the card, for whatever reason. It doesn't get added anyways.
	 *
	 * <hr>
	 * @param card A card to be drawn from the deck.
	 */
	public void drawACardToPlayerHand(Card card)
	{
		if(!playerHand.getCards().contains(card))
		{
			playerHand.addCard(card);
		}// end if(!playerHand.getCards().contains(card))
	}// end drawACardToPlayerHand(Card card)

	public Hand getPlayerHand()
	{
		return playerHand;
	}//end getPlayerHand()

	public void setName(String name)
	{
		super.setName(name);
	}

	/**
	 * Method Name: resetPlayer()<br>
	 * Method Purpose: Reset the player's hand.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   You need a new hand for certain conditions in the gui.
	 *   Without this method, your hand could never be reset and this assures it happens.
	 *
	 * <hr>
	 */
	public void resetPlayer()
	{
		this.playerHand = new Hand(52);
	}

	/**
	 * Method Name: toString()<br>
	 * Method Purpose: A toString method to return the attributes of a BlackJackPlayer.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Used for debugging purposes.
	 *
	 * <hr>
	 */
	@Override
	public String toString()
	{
		return "BlackJackPlayer{" +
				"playerHand=" + playerHand +
				'}';
	}// end toString()
}
