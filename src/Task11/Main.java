package Task11;

public class Main {
    public static void main(String[] args) {
        Author markTwain = new Author();
        markTwain.setName("Mark");
        markTwain.setSureName("Twain");
        markTwain.setBirthYear(1835);

        Author mykolaGogol = new Author();
        mykolaGogol.setName("Mykola");
        mykolaGogol.setSureName("Gogol");
        mykolaGogol.setBirthYear(1809);

        Book deadSouls = new Book();
        deadSouls.setAuthor(mykolaGogol);
        deadSouls.setName("Dead Souls");
        deadSouls.setNumOfPages(215);

        Book tarasBulba = new Book();
        tarasBulba.setAuthor(mykolaGogol);
        tarasBulba.setName("Taras Bulba");
        tarasBulba.setNumOfPages(482);

        Book tomSawyer = new Book();
        tomSawyer.setAuthor(markTwain);
        tomSawyer.setName("Tom Sawyer");
        tomSawyer.setNumOfPages(186);

        Book tomSawyer2 = new Book();
        tomSawyer2.setAuthor(markTwain);
        tomSawyer2.setName("Tom Sawyer");
        tomSawyer2.setNumOfPages(186);

        BookShelf mainBookShelf = new BookShelf();
        BookShelf secondBookShelf = new BookShelf();

        mainBookShelf.setBook(0, tomSawyer);
        mainBookShelf.setBook(1, tomSawyer2);
        mainBookShelf.setBook(2, deadSouls);
        mainBookShelf.setBook(3, tarasBulba);
        mainBookShelf.setBook(4, tarasBulba);

        mainBookShelf.moveSameBooks(secondBookShelf);
        mainBookShelf.printBookList();
        System.out.println(" ");                // для разделения содержимого полок в консоли
        secondBookShelf.printBookList();
        System.out.println(tomSawyer.getPublishCount());

    }
}
