package HoldemPoker;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CheckHand {

    private static Card getHandTop(Card[] hand) { // метод возвращает старшую карту комбинации
        Card handTopCard = hand[0];
        for (Card c: hand) {
            if (c!= null) {
                if (handTopCard.getRankInt() <= c.getRankInt()) {
                    handTopCard = c;
                }
            }
        }
        return handTopCard;
    }

    public static PlayerHand checkFlush(Card[] handBoard) {
        PlayerHand FlushHand = new PlayerHand();
        int suitMatch = 0; // кол-во совпадений по масти

        for (int i = 1; i < handBoard.length; i++) { // проверяем совпадение масти первой карты игрока
            if (handBoard[0].getSuit() == handBoard[i].getSuit()) {
                suitMatch++;
            }
        }

        if (suitMatch >= 4) {  // выделили в один массив все карты необходимой масти
            Card[] flushCards = new Card[7];
            flushCards[0] = handBoard[0];
            for (int i = 1, j = 1; i < handBoard.length; i++) {
                if (handBoard[0].getSuit() == handBoard[i].getSuit()) {
                    flushCards[j] = handBoard[i];
                    j++;
                }
            }
            FlushHand.setHand(Hand.FLUSH);
            FlushHand.setHandTopCard(getHandTop(flushCards));
            FlushHand.setHandCards(flushCards);
            return FlushHand;
        }
        else {     // меняем местами 1 и 2 карты игрока и проверяем совпадение масти первой карты игрока
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
        if (suitMatch >= 4) {  // выделили в один массив все карты необходимой масти
            Card[] flushCards = new Card[7];
            flushCards[0] = handBoard[0];
            for (int i = 1, j = 1; i < handBoard.length; i++) {
                if (handBoard[0].getSuit() == handBoard[i].getSuit()) {
                    flushCards[j] = handBoard[i];
                    j++;
                }
            }
            FlushHand.setHand(Hand.FLUSH);
            FlushHand.setHandTopCard(getHandTop(flushCards));
            FlushHand.setHandCards(flushCards);
            return FlushHand;
        }
        return FlushHand;
    }

    public static PlayerHand checkStraight(Card[] hB) {
        int chainBlock = 0; // кол-во связей между картами возможного стрита
        PlayerHand StraightHand = new PlayerHand();
        Card straightTopCard = null;

        Card[] handBoard = hB;
        Arrays.sort(handBoard);  // сортируем карты по возрастанию

        if (handBoard[0].getRankInt() == 2 && handBoard[6].getRankInt() == 14) { // если в борде есть туз и двойка, добавляем еще одно звено
            chainBlock++;
        }
        for (int i = 1; i < handBoard.length; i++) { // если след-я карта массива больше пред-й на 1, то добавляем одно звено цепочки стрита
            if (handBoard[i].getRankInt() - handBoard[i-1].getRankInt() == 1
                    && handBoard[i].getRankInt() - handBoard[i-1].getRankInt() <= 1) {
                straightTopCard = handBoard[i];
                chainBlock++;
            }
            if (handBoard[i].getRankInt() - handBoard[i-1].getRankInt() > 1 && chainBlock < 4) {
                straightTopCard = null;
                chainBlock = 0;
            }
            if (handBoard[i].getRankInt() - handBoard[i-1].getRankInt() > 1 && chainBlock == 4) {
                break;
            }
        }

        if (chainBlock >= 4) {    // если выстроилась цепочка с 4 звеньями, которые соединяют 5 карт в ряд, то у нас есть стрит
            StraightHand.setHand(Hand.STRAIGHT);
            Card[] straightCards = new Card[5]; // заполняем массив карт, которые составляют стрит
            int j = 0;
            for (int i = handBoard.length - 1; i > 0; i--) {
                if (handBoard[i].getRankInt() <= straightTopCard.getRankInt()
                        && handBoard[i].getRankInt() != handBoard[i-1].getRankInt()
                        && straightCards[4] == null) {
                    straightCards[j] = handBoard[i];
                    j++;
                }
            }
            if (straightTopCard.getRankInt() == 5 && handBoard[6].getRankInt() == 14) {
                straightCards[3] = handBoard[0];
                straightCards[4] = handBoard[6];
            }
            if (straightCards[4] == null) {
                straightCards[4] = handBoard[0];
            }
            StraightHand.setHandCards(straightCards);
            StraightHand.setHandTopCard(straightTopCard);
        }
        return StraightHand;
    }

    public static PlayerHand checkStraightFlush(Card[] handBoard) {
        PlayerHand StraightFlushHand = new PlayerHand();
        Card flushTop = checkFlush(handBoard).getHandTopCard();
        Card straightTop = checkStraight(handBoard).getHandTopCard();
        if (straightTop != null && straightTop == flushTop) {
            StraightFlushHand.setHandTopCard(straightTop);
            StraightFlushHand.setHand(Hand.STRAIGHTFLUSH);
            StraightFlushHand.setHandCards(checkStraight(handBoard).getHandCards());
        }
        return StraightFlushHand;
    }

    public static PlayerHand checkRoyalFlush(Card[] handBoard) {
        PlayerHand royalStraightHand = new PlayerHand();
        if (checkStraightFlush(handBoard).getHand() != null) {
            if (checkStraightFlush(handBoard).getHandTopCard().getRankInt() == 14) {
            royalStraightHand.setHand(Hand.ROYALFLUSH);
            royalStraightHand.setHandTopCard(checkStraight(handBoard).getHandTopCard());
            royalStraightHand.setHandCards(checkStraight(handBoard).getHandCards());
        }
        }
        return royalStraightHand;
    }

    public static PlayerHand checkPairs(Card[] hB) {

        Card kick;
        if (hB[0].getRankInt() > hB[1].getRankInt()) {
            kick = hB[0];
        } else {kick = hB[1];}
        PlayerHand kicker = new PlayerHand();
        kicker.setHand(Hand.KICKER);
        kicker.setHandTopCard(kick);

        Card[] handBoard = hB;
        Arrays.sort(handBoard);

        // для набора из 7 карт возможны максимум 2 пары/сета/карэ, поэтому создаем 2 экземпляра класса PlayerHand
        PlayerHand pair1 = new PlayerHand();
        PlayerHand pair2 = new PlayerHand();

        // массив, который получаем на входе в метод переводим в LinkedList
        LinkedList<Card> playerBoard= new LinkedList<Card>();
        for (Card c: handBoard) {
            playerBoard.addLast(c);
        }

        // берем последние карты набора одного старшинства (после сортировки самые старшие карты в конце)
        LinkedList<Card> pair1Cards = new LinkedList<Card>();
        while (playerBoard.get(playerBoard.size()-1).getRankInt() - playerBoard.get(playerBoard.size()-2).getRankInt() != 0
                && playerBoard.size() > 2) {
            playerBoard.removeLast(); // удаляем карты, у которых нет пары дальше по списку (минимум может остаться 2 карты)
        }
        pair1Cards.addFirst(playerBoard.pollLast());
        if (playerBoard.size() == 2) { // если все-таки осталось только 2 карты, проверяем совпдает ли их ранк
            if (playerBoard.peekLast().getRankInt() == pair1Cards.peekFirst().getRankInt()) { // если совпадают, то выдергиваем одну в pair1,
                pair1Cards.add(playerBoard.pollLast());                                       // (оставляем только 1 карту в наборе)
            }
        } else { // если осталось больше карт, выдергиваем все свпадающие (последнюю не выдергиваем, оставляем в наборе)
            while (pair1Cards.getFirst().getRankInt() == playerBoard.peekLast().getRankInt() && playerBoard.size() > 1) {
                pair1Cards.addLast(playerBoard.pollLast());
            }
        }
        if (playerBoard.size() == 1             // если осталась 1 карта, проверяем, совпадает ли она с предыдущими
                && playerBoard.peekFirst().getRankInt() == pair1Cards.peekFirst().getRankInt()) {
            pair1Cards.addLast(playerBoard.peekFirst()); // если совпадает, то мы ее копируем, но не выдергиваем
        }

        // повторяем операцию с оставшимися картами
        LinkedList<Card> pair2Cards = new LinkedList<Card>();
        if (playerBoard.size() >= 2) {
            if (playerBoard.size() > 2) {
                while (playerBoard.get(playerBoard.size() - 1).getRankInt() - playerBoard.get(playerBoard.size() - 2).getRankInt() != 0
                        && playerBoard.size() > 2) {
                    playerBoard.removeLast(); // удаляем карты, у которых нет пары дальше по списку
                }
            }
            pair2Cards.addFirst(playerBoard.pollLast());
            if (playerBoard.size() == 2) {  // если все-таки осталось только 2 карты, проверяем совпдает ли их ранк
                if (playerBoard.peekLast().getRankInt() == pair2Cards.peekFirst().getRankInt()) { // если совпадают, то выдергиваем одну в pair1,
                    pair2Cards.add(playerBoard.pollLast());                                       // (оставляем только 1 карту в наборе)
                }
            }
            if (playerBoard.size() == 1             // если осталась 1 карта, проверяем, совпадает ли она с предыдущими
                    && playerBoard.peekFirst().getRankInt() == pair2Cards.peekFirst().getRankInt()) {
                pair2Cards.addLast(playerBoard.pollFirst()); // если совпадает, то мы ее копируем, но не выдергиваем
            }
            if (playerBoard.size() != 0) {
                while (playerBoard.size() > 1 & pair2Cards.getFirst().getRankInt() == playerBoard.peekLast().getRankInt()) {
                    pair2Cards.addLast(playerBoard.pollLast());
                }
                if (pair2Cards.getFirst().getRankInt() == playerBoard.peek().getRankInt()) {
                    pair2Cards.addLast(playerBoard.poll());
                }
            }
        }

        // переводим списки в массивы соответствующих экземпляров
        pair1.setHandCards(pair1Cards.toArray(new Card[pair1Cards.size()]));
        if (pair2Cards.size() != 0) {
            pair2.setHandCards(pair2Cards.toArray(new Card[pair2Cards.size()]));
        } else {
            pair2.setHandCards(playerBoard.toArray(new Card[playerBoard.size()]));
        }

        // определяем старшинство 1-й комбинации
        switch (pair1.getHandCards().length) {
            case 1:
                pair1.setHand(Hand.KICKER);
                pair1.setHandTopCard(pair1.getHandCards()[0]);
                break;
            case 2:
                pair1.setHand(Hand.PAIR);
                pair1.setHandTopCard(pair1.getHandCards()[0]);
                break;
            case 3:
                pair1.setHand(Hand.SET);
                pair1.setHandTopCard(pair1.getHandCards()[0]);
                break;
            case 4: // карэ возвращаем сразу
                pair1.setHand(Hand.KARE);
                pair1.setHandTopCard(pair1.getHandCards()[0]);
                return pair1;
        }

        switch (pair2.getHandCards().length) { // определяем старшинство 2-й комбинации
            case 1:
                pair2.setHand(Hand.KICKER);
                pair2.setHandTopCard(pair2.getHandCards()[0]);
                break;
            case 2:
                pair2.setHand(Hand.PAIR);
                pair2.setHandTopCard(pair2.getHandCards()[0]);
                break;
            case 3:
                pair2.setHand(Hand.SET);
                pair2.setHandTopCard(pair2.getHandCards()[0]);
                break;
            case 4: // карэ возвращаем сразу
                pair2.setHand(Hand.KARE);
                pair2.setHandTopCard(pair2.getHandCards()[0]);
                return pair2;
        }

        // одна пара или сет
        if (pair1.getHand().getHandRank() > 1 ^ pair2.getHand().getHandRank() > 1) {
            PlayerHand result = pair1;
            if (result.getHand().getHandRank() <= pair2.getHand().getHandRank()) result = pair2;
            return result;
        }

         // 2 пары
        if (pair1.getHand() == Hand.PAIR && pair2.getHand() == Hand.PAIR) {
            PlayerHand result = new PlayerHand();
            result.setHand(Hand.TWOPAIRS);
            Card[] twoP = new Card[4];
            twoP[0] = pair1.getHandCards()[0];
            twoP[1] = pair1.getHandCards()[1];
            twoP[2] = pair2.getHandCards()[0];
            twoP[3] = pair2.getHandCards()[1];
            result.setHandCards(twoP);
            result.setHandTopCard(pair1.getHandCards()[0]);
            return result;
        }

        // если 2 сета - выбираем старший
        if (pair1.getHand() == Hand.SET && pair2.getHand() == Hand.SET) {
            PlayerHand result = new PlayerHand();
            result.setHand(Hand.SET);
            Card[] set = new Card[3];
            set[0] = pair1.getHandCards()[0];
            set[1] = pair1.getHandCards()[1];
            set[2] = pair1.getHandCards()[2];
            result.setHandCards(set);
            result.setHandTopCard(pair1.getHandCards()[0]);
            return result;
        }

        // фуллхаус "левый"
        if (pair1.getHand() == Hand.SET && pair2.getHand() == Hand.PAIR) {
            PlayerHand result = new PlayerHand();
            result.setHand(Hand.FULLHOUS);
            Card[] fullH = new Card[5];
            fullH[0] = pair1.getHandCards()[0];
            fullH[1] = pair1.getHandCards()[1];
            fullH[2] = pair1.getHandCards()[2];
            fullH[3] = pair2.getHandCards()[0];
            fullH[4] = pair2.getHandCards()[1];
            result.setHandCards(fullH);
            result.setHandTopCard(pair1.getHandCards()[0]);
            return result;
        }

        // фуллхаус "правый"
        if (pair1.getHand() == Hand.PAIR && pair2.getHand() == Hand.SET) {
            PlayerHand result = new PlayerHand();
            result.setHand(Hand.FULLHOUS);
            Card[] fullH = new Card[5];
            fullH[0] = pair1.getHandCards()[0];
            fullH[1] = pair1.getHandCards()[1];
            fullH[2] = pair2.getHandCards()[0];
            fullH[3] = pair2.getHandCards()[1];
            fullH[4] = pair2.getHandCards()[0];
            result.setHandCards(fullH);
            result.setHandTopCard(pair2.getHandCards()[0]);
            return result;
        }

        return kicker;
    }
}
