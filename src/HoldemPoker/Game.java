package HoldemPoker;

import java.util.*;


public class Game {

    private static void showBoard(Card[] board) {

        System.out.print("Board: ");
        for (Card c: board) {
            if (c != null) {
                System.out.print("[" + c.toString() + "] ");
            }
        }
        System.out.println();
    }

    private static void showCards(Card[] cards) {
        for (Card c: cards) {
            if (c != null) {
                System.out.print("[" + c.toString() + "] ");
            }
        }
        System.out.println();
    }

    private static Player getHand(Player player, Card[] board) {

        Card[] handBoard = new Card[7];
        handBoard[0] = player.getPocketCard1(); // 1 и 2 карты массива - всегда карты игрока
        handBoard[1] = player.getPocketCard2();
        handBoard[2] = board[0];                // остальные - общий борд
        handBoard[3] = board[1];
        handBoard[4] = board[2];
        handBoard[5] = board[3];
        handBoard[6] = board[4];

        // проверяем комбинации в порядке возрастания
        PlayerHand hand = CheckHand.checkPairs(handBoard);
        if (CheckHand.checkStraight(handBoard).getHand() != null) {
            if (CheckHand.checkStraight(handBoard).getHand().getHandRank() > hand.getHand().getHandRank()) {
                hand = CheckHand.checkStraight(handBoard);
            }
        }
        if (CheckHand.checkFlush(handBoard).getHand() != null) {
             if (CheckHand.checkFlush(handBoard).getHand().getHandRank() > hand.getHand().getHandRank()){
                hand = CheckHand.checkFlush(handBoard);
            }
        }
        if (CheckHand.checkStraightFlush(handBoard).getHand() != null) {
            hand = CheckHand.checkStraightFlush(handBoard);
        }
        if (CheckHand.checkRoyalFlush(handBoard).getHand() != null) {
            hand = CheckHand.checkRoyalFlush(handBoard);
        }

        player.setHand(hand.getHand());
        player.setHandTop(hand.getHandTopCard());
        player.setHandCards(hand.getHandCards());
        player.setKicker();
        return  player;
    }

    public static void main(String[] args) {
        Player player = new Player("You"); // приглашаем игроков
        Player byvalyi = new Player("Бывалый");
        Player balbes = new Player("Балбес");

        while (true) {
            Deck deck = new Deck(); // берем новую колоду
            deck.shuffle();         // тасуем колоду

            // раздаем игрокам карты
            player.setPocketCards(deck.pollCard(), deck.pollCard());
            byvalyi.setPocketCards(deck.pollCard(), deck.pollCard());
            balbes.setPocketCards(deck.pollCard(), deck.pollCard());

            Card[] board = new Card[5];
            board[0] = deck.pollCard();  // раздаем флоп
            board[1] = deck.pollCard();
            board[2] = deck.pollCard();
            board[3] = deck.pollCard(); // выдаем тёрн
            board[4] = deck.pollCard(); // выдаем ривер

            // выводим на экран все карты
            showBoard(board);
            player.showCards();
            balbes.showCards();
            byvalyi.showCards();

            // определяем победителя
            Player p1 = getHand(player, board);
            Player p2 = getHand(balbes, board);
            Player p3 = getHand(byvalyi, board);

            TreeSet<Player> playerSet = new TreeSet<>();
            playerSet.add(p1);
            playerSet.add(p2);
            playerSet.add(p3);
            System.out.println(playerSet.last().getName() + " wins with " + playerSet.last().getHand().toString());
            showCards(playerSet.last().getHandCards());

            String bet = player.action(); // продолжаем или выходим из игры
            if (bet.intern() == "s") {
                return;
            }

        }
    }

}
