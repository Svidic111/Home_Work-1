package Task11;

public class BookShelf {
    private String name;
    private Book[] bookList = new Book[20];

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean setBook(int index, Book book) { // ставит на полку экземпляр книги
        if (index >= bookList.length) {
            return  false;
        }
        bookList[index] = book;
        return  true;
    }

    public Book getBook(int index) {      // передает книгу из полки
        return bookList[index];
    }

    public int listSize() {
        int listSize = 0;
        for (Book arr : bookList) {
            if (arr != null) {
                listSize++;
            }
        }
            return listSize;
    }

    public Book withdrawBook(int index) { // передает книгу из полки и очищает ячейку
        Book book = new Book(1);
        book = bookList[index];
        bookList[index] = null;
        return book;
    }

    public void moveSameBooks(BookShelf dstShelf) {  // переносим повторяющиеся униги на полку dstShelf
        int k = 0;                                   // переменная для указания ячкеек полки dstShelf
        for (int i = 0; i < this.listSize(); i++) {  // сравниваем i-ю книгу с остальными
            for (int j = i + 1; j <= this.listSize(); j++) {
                if (bookList[i] == null || bookList[j] == null) { // проверяем, есть ли в этой ячейке книга, т.к. её  от-туда уже может забрать
                    continue;
                }
                if (bookList[i].equals(bookList[j])) {
                    dstShelf.setBook(k, this.withdrawBook(j)); // вынимаем книгу, кот. уже есть и переносим в k-ю ячейку полки dstShelf
                    k++;
                }
            }
        }
    }

    public void printBookList() {
        for (int i = 0; i < this.listSize(); i++) {
            if (bookList[i] == null) {
                System.out.println("Empty place");
            } else {
                System.out.println(getBook(i).getName() + " by " + getBook(i).getAuthor().getName() + " " + getBook(i).getAuthor().getSureName());
            }
        }
    }

}
