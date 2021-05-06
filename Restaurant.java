//I worked on the homework assignment alone, using only course materials.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
*This class represents a restaurant that is able to print out a receipt
*for a specific customer.
*@author Athena Wu
*@version 1.0
*/
public class Restaurant {
    private String name;
    private Location location;
    public static final double DELIVERYFEE = 0.2;
    private Food[] menu;
    /**
    *A constructor that accepts a name and a location and sets the fields
    *accordingly.
    * @param name name of restaurant
    * @param location location of restaurant
    */
    public Restaurant(String name, Location location) throws FileNotFoundException {
        this.name = name;
        this.location = location;
        File fileIn = new File("restaurants.csv");
        Scanner fileScan = null;
        fileScan = new Scanner(fileIn);
        String line = null;
        int count = 0;
        int newCount = 0;
        //System.out.println("b");
        while (fileScan.hasNextLine()) {
            String[] tokens = null;
            line = fileScan.nextLine();
            tokens = line.split(",");
            if (tokens[0].trim().equals("RESTAURANT") && tokens[1].trim().equals(name)) {
                double x = Double.parseDouble(tokens[2].trim());
                double y = Double.parseDouble(tokens[3].trim());
                if (x == location.getX() && y == location.getY()) {
                    while (fileScan.hasNextLine()) {
                        String[] tokens2 = null;
                        String newline = fileScan.nextLine();
                        tokens2 = newline.split(",");
                        if (!(tokens2[0].equals("RESTAURANT"))) {
                            count++;
                            //System.out.print("a");
                        } else if (tokens2[0].equals("RESTAURANT")) {
                            break;
                        }
                    }
                }
            }
        }
        if (count == 0) {
            throw new InvalidRestaurantException();
        }
        menu = new Food[count];
        //System.out.println(menu+"hi");
        Scanner fileScan2 = null;
        fileScan2 = new Scanner(fileIn);
        while (fileScan2.hasNextLine()) {
            String[] tokens = null;
            line = fileScan2.nextLine();
            tokens = line.split(",");
            if (tokens[0].trim().equals("RESTAURANT") && tokens[1].trim().equals(name)) {
                double x = Double.parseDouble(tokens[2].trim());
                double y = Double.parseDouble(tokens[3].trim());
                if (x == location.getX() && y == location.getY()) {
                    while (fileScan2.hasNextLine()) {
                        String[] tokens2 = null;
                        line = fileScan2.nextLine();
                        tokens2 = line.split(",");
                        if (!(tokens2[0].equals("RESTAURANT"))) {
                            int quant = Integer.parseInt(tokens2[1].trim());
                            double p = Double.parseDouble(tokens2[2].trim());
                            Food a = new Food(tokens2[0], quant, p);
                            menu[newCount] = a;
                            newCount++;
                        } else if (tokens2[0].equals("RESTAURANT")) {
                            return;
                        }
                    }
                }
            }
        }
    }
    /**
    *Constructor that accepts a name and two doubles corresponding to the restaurant's
    *location
    *@param name name of the restaurant
    *@param x x-coordinate of the restaurant's location
    *@param y y-coordinate of the restaurant's location
    */
    public Restaurant(String name, double x, double y) throws FileNotFoundException {
        this(name, new Location(x, y));
    }
    /**
    *Method prints out the receipt based on the customer's food orders
    *@param customer customer ordering food
    *@param delivery true/false value of if there'll be delivery or not
    */
    public void printReceipt(Customer customer, boolean delivery) throws FileNotFoundException {
        String fileName = customer.getCustomerName() + "_" + name;
        File fileOut = new File(fileName + ".txt");
        double subtotal = 0.0;
        boolean trueOrFalse = true;
        if ((fileOut).exists()) {
            fileName = fileName + "-";
        }
        File fileOut2 = new File(fileName + ".txt");
        PrintWriter filePrint = null;
        filePrint = new PrintWriter(fileOut2);
        if (customer.getOrder() == null) {
            return;
        }
        if (customer.getCurrent().equals(this)) {
            filePrint.println("Receipt");
            filePrint.println(name);
            filePrint.println(location.getX() + ", " + location.getY());
            for (int i = 0; i < customer.getOrder().length; i++) {
                if ((customer.getOrder())[i] != null) {
                    String foodName = (customer.getOrder())[i].getFoodName();
                    double price = (customer.getOrder()[i].getPrice());
                    filePrint.printf("%s, + %.2f%n", foodName, price);
                    subtotal += price;
                }
            }
            if (delivery) {
                double newdeliveryFee = DELIVERYFEE * location.calcDistance(customer.getLocation());
                filePrint.printf("Subtotal: $%.2f%n", subtotal);
                filePrint.printf("Delivery: $%.2f%n", newdeliveryFee);
                filePrint.printf("Total: $%.2f%n", (subtotal + newdeliveryFee));
                filePrint.printf("Thank you for dining with us!");
            } else {
                filePrint.printf("Total: $%.2f%n", (subtotal));
                filePrint.println("Thank you for dining with us!");
            }
            customer.setOrder(null);
            if (filePrint != null) {
                filePrint.close();
            }
        }

    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Restaurant) {
            Restaurant r = (Restaurant) o;
            return r.name.equals(name) && r.location.equals(location);
        }
        return false;
    }
    /**
    *Method that gets the restaurant name
    *@return name of restaurant
    */
    public String getRestaurantName() {
        return name;
    }
    /**
    *Method that sets the name restaurant name to a new
    *new name
    *@param newName new name of the restaurant
    */
    public void setRestaurantName(String newName) {
        name = newName;
    }
    /**
    *Method that gets the location of the restaurant
    *@return location of the restaurant
    */
    public Location getLocation() {
        return location;
    }
    /**
    *Method that sets the location of the restaurant
    *@param newLocation new location of the restaurant
    */
    public void setLocation(Location newLocation) {
        location = newLocation;
    }
    /**
    *Method that gets the menu
    *@return menu of the restaurant
    */
    public Food[] getMenu() {
        return menu;
    }
}