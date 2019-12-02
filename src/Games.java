import GameUtil.AbstractGameGui;
import Menu.GameMenuGui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//----------------------------------------------------------------------------
// File name: Games.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: Games <br>
 * Class Purpose: Runs all games <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Anthony Ellis
 */
public class Games extends JFrame implements ActionListener
{
    public AbstractGameGui currentPanel;

    /**
     * Method Name: Games <br>
     * Method Purpose: builds the JFrame and adds menu bar<br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    public Games(){
        super("Games");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BorderLayout border = new BorderLayout();
        setResizable(true);
        JMenuBar menuBar = new JMenuBar();
        JButton toMenu = new JButton("Game Menu");
        toMenu.addActionListener(this);
        menuBar.add(toMenu);
        setJMenuBar(menuBar);
        currentPanel = new GameMenuGui(this);
        setVisible(true);
    }

    /**
     * Method Name: mains <br>
     * Method Purpose: main runs the game <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    public static void main(String args[]){
        new Games();
    }

    /**
     * Method Name: actionPerformed <br>
     * Method Purpose: navigate back to main menu <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        currentPanel.BackToMenu();
    }
}
