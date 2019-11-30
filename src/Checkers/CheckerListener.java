package Checkers;

public interface CheckerListener {
    public void move(Checker checker, CheckerTile start, CheckerTile finish);
    public void jump(Checker checker, CheckerTile start, CheckerTile finish);
}
