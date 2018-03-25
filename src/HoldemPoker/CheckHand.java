package HoldemPoker;

import java.util.Arrays;

public class CheckHand {

    public static void bubbleSort(int[] items) {
        for (int j = 0; j < items.length; j++) {
            int left, right;
            for (int i = 1; i < items.length - j; i++) {
                left = i - 1;
                right = i;
                if (items[right] < items[left]) {
                    int tmp = items[left];
                    items[left] = items[right];
                    items[right] = tmp;
                }
            }
        }

    }

    public static String checkFlush(Card[] handBoard) {
        int suitMatch = 0; // кол-во совпадений по масти
        String suit;
        String answer = "False";

        for (int i = 1; i < handBoard.length; i++) { // проверяем совпадение масти первой карты игрока
            if (handBoard[0].getSuit() == handBoard[i].getSuit()) {
                suitMatch++;
            }
        }
        if (suitMatch >= 4) {
            suit = handBoard[0].getSuit().toString();
            answer = "FLUSH" + " of " + suit;
            return answer;
        } else {     // меняем местами 1 и 2 карты игрока и проверяем совпадение масти первой карты игрока
            Card[] temp = new Card[1];
            temp[0] = handBoard[0];
            handBoard[0] = handBoard[1];
            handBoard[1] = temp[0];
            suitMatch = 0;

            for (int i = 1; i < handBoard.length; i++) {
                if (handBoard[0].getSuit() == handBoard[i].getSuit()) {
                    suitMatch++;
                }
            }
        }
        if (suitMatch >= 4) {
            suit = handBoard[0].getSuit().toString();
            answer = "FLUSH of " + suit;
            return answer;
        }
        return answer;
    }

    public static String checkStraight(Card[] handBoard) {
        int chainBlock = 0; // кол-во связей между картами возможного стрита
        String answer = "False";
        int straightTopCard = 5;

        int[] ranks = new int[7];
        for (int i = 0; i < 7; i++) {
            ranks[i] = handBoard[i].getRankInt(); // заполняем массив числами, соответствующими старшинству карт
        }
        bubbleSort(ranks);  // сортируем карты по возрастанию

        for (int i = 1; i < ranks.length; i++) { // если след-я карта массива больше пред-й на 1, то добавляем одно звено цепочки стрита
            if (ranks[i] - ranks[i-1] == 1) {
                straightTopCard = ranks[i];
                chainBlock++;
            }
        }
        if (ranks[0] == 2 && ranks[6] == 14 && ranks[5] != 13 && ranks[4] != 13) { // если в борде есть туз и двойка, добавляем еще одно звено
            straightTopCard = 5;
            chainBlock++;
        }

        String topCard = "FIVE";             // определяем старшую карту стрита
        for (int i = 0; i < ranks.length; i++) {
            if (straightTopCard == handBoard[i].getRankInt()) {
                topCard = handBoard[i].getRank().name();
            }
        }

        if (chainBlock >= 4) {    // если выстроилась цепочка с 4 звеньями, которые соединяют 5 карт в ряд, то у нас есть стрит
            answer = "STRAIGHT" + " to " + topCard;
            return answer;
        }
        return answer;
    }

}
