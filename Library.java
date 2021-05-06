import java.util.Arrays;
/**
* This class creates a Library object.
* @author Athena Wu
* @version 1.0
 */
public class Library {
    private LibraryItem[] bookshelf;

    /**
    * Constructs a Library object, taking in no arguments and initializing an empty bookshelf.
     */

    public Library() {
        this(new LibraryItem[0]);
    }

    /**
    * Constructs a Library object, taking in an array of LibraryItems that will be the books on the
    * bookshelf.
    * @param bookshelf an array that simulates a bookshelf where we will hold objects of type LibraryItem.
     */
    public Library(LibraryItem[] bookshelf) {
        Arrays.sort(bookshelf);
        this.bookshelf = bookshelf;
    }

    /**
    * This method prints out the summaries of all LibraryItems in the bookshelf for the Library.
     */
    public void browseLibraryItems() {
        for (LibraryItem book : bookshelf) {
            System.out.println(book.getLibraryCode() + ": " + book.summarize());
        }
    }

    /**
    * This method should create a new array of length + 1 that copies over all
    * the previous elements as well as adds the new item.
    * @param newItem an item added to the new item to the bookshelf
     */
    public void addLibraryItem(LibraryItem newItem) {
        int length = bookshelf.length + 1;
        LibraryItem[] newBookShelf = new LibraryItem[length];
        for (int i = 0; i < bookshelf.length; i++) {
            newBookShelf[i] = bookshelf[i];
        }
        newBookShelf[length - 1] = newItem;
        Arrays.sort(newBookShelf);
        bookshelf = newBookShelf;
    }

    /**
    * This method returns the library item with given code.
    * @param code a code associated with a library item
    * @return the library item corresponding to the code.
     */
    public LibraryItem getLibraryItem(int code) {
        for (int i = 0; i < bookshelf.length; i++) {
            if (bookshelf[i].getLibraryCode() == code) {
                return bookshelf[i];
            }
        } return null;
    }

    /**
    * This method returns the number of items on the shelf.
    * @return number of items on the shelf
     */
    public int getNumberOfItems() {
        return bookshelf.length;
    }

}