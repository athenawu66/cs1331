/**
* This class creates a library item.
* @author Athena Wu
* @version 1.0
 */
public abstract class LibraryItem implements Summarizable, Comparable<LibraryItem> {
    private String title;
    private int libraryCode;

    /**
    * Constructs a library item, taking in a title and library code
    * @param title title of the item
    * @param libraryCode represents a code given to the item and will be used to compare and sort
    * items
     */

    public LibraryItem(String title, int libraryCode) {
        this.title = title;
        this.libraryCode = libraryCode;
    }

    /**
    * This method returns a string summary
    * @return a string summary
     */
    public String summarize() {
        return "This item is called " + title + ".";
    }

    /**
    * This method shows that LibraryItem is greater than another LibraryItem if its
    * libraryCode is less than the other one’s.
    * @param other another LibraryItem that we are comparing to based on its library code.
    * @return a positive or negative integer that determines which library code is greater than the other.
     */
    @Override
    public int compareTo(LibraryItem other) {
        return -(libraryCode - other.libraryCode);
    }

    /**
    * This method returns the title of the library item
    * @return title of the library item
     */
    public String getTitle() {
        return this.title;
    }

    /**
    * This method returns the library code of the library item.
    * @return the library code of the library item.
     */
    public int getLibraryCode() {
        return this.libraryCode;
    }
}