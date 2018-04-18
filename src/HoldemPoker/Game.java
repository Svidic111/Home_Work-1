package HoldemPoker;

import java.util.Arrays;

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
            Player winner;
            Player p1 = getHand(player, board);
            Player p2 = getHand(balbes, board);
            Player p3 = getHand(byvalyi, board);

            Player[] players = new Player[3];
            players[0] = p1;
            players[1] = p2;
            players[2] = p3;
            Arrays.sort(players);

            if (players[0].getHand().getHandRank() - players[1].getHand().getHandRank() > 0) {
                System.out.println(players[0].getName() + " wins with " + players[0].getHand().toString());
            }

//            if (player.getHand().getHandRank() > balbes.getHand().getHandRank()
//                    && player.getHand().getHandRank() > byvalyi.getHand().getHandRank()) {
//                winner = player;
//            }
//            if (balbes.getHand().getHandRank() > player.getHand().getHandRank()
//                    && balbes.getHand().getHandRank() > byvalyi.getHand().getHandRank()) {
//                winner = balbes;
//            }

            String bet = player.action(); // делаем "ставки"
            if (bet.intern() == "s") {
                return;
            }

        }
    }

}
