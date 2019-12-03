package War;/*
 * ---------------------------------------------------------------------------
 * File name: Face.java
 * Project name: FinalProject
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jacey Barrett, barrettjt@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 11/29/2019
 * ---------------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * This class gives each Face card a value.
 */
public enum Face
{
	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13);

	private int value;
	private static Map map = new HashMap<>();

	/**
	 *
	 * @param value - int number assigned to each enum
	 */
	private Face(int value)
	{
		this.value = value;
	}

	/**
	 * Maps every face value to a HashMap.
	 */
	static
	{
		for(Face face : Face.values())
		{
			map.put(face.value, face);
		}
	}

	/**
	 * Finds the value of each item in a HashMap.
	 * @param face
	 * @return
	 */
	public static Face getValueOf(int face)
	{
		return (Face) map.get(face);
	}

	/**
	 * returns vale of each Face enum.
	 * @return
	 */
	public int getValue()
	{
		return value;
	}

}
