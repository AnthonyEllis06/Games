package Checkers;

import GameUtil.*;

import java.awt.*;
import java.util.ArrayList;

public class Checkers implements GameInterface{

    private CheckerTile[][] board;
    public Checkers() {
        board = new CheckerTile[8][8];
        makeBoard();
    }
    private void makeBoard(){
        Color curr=Color.RED;
        for(int x = 0; x <8; x++) {
            for (int y = 0; y < 8; y++){
                board[x][y] = new CheckerTile(curr,x,y);
                curr = getNextColor(curr);
            }
            curr=getNextColor(curr);
        }

    }
    private Color getNextColor(Color curr){
        if(curr.equals(Color.RED)){
            return Color.GRAY;
        }
        else{
            return Color.RED;
        }
    }
    public CheckerTile getCheckerTile(int x, int y){
        return board[x][y];
    }
    @Override
    public void play() {

    }

    @Override
    public Player getCurrPlayer() {
        return null;
    }

    @Override
    public void addPlayer(Player newPlayer) {

    }


    @Override
    public void nextPlayerTurn() {

    }

    @Override
    public Boolean gameWon() {
        return null;
    }

    @Override
    public int getNumPlayers() {
        return 0;
    }

    @Override
    public void gameOver() {

    }
}
