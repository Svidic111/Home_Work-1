package Task9;

public class Main {
    public static void main(String[] args) {
        ListChar list1 = new ListChar(3);
        list1.set(0, 'w');
        list1.set(1, 'm');
        list1.set(2, 'x');
        list1.set(3, 'v');

        ListChar list2 = new ListChar(6);
        list2.set(0, 'x');
        list2.set(1, 'c');
        list2.set(2, 't');
        list2.set(3, '5');

        System.out.println(list1.addAll(list2));
        list1.printArray();

        SetChar list3 = new SetChar(2);
        list3.set(0, 'b');
        list3.set(1, 'a');

        System.out.println(list3.getFullSize());
        System.out.println(list3.addAll(list1));
        System.out.println(list3.getFullSize());
        list3.printArray();
    }
}
