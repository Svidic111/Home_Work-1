package Task14;

public class GuideDog extends Dog {
    private boolean isTrained = true;

    public boolean isTrained() {
        return isTrained;
    }

    public void takeHome() {
        System.out.println("I can take you home");
    }
}
