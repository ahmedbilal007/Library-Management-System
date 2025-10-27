import java.util.ArrayList;

public class Book {
    private String bookID;
    private String title;
    private String ISBN;
    private String publisher;
    private String author;
    private int bookQuantity;
    private int availableQuantity;

    public Book() {}
    public Book(String bookID, String title, String ISBN, String publisher, String author) {
        this.bookID = bookID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.author = author;
        this.bookQuantity = 1;
        this.availableQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return String.format("\n--- BOOK DETAILS ---\nBook Title: %s\nBook ID: %s\nISBN: %s\nAuthor: %s\nPublisher: %s\nTotal Books: %d\nAvailable: %d",
        this.getTitle(),this.getBookID(), this.getISBN(), this.getAuthor(), this.getPublisher(), this.bookQuantity, this.getAvailableQuantity());
    }
    public boolean isBookAvailable() {
        if (this.availableQuantity > 0) return true;
        return false;
    }


    public String getTitle() {return this.title;}

    public String getBookID() { return bookID;}

    public String getISBN() {return ISBN;}
    
    public String getPublisher() {return publisher;}

    public String getAuthor() {return author;}
    
    public static Book getBook(ArrayList<Book> books, String id) {
        for (Book b : books) {
            if (b.getBookID().equals(id)) return b;
        }
        return null;
    }

    public void incBookQuantity() {
        this.bookQuantity++;
    }

    public int getAvailableQuantity() {
        return this.availableQuantity;
    }

    public void decBookQuantity() {
        this.bookQuantity--;
    }

    public void incAvailableQuantity() {
        this.availableQuantity++;
    }

    public void decAvailableQuantity() {
        this.availableQuantity--;
    }

    public void setBookID(String bookID) {this.bookID = bookID;}

    public void setTitle(String title) {this.title = title;}

    public void setISBN(String ISBN) {this.ISBN = ISBN;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public void setAuthor(String author) {this.author = author;}
}
