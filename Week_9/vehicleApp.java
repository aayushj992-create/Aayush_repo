package Week_9;


/**
 * Write a description of class vehicleApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class vehicleApp
{
   public static void main(String[] args){
       car c1=new car();
       c1.vehicleId(1);
       
       bike b1=new bike(12,"Splendor",25000,500);
       c1.displaycarInfo();
   }
}