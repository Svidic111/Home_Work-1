package Task9;

public class SetChar extends ListChar{
    private char[] listChar;

    public SetChar() {
        this.listChar = new char[30];
    }

    public SetChar(int arrLenght) {
        super(arrLenght);
    }

    @Override
    public boolean add(char e) {
        if (this.getFreeSize() > 0 && !this.contains(e)) {
            this.listChar[this.length()] = e;
            return true;
        }
        return false;
    }

//    @Override
//    public boolean set(int index, char c) {   // set a char to a place located by the index
//        if (index < listChar.length && index >= 0 && !this.contains(c)) {
//                this.listChar[index] = c;
//                return true;
//        }
//        return false;
//    }
}
