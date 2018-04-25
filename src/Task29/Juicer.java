package Task29;

import java.util.Arrays;
import java.util.Collection;

public class Juicer {

    void makeJuice(Collection<? extends Juiceable> juiceFruits) {
        for (Juiceable fruit : juiceFruits) {
            fruit.makeJuice();
        }
    }

    public static void main(String[] args) {
        Juicer juicer = new Juicer();

        // Code below must work correctly since Apple is able to give some juice
        Collection<Apple> apples = Arrays.asList(new Apple(), new Apple());
        juicer.makeJuice(apples);

        // Code below mustn't work correctly since AppleQuince isn't able to give juice
         Collection<AppleQuince> appleQuinces = Arrays.asList(new AppleQuince(), new AppleQuince());
         juicer.makeJuice(appleQuinces);

        //Code bellow mustn't work correctly since Fruit doesn't mean that it's able to give juice always by definition
        Collection<Fruit> mixedFruits = Arrays.asList(new Apple(), new Apricot(), new AppleQuince());
        juicer.makeJuice(mixedFruits);

    }
}
