/**
*This class provides a specific corresponding location
*@author Athena Wu
*@version 1.0
*/
public class Location {
    private double x;
    private double y;
    /**
    *Constructs a Location object using two double values
    *@param x the x-coordinate of the location
    *@param y the y-coordinate of the location
    */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
    *Calculates the distance between two locations
    *@param location location of the other object who's distance
    *will be calculated
    *@return distance between two locations
    */
    public double calcDistance(Location location) {
        double diffX = location.getX() - x;
        double diffY = location.getY() - y;
        double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
        return distance;
    }
    /**
    *Method that gets the x-coordinate of the location
    *@return x-coordinate of the location
    */
    public double getX() {
        return x;
    }
    /**
    *Method that sets the x-coordinate of the location to
    *a new x-coordinate
    *@param newX new x-coordinate value
    */
    public void setX(double newX) {
        this.x = newX;
    }
    /**
    *Method that gets the y-coordinate of the location
    *@return y-coordinate of the location
    */
    public double getY() {
        return y;
    }
    /**
    *Method that sets the y-coordinate of the location
    *@param newY new y-coordinate
    */
    public void setY(double newY) {
        this.y = newY;
    }
}