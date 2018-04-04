package Task23;

import Task11.Author;
import Task11.Book;

import java.util.*;

public class Main {

    public static void reverseNumber(int num) { // 	Каждую цифру числа  занести в стек. Вывести число, у которого цифры идут в обратном порядке
        Integer number = num;
        Stack<Integer> numbers = new Stack();
        System.out.println(number);

        int a = 0;
        int i = 1;
        int size = (int) Math.ceil(Math.log10(number));
        int k = (int)Math. pow(10, i);
        while (size > 0 ) {
            int c = number / (int)Math. pow(10, size-1);
            a = c % k;
            numbers.push(a);
            i++;
            size--;
        }
        while (numbers.size() > 0) {
            System.out.print(numbers.pop());
        }
        System.out.println();
    }

    public static void numArraysIntersection(int[] arr1, int[] arr2) { // 	Определить несколько множеств на основе множества целых чисел. Получить пересечение двух множеств.
        int[] num1 = arr1;
        int[] num2 = arr2;

        Set<Integer> set1 = new HashSet<Integer>();
        for (int e: num1) { set1.add(e); }

        Set<Integer> set2 = new HashSet<Integer>();
        for (int e: num2) { set2.add(e); }

        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);
        if (intersection.isEmpty()) {
            System.out.println("no intersection found");
            return;
        }
        Iterator<Integer> iter = intersection.iterator();
        while (iter.hasNext()) {
            Integer ans = iter.next();
            System.out.println(ans);
        }
    }

    public static boolean checkBreckets(String str) { //Задана строка, состоящая из различной комбинации символов «(», «)», «[», «]», «{», «}»
        char[] textCahrs = str.toCharArray();
        Stack<Character> strStack = new Stack<Character>();
        for (char c: textCahrs) {
            strStack.push(c);
        }
        char test = 0;
        int count = 0;
        while (strStack.size() > 0) {
            test = strStack.pop();
            switch (test) {
                case '(':
                case '{':
                case '[':
                    count++;
                    break;
                case ')':
                case '}':
                case ']':
                    count--;
                    break;
            }
        }
        if (count == 0) return true;
        else return false;
    }

    public static void main(String[] args) {

//        reverseNumber(5111865);
//
//        int[] num1 = {1, 15, 22, 8, 44, 56, 11, 7, 98};
//        int[] num2 = {4, 13, 22, 8, 44, 57, 35, 112, 107};
//        numArraysIntersection(num1, num2);
//
//        String text = "[[{{(( hello ))}}]]";
//        System.out.println(checkBreckets(text));


        Author markTwain = new Author();
        markTwain.setName("Mark");
        markTwain.setSureName("Twain");

        Author mykolaGogol = new Author();
        mykolaGogol.setName("Mykola");
        mykolaGogol.setSureName("Gogol");

        Book deadSouls = new Book();
        deadSouls.setAuthor(mykolaGogol);
        deadSouls.setName("Dead Souls");

        Book tarasBulba = new Book();
        tarasBulba.setAuthor(mykolaGogol);
        tarasBulba.setName("Taras Bulba");

        Book tomSawyer = new Book();
        tomSawyer.setAuthor(markTwain);
        tomSawyer.setName("Tom Sawyer");

        Stack<Book> bookStack = new Stack<Book>();
        bookStack.push(deadSouls);
        bookStack.push(tarasBulba);
        bookStack.push(tomSawyer);
        bookStack.push(tarasBulba);
        bookStack.push(tomSawyer);

        Iterator bsIterator = bookStack.iterator();
        Set<Book> bookSet = new HashSet<>();
        while (bsIterator.hasNext()) {
            bookSet.add((Book) bsIterator.next());
        }

        Iterator bookSetIter = bookSet.iterator();
        while (bookSetIter.hasNext()) {
            Book b = (Book) bookSetIter.next();
            System.out.println(b.getName());
        }

    }
}
