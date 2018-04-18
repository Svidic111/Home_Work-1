package HoldemPoker;

public class Test {

    private static void showBoard(Card[] board) {
        System.out.print("Board: ");
        for (Card c: board) {
            if (c != null) {
                System.out.print("[" + c.toString() + "] ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Player player = new Player("Я");
        TestDeck deck = new TestDeck();

        player.setPocketCards(deck.get(19), deck.get(11));

        Card[] board = new Card[5];
        board[0] = deck.get(32);
        board[1] = deck.get(51);
        board[2] = deck.get(38);
        board[3] = deck.get(12);
        board[4] = deck.get(6);

        Card[] handBoard = new Card[7];
        handBoard[0] = player.getPocketCard1();
        handBoard[1] = player.getPocketCard2();
        handBoard[2] = board[0];
        handBoard[3] = board[1];
        handBoard[4] = board[2];
        handBoard[5] = board[3];
        handBoard[6] = board[4];

        player.showCards();
        showBoard(board);

//        System.out.println(CheckHand.checkFlush(handBoard));
//        System.out.println(CheckHand.checkStraight(handBoard));
        CheckHand.checkPairs(handBoard);
//        System.out.println(CheckHand.checkRoyalFlush(handBoard));
    }
}
