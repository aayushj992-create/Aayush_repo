package Week_11;


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
        //actual run time 
        Notification delivery1=new carDelivery(1001,10,"Chabahil","Thankot");
        delivery1.notify("Your order has been placed");//dynamic method dispatch
    }
}