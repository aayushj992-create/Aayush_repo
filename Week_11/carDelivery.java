package Week_11;


/**
 * Write a description of class carDeliver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class carDelivery extends Delivery implements Notification
{
    private static final double per_km_charge=40;
    private static final double min_per_km=5;
    public carDelivery(int id,double distance,String pickUp,String dropOff)
    {
        super(id,distance,pickUp,dropOff);
    }
    @Override
    public double calculateCharge()
    {
       return super.getDistance()*per_km_charge;
    }
    @Override
    public double estimateTime()
    {
        return super.getDistance()*min_per_km;
    }
    @Override 
     public void notify(String message)
     {
         System.out.println(message);
     }
     
}