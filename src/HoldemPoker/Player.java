package HoldemPoker;

import java.util.Scanner;

public class Player implements HoldemPoker.Abstractions.Player, Comparable<Player>{
    private String name;
    private Card pocketCard1;
    private Card pocketCard2;
    private Hand hand;
    private Card[] handCards;
    private Card handTop;
    private Card kicker;

    public Player(String name) {
        this.name = name;
    }

    public Card getKicker() {
        return kicker;
    }
    public String getName() {
        return name;
    }
    public Card getHandTop() {
        return handTop;
    }
    public Hand getHand() {
        return hand;
    }
    public Card[] getHandCards() {
        return handCards;
    }
    public Card getPocketCard1() {
        return pocketCard1;
    }
    public Card getPocketCard2() {
        return pocketCard2;
    }

    @Override
    public void showCards() {
        System.out.println(this.name + " cards: [" + pocketCard1.toString() + "] " + "[" + pocketCard2.toString() + "] ");
    }

    public void setKicker() {
        Card pocketCard1 = this.pocketCard1;
        Card pocketCard2 = this.pocketCard2;

        if (pocketCard1.getRankInt() > pocketCard2.getRankInt()) {
            this.kicker = pocketCard1;
        } else this.kicker = pocketCard2;
    }

    public void setHandTop(Card handTop) {
        this.handTop = handTop;
    }
    public void setPocketCards(Card pocketCard1, Card pocketCard2) {
        this.pocketCard1 = pocketCard1;
        this.pocketCard2 = pocketCard2;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public void setHandCards(Card[] handCards) {
        this.handCards = handCards;
    }

    @Override
    public String action() {
        String action;
        String userInput;
        boolean legalInput; // проверка правильности ввода
        do {
            System.out.println("Push 'c' to continue, or 's' to stop the game");
            Scanner input = new Scanner(System.in);
            userInput = input.nextLine();
           legalInput = (userInput.intern() == "c" || userInput.intern() == "s");
        } while (!legalInput); // если ввод был правильным, цикл закончиться, если ввели что-то кроме "b", "s", "p", то цикл продолжится
        action = userInput;
        return action;
    }

    @Override
    public int compareTo(Player o) {
        return this.hand.getHandRank() - o.hand.getHandRank();
    }
}
