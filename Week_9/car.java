package Week_9;


/**
 * Write a description of class car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class car extends vehicle
{
   int numberOfDoors;
   String fuelType;
   public car(int vehicleId,String brand,double basePrice,int numberOfDoors,String fuelType){
       super(vehicleId,brand,basePrice);
       this.numberOfDoors=numberOfDoors;
       this.fuelType=fuelType;
   }
   double calculateFinalPrice(){
       double tax=calculateTax();
       double Final=tax+(tax*0.05);
       System.out.println(Final);
       return Final;
   }
   public void displaycarInfo(){
       displayVehicleInfo();
       System.out.println("The number of doors are:"+numberOfDoors);
       System.out.println("The fuel type is:"+fuelType);
       System.out.println("The final price is including tax is:"+calculateFinalPrice());
       
   }
}