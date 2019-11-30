package GameUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface GameLogicListener extends ActionListener{
    default public void PrintCommand(ActionEvent e){
        System.out.println(e.getActionCommand().toString());
    }
    public void CallCommand();
    @Override
    default public void actionPerformed(ActionEvent actionEvent) {

    }
}
