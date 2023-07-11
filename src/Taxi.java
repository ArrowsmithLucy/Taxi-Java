import java.util.Objects;

public abstract class Taxi implements Delivery{

    //Part A task 1

    // instances variables (Part A Task 1)
    private String vehicle;
    private String regoNumber;
    private int passengerCapacity;
    private boolean availabilityStatus;

    //Non-Default constructor
    public Taxi(String initVehicle, String initRegoNumber, int initPassengerCapacity, boolean initAvailabilityStatus){
        setVehicle(initVehicle);
        setRegoNumber(initRegoNumber);
        setPassengerCapacity(initVehicle);
        setStatus(initAvailabilityStatus);
    }

    // getter | accessor
    public String getTaxiCategory(){
        return vehicle;
    }
    public String getRegoNumber(){
        return regoNumber;
    }
    public int getPassengerCapacity(){
        return passengerCapacity;
    }
    public boolean getStatus(){
        return availabilityStatus;
    }


    // setter | mutator
    //setVehicle checks if setPassengerCapacity is valid via the parameter 'vehicle' and sets capacity if true.
    //Returns the mutation success.
    public boolean setVehicle(String newVehicle){
        boolean success;
        boolean result = setPassengerCapacity(newVehicle);
        if(result){
            vehicle = newVehicle;
            setPassengerCapacity(newVehicle);
            success = true;
        }
        else{
            System.out.println("Mutation failed: invalid vehicle type");
            success = false;
        }
        return success;
    }

    //setPassengerCapacity checks if the parameter 'vehicle' is a valid input and sets capacity accordingly.
    //Returns the mutation success.
    public boolean setPassengerCapacity(String vehicle){
        boolean success;
        if(Objects.equals(vehicle, "Sedan")){
            passengerCapacity = 4;
            success = true;
        }
        else if(Objects.equals(vehicle, "SUV")){
            passengerCapacity = 6;
            success = true;
        }
        else if(Objects.equals(vehicle, "Van")){
            passengerCapacity = 8;
            success = true;
        } else{
            success = false;
        }
        return success;
    }


    //setRegoNumber checks if the string input is 6 characters
    public void setRegoNumber(String newRego){
            if(newRego.length() == 6) {
                regoNumber = newRego;
            }
    }

    //setStatus checks the vehicle's availability.
    public void setStatus(boolean newAvailability){
        if(newAvailability){
            availabilityStatus = true;
        }
        else{
            availabilityStatus = false;
        }
    }


    // other method
    public String toString(){
        String outString = "";

        outString += "Vehicle: " + vehicle;
        outString += "\nRegistration Number: " + regoNumber;
        outString += "\nPassenger Capacity: " + passengerCapacity;
        outString += "\nAvailability Status: " + availabilityStatus + "\n";

        return outString;
    }

    //abstract method
    public abstract String sendDelivery();

}
