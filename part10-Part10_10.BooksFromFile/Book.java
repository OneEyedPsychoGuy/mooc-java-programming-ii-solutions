public class Book {
    private String name;
    private int publishingYear;
    private int pages;
    private String author;

    public Book(String name, int publishingYear, int pages, String author) {
        this.name = name;
        this.publishingYear = publishingYear;
        this.pages = pages;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public int getPagecount() {
        return this.pages;
    }

    public String getAuthor() {
        return this.author;
    }
}