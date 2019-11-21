package TicTacToe;

import GameUtil.*;

import java.util.ArrayList;

public class TicTacToe implements GameInterface {
    private Player x;
    private Player o;
    private Player curr;
    private String[] board;
    private boolean gameWon;
    private ArrayList<String[]> winConditions = new ArrayList<>();
    private int[] winSpots;
    public TicTacToe() {
        x = null;
        o = null;
        curr = x;
        String empty = " ";
        gameWon = false;
        board = new String[9];
        for(int i = 0;i<9;i++){
            board[i] =empty;
        }
    }
    public void setBoardSpot(int index, String set){
        board[index]=set;
        for(int i =1; i<=9;i++){System.out.println();}
    }
    public void seeBoard(){
        System.out.println(board[0]+" "+board[1]+" "+board[2]);
        System.out.println(board[3]+" "+board[4]+" "+board[5]);
        System.out.println(board[6]+" "+board[7]+" "+board[8]);
    }

    @Override
    public Player getCurrPlayer() {
        return curr;
    }

    @Override
    public void addPlayer(Player newPlayer) {
        if(x == null)
            x= newPlayer;
        else
            o=newPlayer;
        curr=o;

    }
    String getCurrPlayerText(){
        String currText = " ";
        if(curr == x) {
            currText= "X";
        }
        else{
            currText=  "O";
        }
        return currText;
    }

    @Override
    public void nextPlayerTurn() {
        if(curr==x)
            curr = o;
        else
            curr = x;
    }

    @Override
    public Boolean gameWon() {
        if(gameWon==false){
            String possibleWins[]=new String[8];
            //check rows
            possibleWins[0] = board[0]+board[1]+board[2];
            possibleWins[1] = board[3]+board[4]+board[5];
            possibleWins[2]= board[6]+board[7]+board[8];
            //check columns
            possibleWins[3] = board[0]+board[3]+board[6];
            possibleWins[4] = board[1]+board[4]+board[7];
            possibleWins[5] = board[2]+board[5]+board[8];
            //check diagonals
            possibleWins[6] = board[0]+board[4]+board[8];
            possibleWins[7] = board[2]+board[4]+board[6];

            for(int i = 0; i<8;i++) {
                //System.out.println(possibleWins[i] + i);
                if (possibleWins[i].equals("XXX")) {
                    gameWon= true;
                    return true;
                } else if (possibleWins[i].equals("OOO")) {
                    gameWon=true;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public int getNumPlayers() {
        return 2;
    }

    @Override
    public void gameOver() {

    }
}
