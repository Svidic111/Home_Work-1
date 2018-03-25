package HoldemPoker;

import java.util.Scanner;

public class Player {
    private Card pocketCard1;
    private Card pocketCard2;
    private Hand hand;
    private Card kicker;
    private Card handTop;

    public Card getHandTop() {
        return handTop;
    }
    public Hand getHand() {
        return hand;
    }
    public Card getKicker() {
        return kicker;
    }
    public Card getPocketCard1() {
        return pocketCard1;
    }
    public Card getPocketCard2() {
        return pocketCard2;
    }
    public void showCards() {
        System.out.println("Your cards: [" + pocketCard1.toString() + "] " + "[" + pocketCard2.toString() + "] ");
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
    public void setKicker(Card kicker) {
        this.kicker = kicker;
    }


    public int action() {
        int action;
        int userInput;
        boolean legalInput; // проверка правильности ввода
        do {
            System.out.println("Push '1' to bet, or '0' to pass.");
            Scanner input = new Scanner(System.in);
            userInput = input.nextInt();
           legalInput = (userInput == 0 || userInput == 1);
        } while (!legalInput); // если ввод был правильным, цикл закончиться, если ввели что-то кроме 'B' или 'P', то цикл продолжится
        action = userInput;
        return action;
    }
}
