package Checkers;

public interface CheckerListener {
    public boolean move(Checker checker, CheckerTile start, CheckerTile finish);
    public boolean jump(Checker checker, CheckerTile start, CheckerTile finish);
}
