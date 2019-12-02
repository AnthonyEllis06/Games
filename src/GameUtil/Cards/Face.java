/*
 *  ---------------------------------------------------------------------------
 *  File name: Face.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 21-Nov-19
 *  ---------------------------------------------------------------------------
 */

package GameUtil.Cards;

/**
 * Class Name: Face <br>
 * Class Purpose: Contains all the Faces needed for a deck of cards <br>
 *
 * <hr>
 * Date created: 21 NOV 19 <br>
 * Date last modified: 21 NOV 19
 * @author Thomas Roberts
 */
public enum Face
{
	ACE(1),
	DEUCE(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(10),
	QUEEN(10),
	KING(10);

	private int value;
	Face(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
} //end Face
