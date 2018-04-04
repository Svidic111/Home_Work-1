package Task14;

public class Dog extends Pet {
    @Override
    public void voice() {
        System.out.println("Woof. " + "My name is " + this.getName());
    }
}
