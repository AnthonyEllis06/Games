/*
 *  ---------------------------------------------------------------------------
 *  File name: Driver.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 26-Nov-19
 *  ---------------------------------------------------------------------------
 */

package GameUtil.Cards;

import javax.swing.*;
import java.awt.*;

/**
 * Class Name: Driver <br>
 * Class Purpose: Not needed but this is what I used to test my methods. <br>
 *
 * <hr>
 * Date created: 26 NOV 19 <br>
 * Date last modified: 26 NOV 19
 * @author Thomas Roberts
 */
public class Driver
{
	/**
	 * Method Name: main(String[] args) <br>
	 * Method Purpose: The driver used to test the program. Play around with it to test the methods<br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Mainly used for debugging purposes.
	 *
	 * <hr>
	 * @param args The heart of the driver.
	 */
	public static void main(String[] args)
	{
		Card defaultCard = new Card();
		defaultCard.setCardFaceUp(true);

//		JFrame frame = new JFrame();
//		ImageIcon icon = new ImageIcon(defaultCard.getCardImage().getAbsolutePath());
//		JLabel label = new JLabel(icon);
//		frame.add(label);
//		frame.setDefaultCloseOperation
//				(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);

		System.out.println("The default card is: " + defaultCard);
		System.out.println("The picture is located at: " + defaultCard.getCardImage().getPath());

		System.out.println("All 52 cards follow: ");
		Deck deckToPlayWith = new Deck(false);
		String toStringTestForDeck = deckToPlayWith.toString();
		System.out.println(toStringTestForDeck);

		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(2,3));

		for(Card card : deckToPlayWith.getDeck())
		{
			ImageIcon icon = new ImageIcon(card.getCardImage().getAbsolutePath());
			JLabel label = new JLabel(icon);
			frame.add(label);
			frame.setDefaultCloseOperation
					(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}// end for(Card card : deckToPlayWith.getDeck())

		System.out.println("Shuffled deck: ");
		deckToPlayWith.shuffle();
		System.out.println(deckToPlayWith);

		System.out.println("Sorted deck: ");
		deckToPlayWith.sortDeck();
		System.out.println(deckToPlayWith);

		Card cardToDeal = deckToPlayWith.dealACard();
		cardToDeal.setCardFaceUp(true);
		System.out.println("Deal a card: " + cardToDeal);

	}// end main
}// end Driver
