package Checkers;
import GameUtil.AbstractGameGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.Serializable;
import java.util.Arrays;

//----------------------------------------------------------------------------
// File name: CheckersGui.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Amber Stanifer, stanifera@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: CheckersGui <br>
 * Class Purpose: Creates the Checker's GUI <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Amber Stanifer
 */
public class CheckersGui extends AbstractGameGui implements Serializable {
    private final int WIDTH = 800; //sets the width of the JFrame
    private final int HEIGHT = 800; //set the height of the JFrame
    Checkers checkers; //Makes copy of game logic

    /**
     * Method Name: CheckersGui <br>
     * Method Purpose: Constructor for calling the super class <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     *   @param  parent the JFrame from AbstractGameGUI
     */
    public CheckersGui(JFrame parent) {
        super(parent, null);

    }

    /**
     * Method Name: getGameWidth <br>
     * Method Purpose: Simple getter of the game's width <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     * @return an int containing the game's width
     */
    @Override
    protected int getGameWidth() {
        return WIDTH;
    }

    /**
     * Method Name: getGameHeight <br>
     * Method Purpose: Simple getter of the game's height <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     * @return an int containing the game's height
     */
    @Override
    protected int getGameHeight() {
        return HEIGHT;
    }

    /**
     * Method Name: setUp <br>
     * Method Purpose: Sets up the GUI for checkers <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    @Override
    public void setUp()
    {
        setLayout(new GridLayout(8,8)); //A grid layout that has 8 rows and 8 columns for a total of 64 tiles
        checkers= new Checkers(); //generates a new checkerboard

        //sets the checker tiles for each sides
        CheckerTile temp;
        for(int x = 0; x<8;x++){
            for(int y = 0; y<8; y++){
                temp = checkers.getCheckerTile(x,y);
                temp.addContainerListener(new ContainerListener() {
                    @Override
                    public void componentAdded(ContainerEvent e) {

                    }

                    @Override
                    public void componentRemoved(ContainerEvent e) {
                        Arrays.stream(getComponents()).forEach(component->{
                            component.revalidate();
                        component.repaint();});
                    }
                });
                add(temp);
            }
        }

        repaint(); //repaint components that have changed that can affect the layout
    }

}

