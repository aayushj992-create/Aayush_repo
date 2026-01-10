package week_10;

/**
 * Write a description of class order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class order
{
    private int orderId;
    private String customerName;
    private double amount;
    public order(int orderId,String customerName,double amount){
        this.orderId=orderId;
        this.customerName=customerName;
        this.amount=amount;
    }
    public void setorderId(int orderId)
    {
        this.orderId=orderId;
    }
    public int getorderId()
    {
        return this.orderId;
    }
    public void setcustomerName(String customerName)
    {
        this.customerName=customerName;
    }
    public String gecustomerName()
    {
        return this.customerName;
    }
    public void setamount(double amount)
    {
        this.amount=amount;
    }
    public double getamount()
    {
        return this.amount;
    }
    public double calculateFinalAmount(){
        return amount;
    }
    @Override
    public String toString(){
        return "ID------>"+this.orderId+"\n"+"Name------>"+this.customerName+"\n";
    }
}