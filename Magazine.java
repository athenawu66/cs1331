/**
* This class creates and defines a magazine.
* @author Athena Wu
* @version 1.0
 */
public class Magazine extends LibraryItem {
    private String coverDescription;

    /**
    * Constructs a magazine object, taking in a title, libraryCode, and coverDescription.
    * @param title title of the magazine
    * @param libraryCode represents a code given to the magazine and will be used to compare and sort
    * items
    * @param coverDescription represents a short description of the magazine
     */
    public Magazine(String title, int libraryCode, String coverDescription) {
        super(title, libraryCode);
        this.coverDescription = coverDescription;
    }

    /**
    * This method returns a string summary
    * @return a string summary
     */
    public String summarize() {
        return super.summarize() + "This cover looks like " + coverDescription + ".";
    }
}