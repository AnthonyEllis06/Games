/*
 *  ---------------------------------------------------------------------------
 *  File name: Deck.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 26-Nov-19
 *  ---------------------------------------------------------------------------
 */

package GameUtil.Cards;

import java.util.Random;

/**
 * Class Name: Deck <br>
 * Class Purpose: Contains all the methods necessary for a deck of cards <br>
 *
 * <hr>
 * Date created: 26 NOV 19 <br>
 * Date last modified: 26 NOV 19
 * @author Thomas Roberts
 */
public class Deck
{
	// class level variables
	private Random rnd = new Random();      // needed for the shuffle method
	private Card[] deck = new Card[52];     // a deck of cards is an array of cards
	private int topCardPos = 0;             // use to keep track of the top-most card

	/**
	 * Method Name: Deck() <br>
	 * Method Purpose: A default constructor a deck. A deck comes pre-sorted. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Nested enhanced-for loop to iterate over a new deck to make sure each face and suit are added only once.
	 *
	 * <hr>
	 * @param isFaceUp this will let the programmer decide if the deck of cards is face up or not
	 */
	public Deck(boolean isFaceUp)
	{
		int k = 0;
		for(Suit suit : Suit.values())
		{
			for(Face face : Face.values())
			{
				this.deck[k] = new Card(suit, face, isFaceUp);
				k++;
			}// end for(Face face : Face.values())
		}// end for(Suit suit : Suit.values())
	}// end Deck

	/**
	 * Method Name: Deck(Deck existingDeck) <br>
	 * Method Purpose: A copy constructor a deck. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Since for loop to iterate over an existing deck and into a new one.
	 *
	 * <hr>
	 *   @param  existingDeck an existing Deck to copy in
	 */
	public Deck(Deck existingDeck)
	{
		for(int i = 0; i < deck.length; i++)
		{
			this.deck[i] = new Card(existingDeck.deck[i]);      //added new Card() to ensure making a deep copy
		}
		this.topCardPos = existingDeck.topCardPos;
	}// end Deck(Deck existingDeck)

	/**
	 * Method Name: shuffle() <br>
	 * Method Purpose: Shuffles a deck. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Swaps a card with a random position of another card, iterates 52 times.
	 *
	 * <hr>
	 *
	 */
	public void shuffle()
	{
		for(int i = 0; i < 52; i++)
		{
			int randomPosOne = rnd.nextInt(51);     // this is what will generate a random number
			int randomPosTwo = rnd.nextInt(51);     // this is what will generate a random number

			Card firstCard = this.deck[randomPosOne];
			Card secondCard = this.deck[randomPosTwo];

			this.deck[randomPosOne] = secondCard;
			this.deck[randomPosTwo] = firstCard;
		}// end for(int i = 0; i < 52; i++)
	}// end void shuffle()

	/**
	 * Method Name: sortDeck() <br>
	 * Method Purpose: This method is responsible for sorting a deck of cards. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Nested loops to iterate over the suit, the face, then each card in a deck.
	 *
	 * <hr>
	 *
	 */
	public void sortDeck()
	{
		//Method only variables
		int sortedIndex = 0;
		int currentIndex = 0;
		Suit [] suits = Suit.values();  // all the values of the enums are stored in an array
		Face [] faces = Face.values();  // all the values of the enums are stored in an array

		for(Suit suit : suits)  // iterates all the suits
		{
			for(Face face : faces)  // iterates all the faces
			{
				for(Card card : deck)   // iterates over the deck
				{
					// if the current card is the next card to be inserted into the sorted portion of the deck
					if(card.getFace() == face && card.getSuit() == suit)
					{
						// putting the sorted card in it's appropriate position
						// moving the unsorted card into the position of the sorted card
						Card cardToInsert = new Card(card);
						Card cardToSwap = new Card(deck[sortedIndex]); // reference to that card
						deck[currentIndex] = cardToSwap;
						deck[sortedIndex] = cardToInsert;
						sortedIndex++;
						break;  // we found the next card to be sorted and sorted it and break out of the deck loop
					}// end if(card.getFace() == face && card.getSuit() == suit)
					currentIndex++; // update the index of the unsorted portion of the deck
				}// end for(Card card : deck)
				currentIndex = 0; // reset the index of the unsorted portion the deck to the beginning of the deck
			}// end for(Face face : faces)
		}// end for(Suit suit : suits)
	} //end sortDeck()

	/**
	 * Method Name: dealACard()<br>
	 * Method Purpose: Deals a card from the top of the deck. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Subtracts one card from the top of the deck.
	 *
	 * <hr>
	 *
	 */
	public Card dealACard()
	{
		if(topCardPos < deck.length)
		{
			topCardPos++;
			return deck[topCardPos - 1];
		}
		return deck[topCardPos];

	}//end dealACard()

	/**
	 * Method Name: resetDeck()<br>
	 * Method Purpose: Used to reset a deck back to it's original state. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   The original state is that all the cards are facedown so the player cannot see them.
	 *
	 * <hr>
	 *
	 */
	public void resetDeck()
	{
		topCardPos = 0;
		this.shuffle();
		for(Card card : deck)
		{
			card.setCardFaceUp(false);
		}// end for(Card card : deck)
	}// end resetDeck()

	public Card[] getDeck()
	{
		return deck;
	}// end getDeck()

	/**
	 * Method Name: toString() <br>
	 * Method Purpose: Overriding the default toString. Used for debugging purposes. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Uses a for loop to iterate over all the card objects in the deck array and prints them out
	 *
	 * <hr>
	 * @return strDeck The string that will contain all the useful information about the deck of cards
	 */
	@Override
	public String toString()
	{
		String strDeck = "";
		for (int i = 0; i < 52; i++)
		{
			strDeck += deck[i].toString() + "\n";
		}// end for (int i = 0; i < 52; i++)
		return strDeck;
	}// end toString()
}// end Deck
