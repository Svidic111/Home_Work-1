package HoldemPoker;

public class PlayerHand {
    private Hand hand;
    private Card handTopCard;
    private Card[] handCards;

    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Card getHandTopCard() {
        return handTopCard;
    }
    public void setHandTopCard(Card handTopCard) {
        this.handTopCard = handTopCard;
    }
    public Card[] getHandCards() {
        return handCards;
    }
    public void setHandCards(Card[] handCards) {
        this.handCards = handCards;
    }
}
