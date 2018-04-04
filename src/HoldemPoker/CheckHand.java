package HoldemPoker;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Arrays;

public class CheckHand {

//    public static void bubbleSort(int[] items) {
//        for (int j = 0; j < items.length; j++) {
//            int left, right;
//            for (int i = 1; i < items.length - j; i++) {
//                left = i - 1;
//                right = i;
//                if (items[right] < items[left]) {
//                    int tmp = items[left];
//                    items[left] = items[right];
//                    items[right] = tmp;
//                }
//            }
//        }
//
//    }

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
        Arrays.sort(ranks);  // сортируем карты по возрастанию

        for (int i = 1; i < ranks.length; i++) { // если след-я карта массива больше пред-й на 1, то добавляем одно звено цепочки стрита
            if (ranks[i] - ranks[i-1] == 1) {
                straightTopCard = ranks[i];
                chainBlock++;
            }
            if (ranks[i] - ranks[i-1] > 1 && chainBlock <4) {
                straightTopCard = 5;
                chainBlock = 0;
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

    public static String checkPairs(Card[] handBoard) {
        int match1 = 0;
        int match2 = 0;
        String answer = "";
        String answer1 = "";
        String answer2 = "";

        for (int i = 2; i < handBoard.length; i++) {   // определяем совпадение старшинства каждой карты игрока с бордом
            if (handBoard[0].getRankInt() == handBoard[i].getRankInt()) {
                match1++;
            }
            if (handBoard[1].getRankInt() == handBoard[i].getRankInt()) {
                match2++;
            }
        }
        switch (match1) { // определяем комбинацию, которую составляет 1-я карта игрока
            case 1:
                answer1 = Hand.PAIR.toString() + " of " + handBoard[0].getRank();
                break;
            case 2:
                answer1 = Hand.SET.toString() + " of " + handBoard[0].getRank();
                break;
            case 3: // карэ возвращаем сразу
                answer1 = Hand.KARE.toString() + " of " + handBoard[0].getRank();
                return answer1;
        }
        switch (match2) { // определяем комбинацию, которую составляет 2-я карта игрока
            case 1:
                answer2 = Hand.PAIR.toString() + " of " + handBoard[1].getRank();
                break;
            case 2:
                answer2 = Hand.SET.toString() + " of " + handBoard[1].getRank();
                break;
            case 3: // карэ возвращаем сразу
                answer2 = Hand.KARE.toString() + " of " + handBoard[1].getRank();
                return answer2;
        }

        if (match1 != 0 && match2 == 0) { // проверка простой пары или сета
            return answer1;
        }
        if (match1 == 0 && match2 != 0) { // проверка простой пары или сета
            return answer2;
        }
        if (match1 == match2) { // проверка на 2-х пар
            answer = Hand.TWOPAIRS.toString() + " of " + handBoard[0].getRank() + " and " + handBoard[1].getRank();
            return answer;
        }
        if (match1 == 1 && match2 == 2) { // проверка на фулхаус
            answer = Hand.FULLHOUS.toString() + " of " + answer1 + " and " + answer2;
            return answer;
        }
        if (match1 == 2 && match2 == 1) { // проверка на фулхаус
            answer = Hand.FULLHOUS.toString() + " of " + answer1 + " and " + answer2;
            return answer;
        }

        return answer;
    }
}
