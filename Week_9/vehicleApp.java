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
       car c1=new car(1,"URUS",99999,4,"Disel");
       bike b1=new bike(12,"Splendor",25000,500);
       c1.displaycarInfo();
   }
}