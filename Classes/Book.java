public class Book {
    private String bookID;
    private String title;
    private int ISBN;
    private String publisher;
    private boolean status;
    private String author;

    public Book(String bookID, String title, int ISBN, String publisher, String author) {
        this.bookID = bookID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.status = true;
        this.author = author;
    }

    public String getDetails() {
        return String.format("--- BOOK DETAILS ---\nBook Title: %s\nBook ID: %s\nISBN: %d\nAuthor: %s\nPublisher: %s",
        this.getTitle(),this.getBookID(), this.getISBN(), this.getAuthor(), this.getPublisher());
    }
    public boolean isAvailable() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }  
   
    public String getTitle() {
        return this.title;
    }

    public String getBookID() {
        return bookID;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean isStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }
    
    public static Book getBook(Library lib, String title) {
        for (Book b : lib.books) {
            if (b.getTitle().equals(title)) return b;
        }
        return null;
    }

    public void setDetails(String bookID, String title, int ISBN, String publisher, String author) {
        this.bookID = bookID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher =  publisher;
        this.author = author;
    }
}
