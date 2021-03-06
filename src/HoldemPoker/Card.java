package HoldemPoker;

public class Card implements Comparable<Card>{
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() { return rank; }
    public int getRankInt() { return rank.getRankInt(); }
    public Suit getSuit() { return suit; }
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.getRankInt() - o.getRankInt();
    }


}
