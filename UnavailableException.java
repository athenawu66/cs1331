/**
*This class has its own Exception when a food is thrown out of stock.
*@author Athena Wu
*@version 1.0
*/
public class UnavailableException extends RuntimeException {
    /**
    * Takes in a String and calls the superclass's constructor
    * @param aString the string being passed in
    */
    public UnavailableException(String aString) {
        super(aString);
    }
    /**
    * A constructor that takes nothing in and just has the super call.
    */
    public UnavailableException() {
        super();
    }

}