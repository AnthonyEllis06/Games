package Checkers;

import javafx.scene.layout.CornerRadii;

public class Coordinate {
    private int x;
    private int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int[] getCoordinates(){
        return new int[]{x,y};
    }
}
