package Week_8;


/**
 * Write a description of class Bill here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bill
{
    public static void main(String[] args)
    {
        ElectricityBill e1=new ElectricityBill("Ram",100);
        e1.getConsumed();
        e1.calculateBill();
    }
}