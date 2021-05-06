/**
* This class creates and defines a book.
* @author Athena Wu
* @version 1.0
 */
public class Book extends LibraryItem {
    private String backcoverBlurb;
    private int pages;
    /**
    * Constructs a book object, taking in a title, libraryCode, backcoverBlurb, and pages.
    * @param title title of the book
    * @param libraryCode represents a code given to the book and will be used to compare and sort
    * items
    * @param backcoverBlurb represents a short description of the Book
    * @param pages represents the number of pages the Book has
     */
    public Book(String title, int libraryCode, String backcoverBlurb, int pages) {
        super(title, libraryCode);
        this.backcoverBlurb = backcoverBlurb;
        this.pages = pages;
    }
    /**
    * This method returns a summary of an object as a String.
    * @return a summary of an object as a String
     */
    public String summarize() {
        return super.summarize() + "The book is " + pages + " pages long." + backcoverBlurb + ".";
    }
}