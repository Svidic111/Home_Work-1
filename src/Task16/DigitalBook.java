package Task16;

public class DigitalBook extends Book implements Digital, Searchable {

    private String title;
    private int year;

    public void setTitleAndYear(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }


    @Override
    public String getContent() {
        String content = getTitle() + " " + getYear();
        return content;
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }

    @Override
    public int found(String text) {
        return 100;
    }

}
