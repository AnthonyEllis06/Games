package War;/*
 * ---------------------------------------------------------------------------
 * File name: WarGui.java
 * Project name: FinalProject
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jacey Barrett, barrettjt@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 12/1/2019
 * ---------------------------------------------------------------------------
 */


import GameUtil.AbstractGameGui;
import GameUtil.*;

import javax.swing.*;

/**
 * This class establishes the gui within the program.
 */
public class WarGui extends AbstractGameGui
{
	private final int WIDTH = 500;
	private final int HEIGHT = 500;

	/**
	 * Builds frame of GUI.
	 * @param parent
	 */
	public WarGui(JFrame parent)
	{
		super(parent, new GameInterface( ) {
			@Override
			public Player getCurrPlayer ( )
			{
				return null;
			}

			@Override
			public void addPlayer (Player newPlayer)
			{

			}

			@Override
			public void nextPlayerTurn ( )
			{

			}

			@Override
			public Boolean gameWon ( )
			{
				return null;
			}

			@Override
			public int getNumPlayers ( )
			{
				return 0;
			}

			@Override
			public Boolean gameOver ( )
			{
				return null;
			}

			@Override
			public void CallCommand ( )
			{

			}
		}
	);

	}

	@Override
	/**
	 * Returns width of game window.
	 */
	protected int getGameWidth() {
		return WIDTH;
	}

	@Override
	/**
	 * Returns height of game.
	 */
	protected int getGameHeight() {
		return HEIGHT;
	}

	@Override
	/**
	 * Builds gui.
	 */
	protected void setUp() {
		//Build Gui Here
	}
}
