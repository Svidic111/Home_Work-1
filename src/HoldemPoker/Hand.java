package HoldemPoker;

public enum Hand {
    KICKER(1), PAIR(2), TWOPAIRS(3), SET(4), STRAIGHT(5), FLUSH(6), FULLHOUS(7), KARE(8), STRAIGHTFLUSH(9), ROYALFLUSH(10);

    private int HandRank;

    Hand(int HandRank){
        this.HandRank = HandRank;
    }

    public int getHandRank() {
        return HandRank;
    }
}
