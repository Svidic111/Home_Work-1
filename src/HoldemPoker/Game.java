package HoldemPoker;

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

    private static void getHand(Player player, Card[] board) {

            Card[] handBoard = new Card[7];
            handBoard[0] = player.getPocketCard1(); // 1 и 2 карты массива - всегда карты игрока
            handBoard[1] = player.getPocketCard2();
            handBoard[2] = board[0];                // остальные - общий борд
            handBoard[3] = board[1];
            handBoard[4] = board[2];
            handBoard[5] = board[3];
            handBoard[6] = board[4];

        /*
        проверка на ФЛЭШ
         */
        String flush = CheckHand.checkFlush(handBoard);
        Card[] flushHand = new Card[7];
        if (flush.startsWith("FLUSH")) {
            String[] parts = flush.split(" "); // разбиваем текст на слов
            String suit = parts[2];                  // выделяем масть флэша

            int j = 0;
            for (int i = 0; i < handBoard.length; i++) {
                String check = handBoard[i].getSuit().toString();
                if (check.intern() == suit.intern()) {
                    flushHand[j] = handBoard[i];         // отбираем все карты, которые составляют флэш
                    j++;
                }
            }
        }
        Card flushTopCard = getHandTop(flushHand);       // определяем старшую карту комбинации
        /*
        конец проверки
         */


        /*
        проверка на стрит
         */
        String straight = CheckHand.checkStraight(handBoard);
        Card straightTopCard = null;
        if (straight.startsWith("STRAIGHT")) {
            String[] parts = straight.split(" "); // разбиваем текст на слов
            String straightTop = parts[2];                  // выделяем имя старшей карты
            for (int i = 0; i < handBoard.length; i++) {
                if (handBoard[i].getRank().name() == straightTop.intern()) {
                    straightTopCard = handBoard[i];
                }
            }
        }
        /*
        конец проверки
         */

        /*
        проверка на стрит-флэш
         */
        Card straightflushTopCard = null;
        if (flushTopCard.getRankInt() == straightTopCard.getRankInt() && flushTopCard != null) {
            straightflushTopCard = new Card(straightTopCard.getRank(), flushTopCard.getSuit());
        }
        /*
        конец проверки
         */

        /*
        проверка на роял-флэш
         */
        Card royalFlushTopCard = null;
        if (straightflushTopCard != null && straightflushTopCard.getRankInt() == 14){
            royalFlushTopCard = new Card(straightflushTopCard.getRank(), straightflushTopCard.getSuit());
        }
        /*
        конец проверки
         */

    }

    public static void main(String[] args) {

        Deck deck = new Deck(); // берем новую колоду
        //deck.shuffle();         // тасуем колоду

        Player player = new Player(); // приглашаем игроков
        BoldPlayer byvalyi = new BoldPlayer();
        BoldPlayer balbes = new BoldPlayer();

        player.setPocketCards(deck.get(0), deck.get(1)); // раздаем игрокам карты
        byvalyi.setPocketCards(deck.get(2), deck.get(3));
        balbes.setPocketCards(deck.get(4), deck.get(5));

        Card[] board = new Card[5];
        board[0] = deck.get(6);  // раздаем флоп
        board[1] = deck.get(7);
        board[2] = deck.get(8);

        player.showCards();
        showBoard(board);

        player.action(); // делаем "ставки"
        byvalyi.action();
        balbes.action();

        board[3] = deck.get(10); // выдаем тёрн

        player.showCards();
        showBoard(board);

        player.action(); // делаем "ставки"
        byvalyi.action();
        balbes.action();

        board[4] = deck.get(12); // выдаем ривер

  //      player.showCards();
        showBoard(board);

        balbes.showCards();


 //       getHand(player, board);// проверяем комбинации
//        getHand(byvalyi, board);
 //       getHand(balbes, board);

    }

}
