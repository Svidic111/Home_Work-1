package Task9;

public class Main {
    public static void main(String[] args) {
//        ListChar list1 = new ListChar(10);
//        list1.set(0, 'a');
//        list1.set(1, '3');
//
//        ListChar list3 = new ListChar(10);
//        list3.set(0, 'a');
//        list3.set(1, '3');

        SetChar list2 = new SetChar();
        list2.set(0, 'b');
        list2.set(1, 'a');
        list2.set(2, 'h');
        list2.set(3, 'x');
        list2.set(4, 'y');


//        System.out.println(list2.length());
//        System.out.println(list1.getFullSize());
//        System.out.println(list1.equals(list3));
//        System.out.println(list2.add('k'));
//        System.out.println(list2.get(3));
//        System.out.println(list2.indexOf('H'));
//        System.out.println(list1.addAll(list2));
//        list1.sort(Direction.DESC);

        System.out.println(list2.add('k'));
        list2.printArray();



    }
}
