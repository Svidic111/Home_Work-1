package Task14;

public class Wild extends Animal {

    @Override
    public void voice() {
        String predator = "";
        if (super.isPredator()) {
            predator = "And I am angry!";
        }
        System.out.println("Hello " + "I am a wild animal. " + predator);
    }
}
