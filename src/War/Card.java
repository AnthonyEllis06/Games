package War;/*
 * ---------------------------------------------------------------------------
 * File name: Card.java
 * Project name: FinalProject
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jacey Barrett, barrettjt@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 11/29/2019
 * ---------------------------------------------------------------------------
 */

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines every individual card in a deck.
 */
public class Card
{
	private File frontOfCard;
	private Face face; // declaring face as an int value, that we can sort
	private Suit suit;
	private static Map map = new HashMap<>();

	/**
	 * Constructor.
	 */
	public Card()
	{
		this.face = Face.ACE;
		this.suit = Suit.CLUBS;
		this.frontOfCard = new File("images/" + toString() + ".jpg");
	}

	/**
	 * Copy constructor.
	 * @param otherCard
	 */
	public Card(Card otherCard)
	{
		this.face = otherCard.face;
		this.suit = otherCard.suit;
		this.frontOfCard = otherCard.frontOfCard;
	}

	/**
	 * Copy constructor.
	 * @param face
	 * @param suit
	 */
	public Card(Face face, Suit suit)
	{
		this.face = face;
		this.suit = suit;
		this.frontOfCard = new File("images/" + this.toString() + ".jpg");
	}

	/**
	 * Returns front image of card.
	 * @return
	 */
	public File getCardImage()
	{
		return frontOfCard;
	}

	/**
	 * returns suit of a card.
	 * @return
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * returns face of a card.
	 * @return
	 */
	public Face getFace()
	{
		return face;
	}

	/**
	 * Returns value of each face as an int.
	 * @return
	 */
	public int getFaceValue()
	{
		return face.getValue();
	}

	/**
	 * Redefines the default java toString method.
	 * @return
	 */
	public String toString ()
	{
		return "the " + face.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
	}


}
