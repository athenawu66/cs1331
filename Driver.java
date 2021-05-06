import java.io.FileNotFoundException; 
public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Restaurant r = new Restaurant("Chick-fil-A", 33.1, -84.1);
		// for (int i = 0; i<r.getMenu().length; i++){
		// 	System.out.println(r.getMenu()[i]);
		// }
		Customer c = new Customer("hi", 0.0, 0.0);
		c.order(r, "Sandwich,$4.99\nFries,$1.99\nBurgers,$5.99");
		c.order(r, "Sandwich,$4.99\nFries,$1.99\nBurgers,$5.99");
		for (Food f : c.getOrder()) {
			System.out.println(f);
		}
		r.printReceipt(c, false);
	}
	
}