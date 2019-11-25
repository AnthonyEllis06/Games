package GameUtil;

public interface GameInterface {
    default void play(){
        while(!gameWon()){
            nextPlayerTurn();
        }
        gameOver();
    }
    Player getCurrPlayer();
    void addPlayer(Player newPlayer);
    void nextPlayerTurn();
    Boolean gameWon();
    int getNumPlayers();
    void gameOver();
}
