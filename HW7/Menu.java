//---------------------------------------------------
// Purpose: Implementation of Menu class
// Author:	Dr. Streeter
// Date:	Spring 2024
//---------------------------------------------------
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu 
{
	// Private variable - dynamically sized ArrayList
	private ArrayList<Food> menu;

	// Constructor
	public Menu()
	{
		menu = new ArrayList<Food>();
	}

	// Add food item to menu
	public void addFood(Food food)
	{
		menu.add(food);
	}

	// Order food item and get price
	public double orderFood(int itemNum)
	{
		//valid item number chosen
		if ((itemNum > 0) && (itemNum <= menu.size()))
		{
			System.out.printf("\tOrdering: %s for $%3.2f\n", menu.get(itemNum-1).getName(), menu.get(itemNum-1).getPrice());
			return menu.get(itemNum-1).getPrice();
		}
		else
			return 0;
	}

	// Print all items on menu
	public void printMenu()
	{
		System.out.println("\t\t+-----------------------+");
		System.out.println("\t\t| Taco Restaurant Menu	|");
		System.out.println("\t\t+-----------------------+");
		for (int index = 0; index < menu.size(); index++)
		{
		   System.out.print("Item: " + (index+1) + ") ");
		   menu.get(index).print();
		   System.out.println();
		}
	}
	
	// Main program
	public static void main(String[] args) 
	{
		// Create and print menu
		Menu menu = new Menu();
		menu.addFood( new Food("Signature Taco", "Deliciousness wrapped in a warm tortilla for an explosion of flavor in every bite", 6.99, "Main Course") );
		menu.addFood( new Food("Crunchy Fish Taco", "Lime marinated cod with spicy cabbage slaw", 7.99, "Main Course") );
		menu.addFood( new Food("Spicy Shrimp Taco", "Grilled shrimp, fiery salsa, and cool avocado in a warm tortilla", 8.99, "Main Course") );
		menu.addFood( new Appetiezer("Wonton cup", "Shrimp with some chicken.", 10.99, "Appetiezer"));
		menu.addFood( new Appetiezer("Fire Beans", "Very Very spicy beans", 15.99, "Appetiezer"));
		menu.addFood( new Appetiezer("House Salad Special", "A salad that is a in house special", 20.99, "Appetiezer"));
		menu.addFood( new MainCourse("Grilled Chicken", "Nice slow smoked chicken", 25.99, "Main Course"));
		menu.addFood( new MainCourse("NY Strip", "A new York Strip that is nice", 35.99, "Main Course"));
		menu.addFood( new MainCourse("Shrimp and Lobster", "Shrimp with some lobster", 30.99, "Main Course"));
		menu.addFood( new Dessert("Cheese Cake", "Just a cake made of cheese", 13.99, "Dessert"));
		menu.addFood( new Dessert("House Cake", "Yummy in house cake", 10.99, "Dessert"));
		menu.addFood( new Dessert("Ice Cream", "Just very expensive froozen milk", 20.99, "Dessert"));
		menu.printMenu();

        menu.userInput();
		
	}
	
	public double getPrice(int index){
	    if (index >= 0 && index < menu.size()) {
	        Food item = menu.get(index);
	        return item.getPrice();
	    }
	    return -1;
	}
	
	public String getName(int index) {
	    if (index >= 0 && index < menu.size()) {
	        Food item = menu.get(index);
	        return item.getName();
	    }
	    
	    return "null";
	}
	
	public void userInput() {
	    List<Double> prices = new ArrayList<>();
	    
	    Scanner scan = new Scanner(System.in);
	    
	    while(true) {
	        System.out.println("What would you like to order? >> (enter -1 to exit)");
	        int input = scan.nextInt();
	        if (input >= 0 && input <= 12) {
	            System.out.printf("Ordering: %s - $%.2f\n", getName(input-1), getPrice(input-1));
                prices.add(getPrice(input-1));
	        }
	        if(input == -1) {
	            break;
	        } else {
	            continue;
	        }
	    }
	    
	    scan.close();
	    
	    printBill(prices);
	    
	}
	
	public void printBill(List<Double> prices) {
        double total = 0;
        double tax = 0;
        double taxedTotal = 0;
        
        for (double price : prices){
            total += price;
        }
        tax = total * (0.0975);
        
        taxedTotal = total + tax;
        
        System.out.println("Bill:");
        System.out.printf("Food Cost: %.2f\n", total);
        System.out.printf("Sales Tax: %.2f\n", tax);
        System.out.printf("Total Cost: %.2f\n", taxedTotal);
	}
}