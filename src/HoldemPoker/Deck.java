package HoldemPoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private static final LinkedList<Card> deck = new LinkedList<Card>();

    public Deck(){
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                deck.addFirst(new Card(rank, suit));
    }

    public Card pollCard() {
        return deck.poll();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}
