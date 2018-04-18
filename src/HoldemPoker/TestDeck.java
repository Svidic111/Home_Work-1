package HoldemPoker;

import java.util.ArrayList;
import java.util.Collections;

public class TestDeck {
    private static final ArrayList<Card> deck = new ArrayList<Card>();

    public TestDeck(){
        deck.ensureCapacity(52);
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                deck.add(new Card(rank, suit));
    }


    public Card get(int index) {
        return deck.get(index);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}