package Task14;

public class Cat extends Pet {

    @Override
    public void voice() {
        System.out.println("Meow. " + "My name is " + this.getName());
    }
}
