package GameUtil.Cards;

import java.util.Collections;
import java.util.LinkedList;

public class Cards<T> extends LinkedList<T> {
    private boolean sorted;

    public Cards() {
        super();
    }

    public void addCardTop(T card){
        addFirst(card);
    }
    public void addCardBottom(T card){
        addLast(card);
    }
    public T getTop(){
        return getFirst();
    }
    public T getBottom(){
        return getLast();
    }
    public Cards<T> dealFromTop(int numCards){
        Cards<T> hand = new Cards();
        while(numCards>0){
            hand.add(removeFirst());
            numCards--;
        }
        return hand;
    }
    public Cards<T> dealFromBottom(int numCards){
        Cards<T> hand = new Cards<>();
        while(numCards>0){
            hand.add(removeLast());
            numCards--;
        }
        return hand;
    }

    public void shuffle(){
        Collections.shuffle(this);
    }
}
