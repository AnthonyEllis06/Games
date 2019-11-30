package Checkers;

import GameUtil.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Checkers implements GameInterface{

    private CheckerTile[][] board;
    public Checkers() {
        board = new CheckerTile[8][8];
        makeBoard();
        setBoard();
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
    private void setBoard(){
        boolean startFirst = false;
        for(int y = 0 ; y<=7; y++){
            int x =1;
            if(startFirst)
                x=0;
            for(; x<=7; x+=2){
                if(y<3){
                    new Checker(board[y][x], Color.RED);
                }
                if(y>4){
                    new Checker(board[y][x], Color.BLACK);
                }

            }
            startFirst = !startFirst;
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
    public void move(CheckerTile tileStart, CheckerTile tileFinish){
        int vert = Coordinate.CompareCoordinates(tileFinish.getCoordinate(), tileStart.getCoordinate());
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
    public Boolean gameOver() {
        return false;
    }

    @Override
    public void CallCommand(ActionEvent e) {

    }
}
