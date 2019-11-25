package GameUtil;

import Menu.GameMenuGui;
import javax.swing.*;
import java.util.ArrayList;

public abstract class AbstractGameGui extends JPanel {
    private JFrame parent;
    protected GameInterface game;

    public AbstractGameGui(JFrame parent, GameInterface game) {
        super();
        this.parent = parent;
        parent.setSize(getGameWidth(),getGameHeight());
        if(game != null)
            this.game = game;
        if(parent.getJMenuBar().getMenuCount()>1)
            parent.getJMenuBar().remove(1);
        setUp();
        parent.setContentPane(this);
        setVisible(true);
    }
    protected void addPlayers(){
        if(game!=null){
            String playerName;
            int numPlayers = game.getNumPlayers();
            for(int p = 1;p<=numPlayers;p++ ) {
                playerName =
                        (String) JOptionPane.showInputDialog(
                                parent,
                                "Enter New Player Name:",
                                "New Player",
                                JOptionPane.PLAIN_MESSAGE
                        );
                game.addPlayer(new Player(playerName));
            }
        }
    }

    protected JFrame GetParent(){
        return parent;
    }
    public void BackToMenu(){
       new GameMenuGui(parent);

    }
    public GameInterface getGame(){
        return game;
    }
    protected abstract int getGameWidth();
    protected abstract int getGameHeight();
    protected abstract void setUp();
}
