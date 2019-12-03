//----------------------------------------------------------------------------
// File name: GameLogicListener.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI 1260 - 201
// Creation Date: 12/01/2019
// Date of Last Modification: 12/01/2019
// ---------------------------------------------------------------------------
package GameUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Interface Name: GameLogicListener <br>
 * Interface Purpose:  This interface made for handling events. <br>
 *
 * <hr>
 * Date created: 12/01/2019 <br>
 * Date last modified: 12/01/2019
 * @author student’s name here
 */
public interface GameLogicListener extends ActionListener{

    /**
     * Method Name: PrintCommand <br>
     * Method Purpose: Prints the command. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param e ActionEvent object
     */
    default public void PrintCommand(ActionEvent e){
        System.out.println(e.getActionCommand().toString()); //gets the command, converts it to a String and prints it
    } //end of PrintCommand(ActionEvent e)

    /**
     * Method Name: CallCommand <br>
     * Method Purpose: Calls the command. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    public void CallCommand(); //end CallCommand

    /**
     * Method Name: actionPerformed <br>
     * Method Purpose: A method needed to be implemented from the ActionListener interface <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param actionEvent ActionEvent object
     */
    @Override
    default public void actionPerformed(ActionEvent actionEvent) {

    } //end actionPerformed(ActionEvent actionEvent)
}

