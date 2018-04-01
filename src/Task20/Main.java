package Task20;

public class Main {
    public static void main(String[] args) {

        Deque personalData = new Deque();
        System.out.println(personalData.addFirst("surename: Svidovyi"));
        personalData.addFirst("name: Oleksandr");
        personalData.addFirst("sex: male");
        personalData.addLast("age: 30");
//        personalData.poll();
//        System.out.println(personalData.peekLast());
//        personalData.removeLast();
//        System.out.println(personalData.peekFirst());
//        System.out.println(personalData.size());
    }
}
