public class Book {
    private String bookID;
    private String title;
    private String author;

    public Book (String title, String bookID, String author) {
        this.author = author;
        this.bookID = bookID;
        this.title = title;
    }

    public String getDetails() {
        return String.format("---  BOOK DETAILS  ---\nBook Title: %s\nBook ID: %s\nAuthor: %s", this.title, this.bookID, this.author);
    }
}