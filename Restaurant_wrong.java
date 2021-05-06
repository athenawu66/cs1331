//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Restaurant{
    private String name;
    private Location location;
    public static final double deliveryFee = 0.2;
    private Food[] menu;
    public Restaurant(String name, Location location) throws FileNotFoundException{
        this.name = name;
        this.location = location;
        File fileIn = new File("restaurants.csv");
        Scanner fileScan = null;
        fileScan = new Scanner(fileIn);
        String line = null;
        int count = 0;
        int newCount = 0;
        System.out.println("b");
        while (fileScan.hasNextLine()) {
            String[] tokens = null;
            line = fileScan.nextLine();
            tokens = line.split(",");
            if (tokens[0].trim().equals("RESTAURANT") && tokens[1].trim().equals(name)){
                double x = Double.parseDouble(tokens[2].trim());
                double y = Double.parseDouble(tokens[3].trim());
                if (x == location.getX() && y == location.getY()){
                    while (fileScan.hasNextLine()) {
                        String[] tokens2 = null;
                        String newline = fileScan.nextLine();
                        tokens2 = newline.split(",");
                        if (!(tokens2[0].equals("RESTAURANT"))) {
                            count++;
                            System.out.print("a");
                        }
                    }
                }
            }
        }
        if (count==0){
            throw new InvalidRestaurantException();
        }
        menu = new Food[count];
        System.out.println(menu+"hi");
        Scanner fileScan2 = null;
        fileScan2 = new Scanner(fileIn);
        while (fileScan2.hasNextLine()){
            String[] tokens = null;
            line = fileScan2.nextLine();
            tokens = line.split(",");
            if (tokens[0].trim().equals("RESTAURANT") && tokens[1].trim().equals(name)){
                double x = Double.parseDouble(tokens[2].trim());
                double y = Double.parseDouble(tokens[3].trim());
                if (x == location.getX() && y == location.getY()){
                    while (fileScan2.hasNextLine()){
                        String[] tokens2 = null;
                        line = fileScan2.nextLine();
                        tokens2 = line.split(",");
                        if (!(tokens2[0].equals("RESTAURANT"))){
                            int quant = Integer.parseInt(tokens2[1].trim());
                            double p = Double.parseDouble(tokens2[2].trim());
                            Food a = new Food(tokens2[0], quant, p);
                            menu[newCount] = a;
                            newCount++;
        }
        }}}}}

    public Restaurant (String name, double x, double y) throws FileNotFoundException {
        this(name,new Location(x,y));
    }

    public void printReceipt(Customer customer, boolean delivery) throws FileNotFoundException{
        String fileName = customer.getCustomerName()+ "_" + name;
        File fileOut = new File(fileName+".txt");
        double subtotal = 0;
        boolean trueOrFalse = true;
        if ((fileOut).exists()){
            fileName=fileName+"-";
        }
        File fileOut2 = new File(fileName+".txt");
        //save in the same directory
        PrintWriter filePrint = null;
        filePrint = new PrintWriter(fileOut2);
        if (name.equals(customer.getCurrent())){
            filePrint.println("Receipt");
            filePrint.println(name);
            filePrint.println(location.getX() + ", " + location.getY());
            for (int i = 0; i<customer.getOrder().length; i++){
                String foodName = (customer.getOrder())[i].getFoodName();
                double price = (customer.getOrder()[i]).getPrice();
                filePrint.printf("%s, + $%.2f%n",foodName, price);
                subtotal+=price;
            }
            if (delivery){
                double newdeliveryFee = deliveryFee * location.calcDistance(customer.getLocation());
                filePrint.printf("Subtotal: $%.2f%n",subtotal);
                filePrint.printf("Delivery: $%.2f%n", newdeliveryFee);
                filePrint.printf("Total: $%.2f%n", (subtotal + newdeliveryFee));
                filePrint.printf("Thank you for dining with us!");
            } else{
                filePrint.printf("Total: $%.2f%n",(subtotal));
                filePrint.println("Thank you for dining with us!");
            }
            customer.setOrder(null);
            if (filePrint != null){
                filePrint.close();
            }
        }
    }


    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location newLocation){
        location = newLocation;
    }

    public Food[] getMenu(){
        return menu;
    }
}