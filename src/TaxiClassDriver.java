import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaxiClassDriver {
    public static void main(String[] args) {

        System.out.println( "Instantiation of subclasses object:\n");
        ArrayList<String> myFoodList = new ArrayList<>();
        ArrayList<String> myGroceryList = new ArrayList<>(30);

        // Code Part B Task 9 ( first 3 dot points) here
        TaxiFood myTaxiFood = new TaxiFood("Fried rice",myFoodList,0, "Van", "BHA999", 4, true);
        TaxiMart myTaxiMart = new TaxiMart(471, 300.0, "SUV", "WMA000", 6, true);

        //Adding food to TaxiFood
        myTaxiFood.addFoodOrder("Burgers", 10.60);
        myTaxiFood.addFoodOrder("Rice", 12.80);
        myTaxiFood.addFoodOrder("Carrots", 3.60);
        myTaxiFood.addFoodOrder("Green Beans", 4.10);
        myTaxiFood.addFoodOrder("Coffee", 5.00);

        //Adding food to TaxiMart
        myTaxiMart.addGroceriesItem("Pies", 6.20);
        myTaxiMart.addGroceriesItem("Chocolate", 3.50);
        myTaxiMart.addGroceriesItem("Milk", 3.10);
        myTaxiMart.addGroceriesItem("Tea", 4.00);

        //Printing objects to console.
        System.out.println(myTaxiMart);
        System.out.println();
        System.out.println(myTaxiFood);

        System.out.println( "\nTaxi delivery processed polymorphically:\n" );

        Taxi[] taxis = new Taxi[2];
        taxis[0] = myTaxiFood;
        taxis[1] = myTaxiMart;

        for (Taxi currentTaxi : taxis){
            System.out.println(currentTaxi.sendDelivery() + "\n");
        }
    }
}
