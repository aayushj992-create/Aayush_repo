package week_10;


/**
 * Write a description of class normalOrder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class normalOrder extends order
{
    public normalOrder(int orderId,String customerName,double amount){
        super(orderId,customerName,amount);
    }
    @Override 
    public double calculateFinalAmount(){
        double finalamount=super.calculateFinalAmount();
        return finalamount;
    }
    public double calculateFinalAmount(double discountAmount){
        double normalAmount=this.calculateFinalAmount();
        double discountedAmount=normalAmount-discountAmount;
        return discountedAmount;
    }
    @Override
    public String toString(){
        return super.toString()+"Amount:"+this.calculateFinalAmount();
    }
}