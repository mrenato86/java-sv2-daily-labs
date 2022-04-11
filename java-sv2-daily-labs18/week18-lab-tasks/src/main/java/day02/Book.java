package day02;

public class Book {

    private final long id;
    private final String title;
    private final String author;
    private final long price;
    private final long pieces;

    public Book(long id, String title, String author, long price, long pieces) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pieces = pieces;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }

    public long getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
    }
}
