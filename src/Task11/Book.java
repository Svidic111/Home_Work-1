package Task11;

public class Book implements Comparable<Book>{

    private static int publishCount = 0;
    public Book() {
        publishCount++;
    }
    public Book(int a) {
    } // этот конструктор нужен, что бы использовать его в методе withdrawBook() и не инкрементить publishCount

    private String name;
    private int numOfPages;
    private Author author;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublishCount() {
        return publishCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            if (book == null) {
                return false;
            }
            if (book.name == this.name
                    && book.numOfPages == this.numOfPages
                    && book.author == this.author) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "{ " + name +", by " + author.getName() + " " + author.getSureName() + ", " + numOfPages + " pages}";
    }

    @Override
    public int compareTo(Book book) {
        return this.numOfPages - book.numOfPages;
    }
}
