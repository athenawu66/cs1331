import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Customer{
    private String name;
    private Location location;
    private Food[] orders;
    private Restaurant current;
    public Customer(String name, double x, double y){
        this.name = name;
        this.location = new Location(x,y);
    }

    public void order(Restaurant restaurant, String food) throws FileNotFoundException{
        if (food == (null) || restaurant==(null)){
            return;
        }
        if (current == null){
            current = restaurant;
        } else if (!current.equals(restaurant)){
            System.out.println("You have an active order at " + current.getRestaurantName() + "!");
        }

        String[] splitLine = food.split("\n");
        //System.out.println("hiii");
        orders = new Food[splitLine.length];
        int order_index = 0;
        if (orders==null){
            for (int i =0; i<splitLine.length; i++){
            String[] newB = null;
            //System.out.println(splitLine[i] + "wow");
            newB = splitLine[i].split(",");
            //System.out.println(newB[0]+"h")
            for (int a = 0; a < restaurant.getMenu().length; a++){
                //System.out.println(restaurant.getMenu()[a].getFoodName());
                //System.out.println(newB[0].trim());
                String stored = newB[1].substring(1,newB[1].length());
                if (restaurant.getMenu()[a].getFoodName().equals(newB[0].trim()) && restaurant.getMenu()[a].getPrice() 
                == Double.parseDouble(stored.trim())){
                        if (restaurant.getMenu()[a].getQuantity() == 0){
                            throw new UnavailableException();
                        }else{
                            restaurant.getMenu()[a].setQuantity(restaurant.getMenu()[a].getQuantity()-1);
                            orders[order_index] = restaurant.getMenu()[a];
                            order_index++;
                        }
                }
    }}for (int b = order_index; b<orders.length; b++){
        orders[order_index] = null;
    }}else if (orders != null){
        Food[] tempArray = new Food[splitLine.length+orders.length];
        for (int c =0; c<orders.length; c++){
            tempArray[c] = orders[c];
            order_index++;
        }for (int i =0; i<splitLine.length; i++){
            String[] newB = null;
            //System.out.println(splitLine[i] + "wow");
            newB = splitLine[i].split(",");
            //System.out.println(newB[0]+"h")
            for (int a = 0; a < restaurant.getMenu().length; a++){
                //System.out.println(restaurant.getMenu()[a].getFoodName());
                //System.out.println(newB[0].trim());
                String stored = newB[1].substring(1,newB[1].length());
                if (restaurant.getMenu()[a].getFoodName().equals(newB[0].trim()) && restaurant.getMenu()[a].getPrice() 
                == Double.parseDouble(stored.trim())){
                        if (restaurant.getMenu()[a].getQuantity() == 0){
                            throw new UnavailableException();
                        }else{
                            restaurant.getMenu()[a].setQuantity(restaurant.getMenu()[a].getQuantity()-1);
                            orders[order_index] = restaurant.getMenu()[a];
                            order_index++;
                        }
                }
    }}for (int b = order_index; b<orders.length; b++){
        orders[order_index] = null;
    }
    }
    }
    public void recommendation() throws FileNotFoundException{
        String closestName = "";
        double closestDistance = -1;
        File fileIn = new File("restaurants.csv");
        Scanner fileScan = null;
        fileScan = new Scanner(fileIn);
        String line = null;
        while (fileScan.hasNextLine()){
            line = fileScan.nextLine();
            String[] menu = line.split(",");
            if (menu[0].equals("RESTAURANT")){
                String restaurantName = menu[1];
                double currentX = Double.parseDouble(menu[2]);
                double currentY = Double.parseDouble(menu[3]);
                Location otherLocation = new Location(currentX, currentY);
                double distance = location.calcDistance(otherLocation);
                if (closestDistance == -1 || distance < closestDistance){
                    closestDistance = distance;
                    closestName = restaurantName;
                } 
            }
        }
        fileScan.close();
        System.out.println(closestName + "is recommended for you!");
    }
    public Location getLocation(){
        return location;
    }

    public Food[] getOrder(){
        return orders;
    }

    public void setOrder(Food[] newOrder){
        orders=newOrder;
    }

    public Restaurant getCurrent(){
        return current;
    }

    public String getCustomerName(){
        return name;
    }

    
}