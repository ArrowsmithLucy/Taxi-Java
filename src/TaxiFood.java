import java.util.ArrayList;

public class TaxiFood extends Taxi{

    //Task 1: Instantiate variables
    private String foodName;
    private ArrayList<String> foodList;
    private double totalCost;

    //Task 2: Seven-argument constructor. Last four-arguments are reserved for Taxi super class
    public TaxiFood(String initFoodName, ArrayList<String> initFoodList, double initTotalCost, String initVehicle, String initRegoNumber, int initPassengerCap, boolean initStatus){
        super(initVehicle,initRegoNumber,initPassengerCap, initStatus);

        setFoodName(initFoodName);
        setFoodList(initFoodList);
        setTotalCost(initTotalCost);
    }

    //Task 3: Accessors
    public String getFoodName() { return foodName; }
    public ArrayList<String> getFoodList() { return foodList; }
    public double getTotalCost() { return totalCost; }

    //Task 4: Mutators
    public void setFoodName(String initFoodName){
        if (initFoodName != null) {
            foodName = initFoodName;
        }
    }

    public void setTotalCost(double initTotalCost){
        if (initTotalCost >= 0){
            totalCost = initTotalCost;
        }
    }

    public void setFoodList(ArrayList<String> initFoodList){
        if (initFoodList != null){
            foodList = initFoodList;
        }
    }

    //Task 5: Methods
    //addFoodOrder takes foodName and foodCost as parameters.
    //It checks if the foodName is non-null. If yes, foodName is added to foodList and accumulates the cost of items in list.
    //Returns true if arguments pass the conditions.
    public boolean addFoodOrder(String foodName, double foodCost){
        boolean retValue = false;
        if (foodName != null) {
            foodList.add(foodName);
            totalCost += foodCost;
            retValue = true;
        }
        return retValue;
    }

    //Task 6: Methods
    //Prints the foodList to the screen and prints the total cost of the items with added 20% delivery commission.
    public String deliverFood(){
        System.out.println("Delivered: " + foodList);

        double deliveryCommission = 0.20;
        totalCost += totalCost*deliveryCommission;

        return String.format("Delivery completed! and the total cost is $%.2f", totalCost);
    }

    public String sendDelivery(){
        return deliverFood();
    }

    //Task 7: String output
    public String toString(){
        return String.format("\n%s \n" +
                        "Food Name: %s \n" +
                        "Food List: %s \n" +
                        "Total Cost: $%.2f", super.toString(), getFoodName(), getFoodList(), getTotalCost());
    }

}
