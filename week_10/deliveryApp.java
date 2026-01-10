package week_10;


/**
 * Write a description of class deliveryApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class deliveryApp
{
   public static void main(String[] args)
   {
       deliveryPartner d1=new deliveryPartner(1,"Sanju",1000);
       System.out.println(d1);
       System.out.println(d1.calculatePayment());
       bikeDelivery b1=new bikeDelivery(2,"Sita",1000,10);
       System.out.println("Extra order"+b1.calculatePayment(3));
       System.out.println(b1);
       carDelivery c1= new carDelivery(3,"Ram",5000,8);
       System.out.println(c1);
       System.out.println(c1.calculatePayment());
   }
}