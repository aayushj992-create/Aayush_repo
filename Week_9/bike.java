package Week_9;


/**
 * Write a description of class bike here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bike extends vehicle
{
    int engineCapacity;
    public bike(int vehicleId,String brand,double basePrice,int engineCapacity){
        super(vehicleId,brand,basePrice);
        this.engineCapacity=engineCapacity;
    }
}