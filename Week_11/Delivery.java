package Week_11;


/**
 * Write a description of class Deliver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Delivery 
{
    private int orderId;
    private double distanceInKm;
    private String pickupLocation;
    private String dropOffLocation;
    
    public Delivery(int id,double distance,String pickUp,String dropOff)
    {
        this.orderId=id;
        this.distanceInKm=distance;
        this.pickupLocation=pickUp;
        this.dropOffLocation=dropOff;
    }
    public double getDistance()
    {
        return this.distanceInKm;
    }
    
    public abstract double calculateCharge();
    public abstract double estimateTime();
}