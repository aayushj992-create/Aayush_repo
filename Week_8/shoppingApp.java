package Week_8;


/**
 * Write a description of class shoppingApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class shoppingApp
{
    public static void main(String[] args)
    {
        shoppingCart c1=new shoppingCart("Car",500,1);
        c1.getQuantity();
        c1.calculateDiscountTotal(0.5);
        c1.displayCart();
    }
}