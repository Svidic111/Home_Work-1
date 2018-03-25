package TreesAndStacks;

public class Stack {
    private final int MAX_SIZE = 100;
    private int ptr = -1;
    private String[] arr= new String[MAX_SIZE];

    public boolean push(String str) {
        if (ptr == -1) {
            ptr = 0;
            arr[ptr] = str;
        }
        if(ptr ==  MAX_SIZE) {
            System.out.println("Current stack is overflow");
            return false;
        }
        arr[++ptr] = str;
        return true;
    }

    public String pop() {
        if (ptr == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[ptr--];
    }

    public String peek() {
        if (ptr == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[ptr];
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.peek());
    }
}
