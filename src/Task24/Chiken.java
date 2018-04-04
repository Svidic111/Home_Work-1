package Task24;

public class Chiken implements Eatable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat(String  name) {
        System.out.println( name + " chiken eats worms");
    }
}
