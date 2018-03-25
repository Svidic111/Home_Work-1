package Task16;

public class Main {
    public static void main(String[] args) {

        PaperBook idiot = new PaperBook();
        DigitalBook littlePrince = new DigitalBook();
        OldDigitalBook tesei = new OldDigitalBook();

        idiot.setTitleAndYear("Idiot", 1863);
        littlePrince.setTitleAndYear("Little Prince", 1923);
        tesei.setTitleAndYear("Tesei", 1974);

        Book[] books = new Book[3];

        books[0] = idiot;
        books[1] = littlePrince;
        books[2] = tesei;

        for (Book arr: books) {
            System.out.println(arr.getContent());
        }

    }
}
