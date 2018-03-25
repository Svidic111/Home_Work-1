package HoldemPoker;

import java.util.Random;

public class NoobPLayer extends Player {

    @Override
    public int action() { // играет или падает случайным образом
        Random random = new Random();
        int action = random.nextInt(2);
        return action;
    }
}
