public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isCheckedOut;
    private String publicationDate;
    public Book(String title, String author, String isbn, String publicationDate){
        this.title= title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.isCheckedOut = false;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
     public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getisbn(){
        return this.isbn;
    }
    public void setisbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPublicationDate(){
        return this.publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String toString(){
        return "The title is: "+title+". The author is: "+author+". It was published: "+publicationDate+". The ISBN is: "+isbn+". ";
    }
    public void checkOut(){
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println(title + " has been checked out.");
        } 
        else {
            System.out.println(title + " is already out.");
        }
    }
    public void returnBook() {
        isCheckedOut = false;
        System.out.println(title + " has been returned.");
    }
}
