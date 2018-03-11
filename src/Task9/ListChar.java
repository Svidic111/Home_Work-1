package Task9;

public class ListChar {
    private char[] listChar;

    public ListChar() {
        this.listChar = new char[30];
    }

    public ListChar(int arrLenght) {
        this.listChar = new char[arrLenght];
    }

    public char[] getListChar() {
        return listChar;
    }

    public void increaseSize(int increment) {             // увеличение массива на заданное кол-во ячеек
        char[] addListChar = new char[increment + this.getFullSize()];
        System.arraycopy(listChar, 0, addListChar, 0, this.length());
        listChar = addListChar;
    }

    public void doubleSize() {                      // увеличение массива в 2 раза
        char[] addListChar = new char[2 * this.getFullSize()];
        System.arraycopy(listChar, 0, addListChar, 0, this.length());
        listChar = addListChar;
    }

    public boolean set(int index, char c) {   // set a char to a place located by the index
        if (index < this.getFullSize() && index >= 0) {
                listChar[index] = c;
                return true;
        }
        if (index == this.getFullSize()) {
            this.increaseSize( 1);
            listChar[index] = c;
            return true;
        }
        return false;
    }

    public int get(int index) {      // get a code of char by the index or -1 in case element wasn't found by the index
        if (index < this.length() && index >= 0) {
            return listChar[index];
        }
        return -1;
    }

    public boolean isEmpty() {      // true, if list is empty
        for (char array : listChar) {
            if (array != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(char c) {
        for (char array : listChar) {
            if (array == c) {
                return true;
            }
        }
        return false;
    }

    public int getFullSize() {
        return listChar.length;
    }

    public int getFreeSize() {      // return number of free elements of list
        int freeSize = 0;
        for (char arr : listChar) {
            if (arr == 0) {
                freeSize++;
            }
        }
        return freeSize;
    }

    public int length() {
        return this.getFullSize() - getFreeSize();
    }

    public void clear() {
        for (int i = 0; i < listChar.length; i++) {
            listChar[i] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ListChar) {
            ListChar c = (ListChar) obj;
            if (listChar.length != c.getFullSize()) {
                return false;
            }
            if (listChar == null || c == null) {
                return false;
            }
            int j = 0;
            for (char ar1 : listChar) {
                if (ar1 != c.get(j)) {
                    return false;
                }
                j++;
            }
            return true;
        }
        return false;
    }

    public boolean add(char e) {
        if (this.getFreeSize() > 0) {
            this.set(this.length(), e);
            return true;
        }
        else {
            this.increaseSize(1);
            this.set(this.length(), e);
            return true;
        }
    }

    public int indexOf(char c) {     // return index of found element else if not then -1
        for (int i = 0; i < this.length(); i++) {
            if (listChar[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAll(ListChar listChar) {
        while (this.getFreeSize() < listChar.length()) {
            this.doubleSize();
        }
        for (int i = 0; i < listChar.length(); i++) {
            this.set(this.length(), (char) listChar.get(i));    // после каждой итерации значение this.length() будет увелич-ся на +1!!!
        }
        return true;
    }

    public void printArray() {
        System.out.print("{ ");
        for (int i = 0; i < this.length(); i++) {
                System.out.print((char) this.get(i) + ";\t");
        }
        System.out.println("}");
    }

    public void sort(Direction d) {
        switch (d) {
            case ASC:
                for (int i = 0; i < this.length(); i++) { // selection sort
                    int min = listChar[i];
                    int min_index = i;
                    for (int j = i + 1; j < this.length(); j++) {
                        if (listChar[j] < min) {
                            min = listChar[j];
                         min_index = j;
                        }
                    }
                    char buf = listChar[i];
                    listChar[i] = listChar[min_index];
                    listChar[min_index] = buf;
            }
            break;

            case DESC:
                for (int i = 1; i < this.length(); i++) {   // insertion sort
                    for (int j = i - 1; j >= 0; j--) {
                        if (listChar[i] > listChar[j]) {
                            char old = listChar[i];
                            listChar[i] = listChar[j];
                            listChar[j] = old;
                            i--;
                        }
                    }
                }

        }
    }

}