package Task20;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class Deque implements Iterable<Deque.Node>{

    class Node {
        private String data;
        private Node prev;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private Node tail;

    public int size() {
        int count = 1;
        if (head == null) return 0;
        // while (iterator().hasNext()) count++; // запускает бесконечный цикл - надо разобраться с итератором
        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String peekFirst() {
        if (head != null) {
            return head.getData();
        }
        return  null;
    }

    public Node getHead() {
        return head;
    }

    public String poll(){  // извлекает первый элемент (head) из очереди и удаляет его
        if (head == null) {
            return null;
        }
        String answer = head.getData();
        this.removeFirst();
        return answer;
    }

    public Node getTail() {
        return tail;
    }

    public String peekLast() {
        if (tail != null) {
            return tail.getData();
        }
        return  null;
    }

    public String pop(){  // извлекает последний элемент (tail) из очереди и удаляет его
        if (head == null) {
            return null;
        }
        String answer = tail.getData();
        this.removeLast();
        return answer;
    }

    public Node find(String data) {
        Node currentNode = head;

        do {
            if (currentNode.getData().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != null);

        return null;

    }

    public boolean contain(String data) {
        return (find(data) != null);
    }

    public boolean addFirst(String element) {
        if (head == null) {
            head = new Node(element);
            tail = head;
            return true;
        } else {
            Node currentNode = new Node(element);
            head.setPrev(currentNode);
            currentNode.setNext(head);
            head = currentNode;
            return true;
        }
    }

    public void addLast(String element) {
        Node newlyAddedNode = new Node(element);

        if (head == null) {
            head = newlyAddedNode;
            tail = head;
            return;
        }

        newlyAddedNode.setPrev(tail);
        tail.setNext(newlyAddedNode);
        tail = newlyAddedNode;
    }

    public boolean removeFirst() {
        if (head == null) {
            return  false;
        }
        head.next.setPrev(null);
        head = head.getNext();
        return true;
    }

    public boolean removeLast() {
        if (head == null) {
            return  false;
        }
        tail.prev.setNext(null);
        tail = tail.getPrev();
        return true;
    }

    public void remove(String data) {
        Node removingNode = find(data);
        remove(removingNode);

    }

    public void remove(Node removingNode) {
        if (removingNode == null) {
            System.out.println("Warning: Removing element has not been found.");
            return;
        }

        if (removingNode == head) {
            Node currentNode = head.getNext();
            head.setNext(null);
            head = currentNode;
            currentNode.setPrev(null);
            return;
        }

        if (removingNode == tail) {
            Node currentNode = tail.getPrev();
            tail.setPrev(null);
            tail = currentNode;
            currentNode.setNext(null);
            return;
        }

        Node leftNode = removingNode.getPrev();
        Node rightNode = removingNode.getNext();
        removingNode.setPrev(null);
        removingNode.setNext(null);
        leftNode.setNext(rightNode);
        rightNode.setPrev(leftNode);

    }

    public void removeAll() {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return (currentNode != tail);
            }

            @Override
            public Node next() {
                return currentNode = currentNode.getNext();
            }

            @Override
            public void remove() {
                Deque.this.remove(currentNode);
            }
        };
    }
}
