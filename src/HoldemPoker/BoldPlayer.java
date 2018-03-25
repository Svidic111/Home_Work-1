package HoldemPoker;

public class BoldPlayer extends Player {

    @Override
    public int action() { // всегда играет, независимо от карт на руках
        return 1;
    }
}
