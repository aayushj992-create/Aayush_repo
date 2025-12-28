package Week_8;


/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car
{
   String color;
   int vehicleId;
   //constructor overloading
   public Car()
   {
       System.out.println("This is default constructor");
   }
   public Car(String color)
   {
       this.color=color;
   }
   public Car(int vehicleId)
   {
       this.vehicleId=vehicleId;
   }
   public Car(String color,int vehicleId)
   {
       this.color=color;
       this.vehicleId=vehicleId;
   }
   
}