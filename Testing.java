import java.io.FileNotFoundException;
public class Testing{
    public static void main(String args[]){
        try{
            Customer jess = new Customer ("Jess",33.1,-84.1);
            Location lo = new Location (33.1, -84.1);
            Restaurant c = new Restaurant ("Chick-fil-A", lo);
            System.out.println(c);
            System.out.println(c.getMenu());
            System.out.println("hi");
            //jess.order(c, "Sandwich,$4.99\nSalad,3.00");
            Restaurant place = new Restaurant("Chick-fil-A", 33.1, -84.1);
            //place.printReceipt(jess, true);
        }catch(FileNotFoundException a){
            System.out.print("L");
        }
    }
}