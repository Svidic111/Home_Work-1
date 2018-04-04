package Task14;

public class Main {
    public static void main(String[] args) {

        Fish fish = new Fish();
        fish.setName("Darwin");

        Dog dog = new Dog();
        dog.setName("Bim");

        Cat cat = new Cat();
        cat.setName("Murka");

        Wolf wolf = new Wolf();
        wolf.setPredator(true);

        Girafe girafe = new Girafe();

        GuideDog guideDog = new GuideDog();
        guideDog.setName("Buba");

        fish.voice();
        dog.voice();
        cat.voice();
        wolf.voice();
        girafe.voice();
        guideDog.voice();
        guideDog.takeHome();

    }
}
