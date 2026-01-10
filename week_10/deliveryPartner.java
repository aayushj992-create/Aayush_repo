package week_10;


/**
 * Write a description of class deliveryPartner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class deliveryPartner
{
    private int partnerId;
    private String name;
    private double basePay;
    public deliveryPartner(int partnerId,String name,double basePay)
    {
    this.partnerId=partnerId;
    this.name=name;
    this.basePay=basePay;
    }
    public void setPartnerId(int partnerId)
    {
        this.partnerId=partnerId;
    }
    public int getPartnerId()
    {
        return this.partnerId;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setbasePay(double basePay)
    {
        this.basePay=basePay;
    }
    public double getbasePay()
    {
        return this.basePay;
    }
    public double calculatePayment()
    {
        return basePay;
    }
    @Override 
    public String toString(){
        return "Id=" + getPartnerId()+ ",Name=" +getName()+ ",BasePay=" +getbasePay();
    }
    }
