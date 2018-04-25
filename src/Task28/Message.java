package Task28;

public class Message<T> {
    private T element;

    public Message(T t) {
        this.element = t;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
