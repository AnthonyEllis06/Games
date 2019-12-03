/*
 *  ---------------------------------------------------------------------------
 *  File name: BlackJackGui.java
 *  Project name: Games
 *  ---------------------------------------------------------------------------
 *  Creator's name and email: Thomas Roberts, robertstj@etsu.edu
 *  Course:  CSCI 1260
 *  Creation Date: 29-Nov-19
 *  ---------------------------------------------------------------------------
 */

package BlackJack;
import GameUtil.AbstractGameGui;
import GameUtil.Cards.Card;
import GameUtil.Cards.Deck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class Name: BlackJackGui<br>
 * Class Purpose: Contains all the methods necessary for building the Gui.<br>
 *
 * <hr>
 * Date created: 29 NOV 19 <br>
 * Date last modified: 1 DEC 19
 * @author Thomas Roberts
 */
public class BlackJackGui extends AbstractGameGui
{
    // non-Gui variables
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final static BlackJackPlayer player = new BlackJackPlayer("Thomas");    //to hold the player's cards
    private final static BlackJackPlayer dealer = new BlackJackPlayer("Dealer");    //to hold the player's cards
    BlackJack game = new BlackJack(dealer, player, deck);
    private final static Deck deck = new Deck(false);

    // Gui variables
    JPanel topPanel = new JPanel();
    JPanel dealerCardPanel = new JPanel();
    JPanel playerCardPanel = new JPanel();
    JTextPane winLoseBox = new JTextPane();
    JButton hitButton = new JButton();
    JButton dealButton = new JButton();
    JButton stayButton = new JButton();
    JButton playAgainButton = new JButton();
    JLabel dealerLabel = new JLabel();
    JLabel playerLabel = new JLabel();
    JLabel tempJLabel = new JLabel();

    /**
     * Method Name: BlackJackGui(JFrame parent)<br>
     * Method Purpose: The default constructor for the BlackJackGui.<br>
     *
     * <hr>
     * Date created: 1 DEC 19 <br>
     * Date last modified: 1 DEC 19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   Really straightforward stuff. Just setting up the properties of the Gui interface
     *
     * <hr>
     * @param parent Inheriting the AbstractGameGui
     */
    public BlackJackGui(JFrame parent)
    {
        super(parent, new BlackJack(dealer, player, deck));
        addPlayers();
        dealer.resetPlayer();
        player.resetPlayer();
        deck.shuffle();
        topPanel.setBackground(new Color(58, 122, 28));
        dealerCardPanel.setBackground(new Color(58, 122, 28));
        playerCardPanel.setBackground(new Color(58, 122, 28));

        topPanel.setLayout(new FlowLayout());
        winLoseBox.setText(" ");
        winLoseBox.setEnabled(false);
        winLoseBox.setVisible(false);
        winLoseBox.setFont(new Font("Helvetica Bold", Font.BOLD, 20));
        dealButton.setText("  Deal");
        dealButton.addActionListener(new DealButton());
        hitButton.setText("  Hit");
        hitButton.addActionListener(new HitButton());
        hitButton.setEnabled(false);
        stayButton.setText("  Stay");
        stayButton.addActionListener(new StayButton());
        stayButton.setEnabled(false);
        playAgainButton.setText("  Play Again");
        playAgainButton.addActionListener(new PlayAgainButton());
        playAgainButton.setEnabled(false);

        dealerLabel.setText("  Dealer:  ");
        playerLabel.setText("  Player:  ");

        topPanel.add(winLoseBox);
        topPanel.add(dealButton);
        topPanel.add(hitButton);
        topPanel.add(stayButton);
        topPanel.add(playAgainButton);
        playerCardPanel.add(playerLabel);
        dealerCardPanel.add(dealerLabel);

        setLayout(new BorderLayout( ));
        add(topPanel, BorderLayout.NORTH);
        add(dealerCardPanel, BorderLayout.CENTER);
        add(playerCardPanel, BorderLayout.SOUTH);
    }// end BlackJackGui(JFrame parent)

    /**
     * Class Name: DealButton<br>
     * Class Purpose: Contains all the needed functionality for the DealButton.<br>
     *
     * <hr>
     * Date created: 29 NOV 19 <br>
     * Date last modified: 1 DEC 19
     * @author Thomas Roberts
     */
    class DealButton implements ActionListener
    {
        /**
         * Method Name: actionPerformed(ActionEvent e)<br>
         * Method Purpose: An Action Listener that uses an event handler to implement what happens
         * when the user presses on the DealButton.<br>
         *
         * <hr>
         * Date created: 1 DEC 19 <br>
         * Date last modified: 1 DEC 19 <br>
         *
         * <hr>
         * Notes on specifications, special algorithms, and assumptions:
         *   Basically deals the dealer two face down cards and the user two face up cards.
         *   Disables the other buttons after the deal has been pressed to disable people from cheating.
         *
         * <hr>
         * @param e An ActionEvent that is performed when the user clicks on the DealButton
         */
        public void actionPerformed(ActionEvent e)
        {
            //Method variables
            Card tempCard = deck.dealACard();
            playerCardPanel.add(playerLabel);
            player.setName(getGame().getCurrPlayer().getName());

            //Dealer's two cards
            dealer.drawACardToPlayerHand(tempCard);
            tempJLabel = new JLabel(new ImageIcon(tempCard.getCardImage().getAbsolutePath()));
            dealerCardPanel.add(tempJLabel);
            tempCard = deck.dealACard();

            dealer.drawACardToPlayerHand(tempCard);
            tempJLabel = new JLabel(new ImageIcon(tempCard.getCardImage().getAbsolutePath()));
            dealerCardPanel.add(tempJLabel);
            tempCard = deck.dealACard();

            //Player's two cards
            tempCard.setCardFaceUp(true);
            player.drawACardToPlayerHand(tempCard);
            tempJLabel = new JLabel(new ImageIcon(tempCard.getCardImage().getAbsolutePath()));
            playerCardPanel.add(tempJLabel);
            tempCard = new Card(deck.dealACard());

            tempCard.setCardFaceUp(true);
            player.drawACardToPlayerHand(tempCard);
            tempJLabel = new JLabel(new ImageIcon(tempCard.getCardImage().getAbsolutePath()));
            playerCardPanel.add(tempJLabel);
            playerLabel.setText(player.getName() + ": " + player.getPlayerHand().getHandValue());

            // Position for the cards
            add(dealerCardPanel,BorderLayout.CENTER);
            add(playerCardPanel,BorderLayout.SOUTH);

            // Enables and disable buttons with a boolean
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            dealButton.setEnabled(false);

            // Updating the Gui
            revalidate();
            repaint();
        }// end actionPerformed(ActionEvent e)
    }// end DealButton

    /**
     * Class Name: HitButton<br>
     * Class Purpose: Contains all the functionality for the HitButton.<br>
     *
     * <hr>
     * Date created: 29 NOV 19 <br>
     * Date last modified: 1 DEC 19
     * @author Thomas Roberts
     */
    class HitButton implements ActionListener
    {
        /**
         * Method Name: actionPerformed(ActionEvent e)<br>
         * Method Purpose: An Action Listener that uses an event handler to implement what happens
         * when the user presses on the HitButton.<br>
         *
         * <hr>
         * Date created: 1 DEC 19 <br>
         * Date last modified: 1 DEC 19 <br>
         *
         * <hr>
         * Notes on specifications, special algorithms, and assumptions:
         *  Uses an If Statement to iterate through all the players card to determine if they bust or not.
         *  This will also turn over the dealer's cards to see what they had.
         *
         * <hr>
         * @param e An ActionEvent that is performed when the user clicks on the DealButton
         */
        public void actionPerformed(ActionEvent e)
        {
            Card hitCard = deck.dealACard();
            hitCard.setCardFaceUp(true);
            player.drawACardToPlayerHand(hitCard);
            tempJLabel = new JLabel(new ImageIcon(hitCard.getCardImage().getAbsolutePath()));
            playerCardPanel.add(tempJLabel);
            playerCardPanel.repaint();

            if(game.bust(player.getPlayerHand()))
            {
                winLoseBox.setVisible(true);
                winLoseBox.setText("Bust");
                winLoseBox.setBackground(new Color(255,0,0));
                dealer.getPlayerHand().revealHand();
                dealerCardPanel.removeAll();
                for(Card card : dealer.getPlayerHand().getCards())
                {
                    tempJLabel = new JLabel(new ImageIcon(card.getCardImage().getAbsolutePath()));
                    dealerCardPanel.add(tempJLabel);
                }// end for(Card card : dealer.getPlayerHand().getCards())
                dealerLabel.setText("Dealer: " + dealer.getPlayerHand().getHandValue());
                dealerCardPanel.add(dealerLabel);
                hitButton.setEnabled(false);
                dealButton.setEnabled(false);
                stayButton.setEnabled(false);
                playAgainButton.setEnabled(true);
            }// end if(game.bust(player.getPlayerHand()))
            playerLabel.setText((player.getName() + ": " + player.getPlayerHand().getHandValue()));
        }// end actionPerformed(ActionEvent e)
    }// end HitButton

    /**
     * Class Name: StayButton<br>
     * Class Purpose: Contains all the functionality for the StayButton.<br>
     *
     * <hr>
     * Date created: 29 NOV 19 <br>
     * Date last modified: 1 DEC 19
     * @author Thomas Roberts
     */
    class StayButton implements ActionListener
    {
        /**
         * Method Name: actionPerformed(ActionEvent e)<br>
         * Method Purpose: This method is responsible for setting up the StayButton.<br>
         *
         * <hr>
         * Date created: 1 DEC 19 <br>
         * Date last modified: 1 DEC 19 <br>
         *
         * <hr>
         * Notes on specifications, special algorithms, and assumptions:
         *  This part calls the dealerAI to determine if it will hit or stay.
         *  Then displays the dealer's hand and the value of it.
         *  Also disabled buttons that no longer needed.
         *
         * <hr>
         * @param e Inheriting the AbstractGameGui
         */
        public void actionPerformed(ActionEvent e)
        {
            game.dealerAI();
            dealerCardPanel.removeAll();
            dealerCardPanel.add(dealerLabel);
            dealerLabel.setText(" " + dealerLabel.getText());

            dealerLabel.setText("Dealer: " + dealer.getPlayerHand().getHandValue());
            playerLabel.setText(player.getName() + ": " + player.getPlayerHand().getHandValue());

            winLoseBox.setVisible(true);
            winLoseBox.setText(game.winner());
            dealer.getPlayerHand().revealHand();
            dealerCardPanel.removeAll();
            for(Card card : dealer.getPlayerHand().getCards())
            {
                tempJLabel = new JLabel(new ImageIcon(card.getCardImage().getAbsolutePath()));
                dealerCardPanel.add(tempJLabel);
            }//end for(Card card : dealer.getPlayerHand().getCards())

            dealerLabel.setText("Dealer: " + dealer.getPlayerHand().getHandValue());
            dealerCardPanel.add(dealerLabel);
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            playAgainButton.setEnabled(true);
        }// end actionPerformed(ActionEvent e)
    }// end StayButton

    /**
     * Class Name: PlayAgainButton<br>
     * Class Purpose: Contains all the functionality for the PlayAgainButton.<br>
     *
     * <hr>
     * Date created: 29 NOV 19 <br>
     * Date last modified: 1 DEC 19
     * @author Thomas Roberts
     */
    class PlayAgainButton implements ActionListener
    {
        /**
         * Method Name: actionPerformed(ActionEvent e)<br>
         * Method Purpose: This method is responsible for setting up the PLayAgainButton..<br>
         *
         * <hr>
         * Date created: 1 DEC 19 <br>
         * Date last modified: 1 DEC 19 <br>
         *
         * <hr>
         * Notes on specifications, special algorithms, and assumptions:
         *   Basically restarts the game
         *   Restarts the player, dealer, and deck
         *   Also will shuffle the deck with deck.reset method
         *
         * <hr>
         * @param e Inheriting the AbstractGameGui
         */
        public void actionPerformed(ActionEvent e)
        {
            dealerLabel.setText("Dealer: ");
            playerLabel.setText(player.getName() + ": ");
            winLoseBox.setText("");
            winLoseBox.setVisible(false);
            game = new BlackJack(dealer, player, deck);
            deck.resetDeck();

            dealerCardPanel.removeAll();
            playerCardPanel.removeAll();
            player.resetPlayer();
            dealer.resetPlayer();

            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            playAgainButton.setEnabled(false);
            dealButton.setEnabled(true);
        }// end actionPerformed(ActionEvent e)
    }// end PlayAgainButton

    @Override
    protected int getGameWidth ( )
    {
        return WIDTH;
    }

    @Override
    protected int getGameHeight ( )
    {
        return HEIGHT;
    }

    @Override
    protected void setUp()
    {

    }
}// end BlackJackGui