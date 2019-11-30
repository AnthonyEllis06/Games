package Checkers;

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
    public static int CompareCoordinates(Coordinate c1, Coordinate c2){
        int vertDifference = c1.getY()-c2.getY();
        if(vertDifference > 1 || vertDifference < -1)
            return 0;
        else
            return vertDifference;
    }
}
