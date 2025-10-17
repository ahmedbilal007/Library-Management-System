public class Book {
    private String bookID;
    private String title;
    private int ISBN;
    private String publisher;
    private boolean isAvailable;
    private String author;

    public Book() {}
    public Book(String bookID, String title, int ISBN, String publisher, String author) {
        this.bookID = bookID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.isAvailable = true;
        this.author = author;
    }

    public String getDetails() {
        return String.format("--- BOOK DETAILS ---\nBook Title: %s\nBook ID: %s\nISBN: %d\nAuthor: %s\nPublisher: %s",
        this.getTitle(),this.getBookID(), this.getISBN(), this.getAuthor(), this.getPublisher());
    }
    public boolean isBookAvailable() { return this.isAvailable;}

    public void setStatus(boolean status) { this.isAvailable = status;}  
   
    public String getTitle() {return this.title;}

    public String getBookID() { return bookID;}

    public int getISBN() {return ISBN;}
    
    public String getPublisher() {return publisher;}

    public String getAuthor() {return author;}
    
    public static Book getBook(Library lib, String title) {
        for (Book b : lib.books) {
            if (b.getTitle().equals(title)) return b;
        }
        return null;
    }


    public void setBookID(String bookID) {this.bookID = bookID;}

    public void setTitle(String title) {this.title = title;}

    public void setISBN(int ISBN) {this.ISBN = ISBN;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public void setAuthor(String author) {this.author = author;}
}
