package Task26;

import Task11.Author;
import Task11.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Author markTwain = new Author();
        markTwain.setName("Mark");
        markTwain.setSureName("Twain");

        Author mykolaGogol = new Author();
        mykolaGogol.setName("Mykola");
        mykolaGogol.setSureName("Gogol");

        Book deadSouls = new Book();
        deadSouls.setAuthor(mykolaGogol);
        deadSouls.setName("Dead Souls");
        deadSouls.setNumOfPages(184);

        Book tarasBulba = new Book();
        tarasBulba.setAuthor(mykolaGogol);
        tarasBulba.setName("Taras Bulba");
        tarasBulba.setNumOfPages(216);

        Book tomSawyer = new Book();
        tomSawyer.setAuthor(markTwain);
        tomSawyer.setName("Tom Sawyer");
        tomSawyer.setNumOfPages(125);

        LinkedList<Book> books1 = new LinkedList<Book>();
        books1.add(tarasBulba);
        books1.add(tomSawyer);
        books1.add(deadSouls);
        System.out.println(books1.toString());

        Collections.sort(books1);
        System.out.println(books1.toString());
    }
}
