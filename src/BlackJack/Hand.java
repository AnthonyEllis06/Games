/*
 *  ---------------------------------------------------------------------------
 *  File name: Hand.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 30-Nov-19
 *  ---------------------------------------------------------------------------
 */

package BlackJack;
import GameUtil.Cards.Card;
import java.util.ArrayList;

/**
 * Class Name: Hand<br>
 * Class Purpose: Contains all the methods necessary for a hand. A Hand is an ArrayList of Card objects.<br>
 *
 * <hr>
 * Date created: 1 DEC 19 <br>
 * Date last modified: 1 DEC 19
 * @author Thomas Roberts
 */
public class Hand
{
	//class level variables
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int maxHandSize = 0;
	private int handValue = 0;

	/**
	 * Method Name: Hand(int maxHandSize) <br>
	 * Method Purpose: A default constructor for a hand. A hand is representation of a collection of cards. <br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   A Hand is an arraylist that is a collection of cards.
	 *
	 * <hr>
	 * @param maxHandSize this will let the programmer decide a maximum hand size
	 */
	public Hand(int maxHandSize)
	{
		this.maxHandSize = maxHandSize;
	}// end public Hand(int maxHandSize)

	/**
	 * Method Name: Hand(Hand handIn) <br>
	 * Method Purpose: A copy constructor for a hand.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   A Hand is an arraylist that is a collection of cards.
	 *
	 * <hr>
	 * @param handIn A hand to be copied.
	 */
	public Hand(Hand handIn)
	{
		this.cards = new ArrayList<>(handIn.getCards());
		this.maxHandSize = handIn.getMaxHandSize();
		this.handValue = handIn.getHandValue();
	}

	/**
	 * Method Name: addCard(Card card) <br>
	 * Method Purpose: This method will take a card object and add it to the array list.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Uses an if statement to determine if the hand can hold an additional card,
	 *   and if can, it will add it to the hand. If can't, do nothing.
	 *
	 * <hr>
	 * @param card A hand to be copied.
	 */
	public void addCard(Card card)
	{
		if(cards.size() + 1 < maxHandSize)
		{
			cards.add(card);
			handValue += card.determineValueOfCard();
		}// end if(cards.size() + 1 < maxHandSize)
	}// end addCard(Card card)

	/**
	 * Method Name: removeCard(Card card) <br>
	 * Method Purpose: This method will remove a card object from the array list.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Uses an if statement to determine if the card exists in the arrayList
	 *   and if it does, remove it and decrement the value of the hand by that number
	 *   if the card does not exist within the arraylist, do nothing.
	 *
	 * <hr>
	 * @param card A hand to be copied.
	 */
	public void removeCard(Card card)
	{
		if(cards.contains(card))
		{
			cards.remove(card);
			handValue -= card.determineValueOfCard();
		}// end if(cards.contains(card))
	}// removeCard(Card card)

	public ArrayList<Card> getCards()
	{
		return cards;
	}// end getCards()

	public int getMaxHandSize()
	{
		return maxHandSize;
	}// end getMaxHandSize()

	public int getHandValue()
	{
		return handValue;
	}// end getHandValue()

	/**
	 * Method Name: revealHand()<br>
	 * Method Purpose: This method is used to reveal the cards of hand.<br>
	 *
	 * <hr>
	 * Date created: 1 DEC 19 <br>
	 * Date last modified: 1 DEC 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Mainly used to turn the dealer's cards over
	 *
	 * <hr>
	 */
	public void revealHand()
	{
		for(Card card : cards)
		{
			card.setCardFaceUp(true);
		}// end for(Card card : cards)
	}// end revealHand()

	/**
	 * Method Name: toString()<br>
	 * Method Purpose: This method return a string containing the characteristics of a hand.<br>
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
	 * @return A string containing the attributes of the hand object.
	 */
	@Override
	public String toString()
	{
		return "Hand{" +
				"Hand=" + cards +
				", maxHandSize=" + maxHandSize +
				", handValue=" + handValue +
				'}';
	}// end toString()
}// end Hand()
