package TicTacToe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToeTile extends JPanel {
    private ArrayList<TicTacToeTile> directions;
    private JLabel tileButton;
    private String text;
    private boolean reserved;
    private int position;
    public TicTacToeTile(int position){
        super(new BorderLayout());

        tileButton = new JLabel(" ", SwingConstants.CENTER);
        tileButton.setFont(new Font(Font.SERIF, Font.BOLD,50 ));
        setBorder(new BevelBorder(1));
        add(tileButton, BorderLayout.CENTER);
        reserved= false;
        this.position = position;
    }
    public void setText(String text){
        if(reserved != true){
            this.text = text;
            tileButton.setText(text);
            reserved = true;
        }
    }
    public int getPosition(){
        return position;
    }


}
