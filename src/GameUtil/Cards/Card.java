/*
 *  ---------------------------------------------------------------------------
 *  File name: Card.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 25-Nov-19
 *  ---------------------------------------------------------------------------
 */

package GameUtil.Cards;
import java.io.File;

/**
 * Class Name: Card <br>
 * Class Purpose: Contains all the methods necessary for a what a card object should represent <br>
 *
 * <hr>
 * Date created: 26 NOV 19 <br>
 * Date last modified: 26 NOV 19
 * @author Thomas Roberts
 */
public class Card
{
	//Class level variables
	private File frontOfCard;   //this is the image for the front of the card
	private File backOfCard;    //this is the image for the back of the card
	private Suit suit;
	private Face face;
	private boolean isCardFaceUp;   //if a card should be face up or face down

	/**
	 * Method Name: Card(int suit, int face) <br>
	 * Method Purpose: A default constructor a card. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Mainly used for debugging purposes. A default card should always be a 2 of clubs
	 *   The frontOfCard is an image for the program to use for the back of the card. It needs the correct file path.
	 *   The backOfCard is an image for the program to use for the back of the card. It needs the correct file path.
	 * <hr>
	 *
	 */
	public Card()
	{
		this.suit = Suit.HEARTS;
		this.face = Face.ACE;
		this.isCardFaceUp = true;
		this.frontOfCard = new File("Images/" + this.toString() + ".jpg");
		this.backOfCard = new File("Images/back of card.jpg");
	}// end Card()

	/**
	 * Method Name: Card(Card existingCard) <br>
	 * Method Purpose: A copy constructor a card. <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Copies the attributes of one card into another card
	 *
	 * <hr>
	 * @param existingCard An existing card needed for the copy constructor
	 */
	public Card(Card existingCard)
	{
		this.suit = existingCard.suit;
		this.face = existingCard.face;
		this.isCardFaceUp = existingCard.isCardFaceUp;
		this.frontOfCard = existingCard.frontOfCard;
		this.backOfCard = existingCard.backOfCard;
	}// end Card(Card existingCard)

	/**
	 * Method Name: Card(Suit suit, Face face, boolean isCardFaceUp) <br>
	 * Method Purpose: A constructor that determines face, suit, and if the card is face up <br>
	 *
	 * <hr>
	 * Date created: 26 NOV 19 <br>
	 * Date last modified: 26 NOV 19 <br>
	 *
	 * <hr>
	 * Notes on specifications, special algorithms, and assumptions:
	 *   Not really needed but I figured I'd include it anyways just in case.
	 *
	 * <hr>
	 * @param suit The suit of the card
	 * @param face The fact of the card
	 * @param isCardFaceUp Determines if the card is face up or face down
	 */
	public Card(Suit suit, Face face, boolean isCardFaceUp)
	{
		this.isCardFaceUp = isCardFaceUp;
		this.face = face;
		this.suit = suit;
		this.frontOfCard = new File("Images/" + "the " + face.toString().toLowerCase() + " of " + suit.toString().toLowerCase() + ".jpg");
		this.backOfCard = new File("Images/back of card.jpg");
	}// end Card(int suit, int face)

	public File getCardImage()
	{
		if(isCardFaceUp)
		{
			return frontOfCard;
		}// end if(isCardFaceUp)
		else
		{
			return backOfCard;
		}// end else
	}// end getCardImage()

	public Suit getSuit()
	{
		return suit;
	}// end getSuit()

	public Face getFace()
	{
		return face;
	}// end getFace()

	public boolean isCardFaceUp()
	{
		return isCardFaceUp;
	}//end isCardFaceUp()

	public void setCardFaceUp(boolean cardFaceUp)
	{
		this.isCardFaceUp = cardFaceUp;
	}//end setCardFaceUp(boolean cardFaceUp)

	public int determineValueOfCard()
	{
		return this.face.getValue();
	}

	/**
	 * Method Name: toString() <br>
	 * Method Purpose: Overriding the default toString.<br>
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
	 * @return Returns a string describing the card.
	 */
	@Override
	public String toString()
	{
		if(this.isCardFaceUp)
		{
			return "the " + face.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
		}// end if(this.isCardFaceUp)
		else
		{
			return "******";
		} //end else
	}// end public String toString()
} //end Card