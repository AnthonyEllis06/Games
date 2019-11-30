package GameUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface GameLogicListener{
    default public void PrintCommand(ActionEvent e){
        System.out.println(e.getActionCommand().toString());
    }
    public void CallCommand(ActionEvent e);
}
