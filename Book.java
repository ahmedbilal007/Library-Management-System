public class Book {
    private String bookID;
    private String title;
    private int ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;
    private boolean status;
    private String author;

    public Book(String bookID, String title, int ISBN, String publisher, int totalCopies, String author) {
        this.bookID = bookID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.status = true;
        this.author = author;
    }
    public boolean isAvailable() {
        return this.status;
    }
    @Override
    public String toString() {
        return "Book [bookID=" + bookID + ", title=" + title + ", ISBN=" + ISBN + ", publisher=" + publisher
                + ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + ", status=" + status
                + ", author=" + author + ", isAvailable()=" + isAvailable() + "]";
    }

    
    
}
