import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*This class represents a customer that can order food at a restaurant
*@author Athena Wu
*@version 1.0
*/
public class Customer {
    private String name;
    private Location location;
    private Food[] orders;
    private Restaurant current;
    /**
    *Constructor that accepts a name and two doubles corresponding
    *to the customer's coordinates
    *@param name name of restaurant
    *@param x x-coordinate of the customer's location
    *@param y y-coordinate of the customer's location
    */
    public Customer(String name, double x, double y) {
        this.name = name;
        this.location = new Location(x, y);
    }
/**
*Method allows the customer to order food from a restaurant
*@param restaurant that the customer orders from
*@param food that the customer orders
*/
    public void order(Restaurant restaurant, String food) throws FileNotFoundException {
        if (food == (null) || restaurant == (null)) {
            return;
        }
        if (current == null) {
            current = restaurant;
        } else if (!current.equals(restaurant)) {
            System.out.println("You have an active order at " + current.getRestaurantName() + "!");
        }
        String[] splitLine = food.split("\n");
        if (orders == null) {
            orders = new Food[splitLine.length];
            int orderIndex = 0;
            for (int i = 0; i < splitLine.length; i++) {
                String[] newB = null;
                newB = splitLine[i].split(",");
                for (int a = 0; a < restaurant.getMenu().length; a++) {
                    String stored = newB[1].substring(1, newB[1].length());
                    if (restaurant.getMenu()[a].getFoodName().equals(newB[0].trim())
                        && restaurant.getMenu()[a].getPrice() == Double.parseDouble(stored.trim())) {
                        if (restaurant.getMenu()[a].getQuantity() == 0) {
                            throw new UnavailableException();
                        } else {
                            restaurant.getMenu()[a].setQuantity(restaurant.getMenu()[a].getQuantity() - 1);
                            orders[orderIndex] = restaurant.getMenu()[a];
                            orderIndex++;
                        }
                    }
                }
            }
            for (int b = orderIndex; b < orders.length; b++) {
                orders[orderIndex] = null;
            }
        } else {
            int orderIndex = 0;
            Food[] tempArray = new Food[orders.length + splitLine.length];
            for (int c = 0; c < orders.length; c++) {
                tempArray[c] = orders[c];
                orderIndex++;
            }
            for (int i = 0; i < splitLine.length; i++) {
                String[] newB = null;
                newB = splitLine[i].split(",");
                for (int a = 0; a < restaurant.getMenu().length; a++) {
                    String stored = newB[1].substring(1, newB[1].length());
                    if (restaurant.getMenu()[a].getFoodName().equals(newB[0].trim())
                        && restaurant.getMenu()[a].getPrice()
                        == Double.parseDouble(stored.trim())) {
                        if (restaurant.getMenu()[a].getQuantity() == 0) {
                            throw new UnavailableException();
                        } else {
                            restaurant.getMenu()[a].setQuantity(restaurant.getMenu()[a].getQuantity() - 1);
                            tempArray[orderIndex] = restaurant.getMenu()[a];
                            orderIndex++;
                        }
                    }
                }
            }
            orders = tempArray;
        }
    }
    /**
    *Method that recommends the restaurant that's closest to
    *the customer
    */
    public void recommendation() throws FileNotFoundException {
        String closestName = "";
        double closestDistance = -1;
        File fileIn = new File("restaurants.csv");
        Scanner fileScan = null;
        fileScan = new Scanner(fileIn);
        String line = null;
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            String[] menu = line.split(",");
            if (menu[0].equals("RESTAURANT")) {
                String restaurantName = menu[1];
                double currentX = Double.parseDouble(menu[2]);
                double currentY = Double.parseDouble(menu[3]);
                Location otherLocation = new Location(currentX, currentY);
                double distance = location.calcDistance(otherLocation);
                if (closestDistance == -1 || distance < closestDistance) {
                    closestDistance = distance;
                    closestName = restaurantName;
                }
            }
        }
        fileScan.close();
        System.out.println(closestName + "is recommended for you!");
    }
    /**
    *Method that gets the location of the customer
    *@return location of the customer
    */
    public Location getLocation() {
        return location;
    }
    /**
    *Method that gets the orders of the customer
    *@return orders of the customer
    */
    public Food[] getOrder() {
        return orders;
    }
    /**
    *Method that sets the orders of the customer
    *@param newOrder or the new set of orders of the customer
    */
    public void setOrder(Food[] newOrder) {
        orders = newOrder;
    }
    /**
    *Method that obtains the current restaurant that the customer is
    *ordering from
    *@return current restaurant that the customer is ordering from
    */
    public Restaurant getCurrent() {
        return current;
    }
    /**
    *Method that obtains the customer name
    *@return String of customer name
    */
    public String getCustomerName() {
        return name;
    }
}