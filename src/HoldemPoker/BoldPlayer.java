package HoldemPoker;

public class BoldPlayer extends Player {

    private Card pocketCard1;
    private Card pocketCard2;

    public BoldPlayer(String name) {
        super(name);
    }


    @Override
    public void setPocketCards(Card pocketCard1, Card pocketCard2) {
        this.pocketCard1 = pocketCard1;
        this.pocketCard2 = pocketCard2;
    }

    @Override
    public void showCards() {
        System.out.println(super.getName() + " cards: [" + pocketCard1.toString() + "] " + "[" + pocketCard2.toString() + "] ");
    }

    @Override
    public String action() { // всегда играет, независимо от карт на руках
        return "b";
    }
}
