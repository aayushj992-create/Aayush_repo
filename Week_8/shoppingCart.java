package Week_8;


/**
 * Write a description of class shoppingClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class shoppingCart
{
    private String itemName;
    private double itemPrice;
    private int quantity; 
    public shoppingCart(String itemName,double itemPrice,int quantity){
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.quantity=quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public double calculateTotal()
    {
        return this.itemPrice;
    }
    public double calculateDiscountTotal(double discountPercent)
    {
        this.itemPrice=this.itemPrice-(discountPercent*this.itemPrice);
        return this.itemPrice;
    }
    public void displayCart()
    {
        System.out.println(itemName);
        System.out.println(this.itemPrice);
        System.out.println(quantity);
    }
}