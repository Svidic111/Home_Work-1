package Task14;

public class Pet extends Animal {
    public  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println("Hello. " + "My name is " + this.getName());
    }
}
