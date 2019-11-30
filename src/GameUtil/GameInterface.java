package GameUtil;

public interface GameInterface extends GameLogicListener{

    //The idea is to have the play method in this game interface make the games al run similar and smooth.
    //It works by continuously making players take turns
    // needs notify to be used to allow players for use strats
    default void play(){
        int numPlayers = getNumPlayers();
        Player curr = getCurrPlayer();
        for (int i = 0; i<numPlayers;i++){
            if(curr!= null){
                addPlayer(curr);
            }
        }
        while(!gameOver()){
            for(int i = 0;i<numPlayers;i++)
                nextPlayerTurn();
                gameWon();
        }
        gameOver();
    }
    //returns current player
    Player getCurrPlayer();
    //used in play to add nwew players
    void addPlayer(Player newPlayer)
    //sets the turn for the next player;
    void nextPlayerTurn();
    //checks if game is won in win condition.
    Boolean gameWon();
    //returns the total amount of players
    int getNumPlayers();
    //used to see if game is over and also where you can
    //do cals for a custom game over.
    Boolean gameOver();
}
