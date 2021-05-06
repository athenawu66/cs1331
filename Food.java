/**
*This class represents food at a restaurant that the customer could
*be ordering.
*@author Athena Wu
*@version 1.0
*/
public class Food {
    private String name;
    private int quantity;
    private double price;
    /**
    *Creates a food object
    *@param name name of the food
    *@param quantity the quantity of the number of food
    *@param price the price of the food
    */
    public Food(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    /**
    *Method that that returns a String
    *@return String explaining Food
    */
    public String toString() {
        return name + " costs $" + price + ", and there are " + quantity + " remaining.";
    }
    /**
    *Method that retrieves quantity
    *@return quantity
    */
    public int getQuantity() {
        return quantity;
    }
    /**
    *Method that sets quantity to a new value
    *@param newQuantity new quantity for the value to
    *be set
    */
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }
    /**
    *Method that obtains the name
    *@return name of the food
    */
    public String getFoodName() {
        return name;
    }
    /**
    *Method that obtains the price
    *@return price of the food
    */
    public double getPrice() {
        return price;
    }
}