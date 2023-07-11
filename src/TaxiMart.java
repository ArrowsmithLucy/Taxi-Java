import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaxiMart extends Taxi{

    //Task 2: Instantiating variables
    private int bootSpace;
    private double grocerySize;
    private ArrayList<String> groceryList;
    private double totalCost;
    private final int groceryCapacity = 30;

    //Task 3: Six-argument constructor. Last four-arguments are reserved for Taxi super class.
    public TaxiMart(int initBootSpace, double initGrocerySize, String initVehicle, String initRegoNumber, int initPassengerCap, boolean initStatus){
        super(initVehicle,initRegoNumber,initPassengerCap, initStatus);

        setBootSpace(initBootSpace);
        setGrocerySize(initGrocerySize);
        groceryList = new ArrayList<>(groceryCapacity);
        totalCost = 0;
    }

    //Task 4: Getter/Accessor methods
    public int getBootSpace() { return bootSpace; };
    public double getGrocerySize() { return grocerySize; };
    public ArrayList<String> getGrocerList() { return groceryList; };
    public double getTotalCost() { return totalCost; };


    //Task5: Setter/Mutator methods
    public boolean setBootSpace(int bootSpace){
        boolean retValue = false;
        if (bootSpace >= 0 && bootSpace <= 1000){
            this.bootSpace = bootSpace;
            retValue = true;
        }
        return retValue;
    }

    public boolean setGrocerySize(double grocerySize) {
        boolean retVale = false;
        if (grocerySize >= 0 && grocerySize <= bootSpace){
            this.grocerySize = grocerySize;
            retVale = true;
        }
        return retVale;
    }


    //Task 6: Methods
    //addGroceriesItem takes itemName and itemCost as parameters.
    //It checks if the groceryList size is less than the maximum size available (groceryCapacity)
    //If yes, itemName is added to groceryList and accumulates the cost of items in list.
    //Returns true if the arguments pass the conditions.
    public boolean addGroceriesItem(String itemName, double itemCost){
        boolean retValue = false;
        if (itemName != null) {
            if (groceryList.size() <= groceryCapacity) {
                groceryList.add(itemName);
                totalCost += itemCost;
                retValue = true;
            }
        }
        return retValue;
    }

    //Task 7: Methods
    //Prints the groceryList to the screen and prints the total cost of the items with added 10% delivery commission.
    public String deliverGroceries(){
        System.out.println("Delivered: " + groceryList);

        final double deliveryCommission = 0.10;
        totalCost += totalCost* deliveryCommission;
        return String.format("Delivery completed! and the total cost is $%.2f", totalCost);
    }

    public String sendDelivery(){
        return deliverGroceries();
    }

    //Task 8: String output
    public String toString(){
        return String.format("%s \n" +
                        "Boot Space: %s litres \n" +
                        "Grocery Size: %s litres \n" +
                        "Grocery List: %s \n" +
                        "Total Cost: $%.2f", super.toString(), getBootSpace(), getGrocerySize(),
                        getGrocerList(), getTotalCost());
    }
}
