package Task9;

public class SetChar extends ListChar{

    public SetChar() {
        super();
    }

    public SetChar(int arrLenght) {
        super(arrLenght);
    }


    @Override
    public boolean set(int index, char c) {   // set a char to a place located by the index
        if (index <= super.getFullSize() && index >= 0 && !super.contains(c)) {
                super.set(index, c);
                return true;
            }
        return false;
    }

    @Override
    public boolean add(char e) {
        if (super.getFreeSize() >= 0 && !super.contains(e)) {
            this.set(super.length(), e);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(ListChar listChar) {
        for (int i = 0; i < listChar.length(); i++) {
            if (super.contains((char) listChar.get(i))) {
                return false;
            }
        }
        while (super.getFreeSize() < listChar.length()) {
            super.doubleSize();
        }
        for (int i = 0; i < listChar.length(); i++) {
            super.set(super.length(), (char) listChar.get(i));    // после каждой итерации значение this.length() будет увелич-ся на +1!!!
        }
        return true;
    }
}
