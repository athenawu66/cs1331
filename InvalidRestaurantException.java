/**
*This class has its own Exception which is thrown when there's no restaurant
*in restaurants.csv with the specified name and location.
*@author Athena Wu
*@version 1.0
*/

public class InvalidRestaurantException extends RuntimeException {
    /**
    *Takes in a String and calls the superclass's constructor passing in the
    *String.
    *@param aString string being passed in
    */
    public InvalidRestaurantException(String aString) {
        super(aString);
    }
    /**
    *Takes in nothing and calls the super method to the super constructor
    */
    public InvalidRestaurantException() {
        super("There is no restaurant with that name and location!");
    }
}
