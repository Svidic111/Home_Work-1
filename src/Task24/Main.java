package Task24;

public class Main {
    public static void main(String[] args) {

        Fish karas = new Fish();
        karas.setName("Borya");
        Chiken robotsyp = new Chiken();
        robotsyp.setName("Robotsyp");

        Chiken shaiHulud = new Chiken() {
            @Override
            public void eat(String  name) {
                System.out.println( name + " worm eats every thing!");
            }
        };
        shaiHulud.setName("Shai Hulud");

        karas.eat(karas.getName());
        robotsyp.eat(robotsyp.getName());
        shaiHulud.eat(shaiHulud.getName());
     }
}
