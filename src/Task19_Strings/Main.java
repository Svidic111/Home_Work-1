package Task19_Strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public  static void mostPopularChars(String str, int n) {
        char[] charArr = str.toCharArray(); // перегоняем строку в массив чаров

        CharCount[] charCount  = new CharCount[charArr.length]; // помещаем в массив, с полем count, которое инкрементится, если такой чар уже есть в массиве
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (charCount[j] == null) {
                    charCount[j] = new CharCount(charArr[i]);
                }
                if (charArr[i] == charCount[j].getValue()) {
                    int current = charCount[j].getCount();
                    charCount[j].setCount(current + 1);
                    break;
                }

            }
        }
        for (int j = 0; j < charCount.length; j++) {  // сортируем по частоте повторения
            int left, right;
            for (int i = 1; i < charCount.length - j; i++) {
                left = i - 1;
                right = i;
                if (charCount[right] == null) {
                    break;
                }
                if (charCount[right].getCount() > charCount[left].getCount()) {
                    CharCount tmp = charCount[left];
                    charCount[left] = charCount[right];
                    charCount[right] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%c repeats %d times \n", charCount[i].getValue(), charCount[i].getCount());
        }

    }

    public static void punctMarks(String str) {
        Pattern pattern = Pattern.compile("[!.,;:?\\-]");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println("There are " + count + " punctuaition marks in the text.");
    }

    public static void consonantsNumber(String str) {
        String[] sentence = str.split("[.!?]");
        int sentNum = sentence.length;
        for (int i = 0; i < sentence.length; i++) {
            Pattern pattern1 = Pattern.compile("(?ui:[eyuioaёуеыаоэяию])");
            Matcher matcher1 = pattern1.matcher(sentence[i]);
            Pattern pattern2 = Pattern.compile("(?ui:[qwrtpsdfghjklzxcvbnmйцкнгшщзхъфвпрлджчсмтьб])");
            Matcher matcher2 = pattern2.matcher(sentence[i]);
            int son = 0;
            int conson = 0;

            while (matcher1.find()) {
                son++;
            }
            System.out.println("There are " + son + " sonant sounds in sentence: " + sentence[i]);

            while (matcher2.find()) {
                conson++;
            }
            System.out.println("There are " + conson + " consonant sounds in sentence: " + sentence[i]);
        }
    }

    public static String removePunctMarks(String str) {
        str = str.replaceAll("[^a-zA-Zа-яА-Я-]", " ");
        return str;
    }

    public static void extremWords(String str) {
        str = removePunctMarks(str);
        String[] word = str.split(" ");
        for (String w: word) {
            w = w.trim();
        }

        int min = 100;
        int max = 1;
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() > max) {
                max = word[i].length();
            }
            if (word[i].length() < min && word[i].length()>0) {
                min = word[i].length();
            }
        }

        for (int i = 0; i < word.length; i++) {
            if (word[i].length() == max) {
                System.out.println("The longest word of the text - " + word[i] + ", it has " + max + " letters.");
            }
            if (word[i].length() == min) {
                System.out.println("The shortest word of the text - " + word[i] + ", it has " + min + " letters.");
            }
        }
    }

    public static int findWordNumber(String text, String str) {
        text = removePunctMarks(text);
        String[] word = text.split(" ");
        for (String w: word) {
            w = w.trim();
        }
        int count = 0;
        for (String w: word) {
            if (w.intern() == str.intern()) {
                count++;
            }
        }
        return count;
    }

    public static String letterChange(String str, char letter, int index) {
        String[] word = str.split(" ");

        for (int i = 0; i < word.length; i++) {
            if (index < word[i].length()) {
                char[] c = word[i].toCharArray();
                c[index] = letter;
                String tmp = word[i].copyValueOf(c);
                word[i] = tmp;
            }
        }

        String result = "";
        for (String w: word) {
            result = result + " " + w;
        }
        return  result;
    }

    public static void main(String[] args) {

        String text = "Java — сильно типизированный объектно-ориентированный язык программирования. Java is super!";

//        mostPopularChars(text, 4);
//        punctMarks(text);
//        System.out.println(removePunctMarks(text));
//        consonantsNumber(text);
//        extremWords(text);
//        System.out.println(findWordNumber(text, "Java"));
//        System.out.println(letterChange(text, 'F', 2));

    }
}
