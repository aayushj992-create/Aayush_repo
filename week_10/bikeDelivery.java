package week_10;


/**
 * Write a description of class bikeDeilvery here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bikeDelivery extends deliveryPartner
{
    private int orders;
    public bikeDelivery(int partnerId,String name,double basePay,int orders){
    super(partnerId,name,basePay);
    this.orders=orders;
}
public void setorders(int orders)
    {
        this.orders=orders;
    }
    public int getorders()
    {
        return this.orders;
    }
    @Override
    public double calculatePayment()
    {
        double basePay=super.calculatePayment();
        return basePay*orders;
    }
    public double calculatePayment(int extraOrders)
    {
        double basePay=super.calculatePayment();
        double extra=extraOrders*60;
        double Pay=basePay*orders+extra;
        return Pay;
    }
    public String toString(){
        return super.toString()+"Pay="+calculatePayment();
    }
}