package Task11;

public class Author {
    private String name;
    private String sureName;
    private int birthYear;
    private Book[] bibliograf; // массив из книг написанных автором

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public int getBirthYear() {
        return birthYear;
    }

}
