package Week_8;


/**
 * Write a description of class ElectricityBill here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ElectricityBill
{
    private String consumerName;
    private int unitsConsumed;
    public ElectricityBill(String consumerName,int unitsConsumed)
    {
        this.unitsConsumed=unitsConsumed;
        this.consumerName=consumerName;
    }
    public void setConsumed(int unitsConsumed)
    {
        this.unitsConsumed=unitsConsumed;
    }
    public int getConsumed()
    {
        System.out.println("Your consumed unit is"+this.unitsConsumed);
        return this.unitsConsumed;
    }
    public double calculateBill()
    {
        if(this.unitsConsumed==100){
        double consumed=this.unitsConsumed*5;
        System.out.println("Your total price is:"+consumed);
        return consumed;
        }
        else if(this.unitsConsumed>100){
        double consumed=this.unitsConsumed-100;
        double first=100*5;
        double pay=consumed*8;
        double total=first+pay;
        System.out.println("Your total price is:"+total);
        return consumed;
    }
        else
        {
        return this.unitsConsumed;
    }
}
}