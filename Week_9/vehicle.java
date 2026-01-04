package Week_9;


/**
 * Write a description of class vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class vehicle
{
   private int vehicleId;
   private String brand;
   private double basePrice;
    public vehicle(int vehicleId,String brand,double basePrice){
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.basePrice=basePrice;
    }
    public void setvehicleId(){
        this.vehicleId=vehicleId;
    }
    public int getvehicleId(){
        return this.vehicleId;
    }
    public void setbrand(){
        this.brand=brand;
    }
    public String getbrand(){
        return this.brand;
    }
    public void setbasePrice(){
        this.basePrice=basePrice;
    }
    public double getbasePrice(){
        return this.basePrice;
    }
    void displayVehicleInfo(){
        System.out.println("The vehicle id is:"+vehicleId);
        System.out.println("The car brand is:"+brand);
        System.out.println("The basePrice is:"+basePrice);
    }
    public double calculateTax(){
        this.basePrice=this.basePrice+(this.basePrice*0.1);
        System.out.println(this.basePrice); 
        return this.basePrice;
    }
}