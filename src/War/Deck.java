package War;/*
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: FinalProject
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jacey Barrett, barrettjt@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 11/29/2019
 * ---------------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class builds a deck out of the Card class.
 */
public class Deck
{
	private Random rnd = new Random();
	private List<Card> deck = new ArrayList<Card>();
	private int topCardPos = 0;

	/**
	 * Constructor.
	 */
	public Deck()
	{
		int iterator = 0;
		// instead of iterating through each value of the card as in thomas' versio
		// i simply change the value of face and suit each time
		for(Face face : Face.values())
		{
			for(Suit suit : Suit.values())
			{

				deck.add(new Card(face, suit));

				//deck[iterator] = new Card(face, suit); // different in thomas's version
				//iterator++;
			}
		}
	}

	/**
	 * Copy constructor.
	 * @param existingDeck
	 */
	public Deck(Deck existingDeck)
	{
		for(int i = 0; i < deck.size(); i++)
		{
			// deck.add();
		}
		this.topCardPos = existingDeck.topCardPos;
	}

	/**
	 * Returns deck.
	 * @return
	 */
	public List<Card> getDeck()
	{
		return deck;
	}

	/**
	 * toString method that redefines program's default.
	 * @return
	 */
	public String toStringDeck()
	{
		String stringDeck = "";
		for (int i = 0; i < 52; i++)
		{
			stringDeck += deck.toString() +"\n";
		}
		return stringDeck;
	}
}
