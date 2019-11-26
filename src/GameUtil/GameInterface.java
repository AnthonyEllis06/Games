package GameUtil;

public interface GameInterface extends GameLogicListener{
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
    Player getCurrPlayer();
    void addPlayer(Player newPlayer);
    void nextPlayerTurn();
    Boolean gameWon();
    int getNumPlayers();
    Boolean gameOver();
}
