package TreesAndStacks;

public class BinTree {
    private Node root;

    public void add(int data) {
        Node n = new Node(data);

        if (root == null) {
            root = n;
            return;
        }

        Node current = root;
        Node parent;
        while (true) {
            parent = current;

            if (data < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                break;
            }
        }
        if (data < parent.getData()) {
            parent.setLeft(n);
        } else {
            parent.setRight(n);
        }

    }

    public Node find(int data) {
        if (root == null) {
            return  null;
        }
//        if (root.getData() == data) {
//            return root;
//        }
        Node current = root;
        while (current != null) {
            if (current.getData() == data) {
                return current;
            }
            if (data < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

        }
        return null;
    }

//    public boolean remove() {
//
//    }

    public int getMaxValue() {
        Node current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return  current.getData();
    }

    public int getMinValue() {
        Node current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return  current.getData();
    }

//    public void inOrder() {
//
//    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.add(30);
        tree.add(45);
        tree.add(20);
        tree.add(25);
        tree.add(15);
        tree.add(60);
        tree.add(40);
        tree.add(17);
        tree.add(5);
        tree.add(22);
        tree.add(28);
        tree.add(35);
        tree.add(43);
        tree.add(57);
        tree.add(90);

    }
}