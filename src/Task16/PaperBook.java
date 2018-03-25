package Task16;

public class PaperBook extends Book {
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
        String content = "Incompatible Book Format";
        return content;
        }

        }
