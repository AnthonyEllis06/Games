package War;/*
 * ---------------------------------------------------------------------------
 * File name: War.java
 * Project name: FinalProject
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jacey Barrett, barrettjt@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 11/29/2019
 * ---------------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Actual player that runs Game.
 */
public class War
{
	private List<Card> deck;
	private static LinkedList<Card> p1Cards;
	private static LinkedList<Card> p2Cards;
	private Card currCard;
	private static boolean gameWon;

	/**
	 * Constructor.
	 */
	public War ()
	{
		this.deck = new ArrayList<Card>(52);
		this.p1Cards = new LinkedList<Card>(deck.subList(0, 26));
		this.p2Cards = new LinkedList<Card>(deck.subList(26, 52));
		this.currCard = new Card(Face.ACE, Suit.SPADES);
		this.gameWon = false;
	}

	/**
	 * Determines if game is won or not.
	 * @return
	 */
	public static Boolean isGameWon ( )
	{
		while (!gameWon)
		{
			if (p1Cards.size( ) == 0)
			{
				System.out.println("Player 2 wins");
				return gameWon = true;
			}
			else if (p2Cards.size( ) == 0)
			{
				System.out.println("Player 1 wins!");
				return gameWon = true;
			}
			else
			{
				gameWon = false;
			}
		}
		return gameWon = true;
	}

	/**
	 * Returns list deck.
	 * @return
	 */
	public List<Card> getDeck()
	{
		return deck;
	}

	/**
	 * Returns sublist of player one's cards.
	 * @return
	 */

	public LinkedList<Card> getP1Cards()
	{
		return p1Cards;
	}

	/**
	 * Returns sublist of player two's cards.
	 * @return
	 */
	public LinkedList<Card> getP2Cards()
	{
		return p2Cards;
	}

	/**
	 * Returns current value of card.
	 * @return
	 */
	public Card getCurrCard()
	{
		return currCard;
	}

	/**
	 * Returns if game is won or not.
	 * @return
	 */
	public boolean getGameWon()
	{
		return gameWon;
	}

}
