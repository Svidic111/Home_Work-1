package Task28;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Message<Integer> in = new Message<>(335);
        System.out.println(in.toString());

        Message<String> str = new Message<>("ALOHA!");
        System.out.println(str);

        ArrayList<Double> arrDouble = new ArrayList<>();
        arrDouble.add(5.3);
        arrDouble.add(8.5);
        arrDouble.add(0.4);
        arrDouble.add(-0.17);
        Message<ArrayList> al = new Message<>(arrDouble);
        System.out.println(al.toString());
    }
}
