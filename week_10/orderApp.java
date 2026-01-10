package week_10;


/**
 * Write a description of class orderApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class orderApp
{
    public static void main(String[] args){
        normalOrder n1=new normalOrder(1,"Ram",19999);
        System.out.println(n1);
        System.out.println("Final Amount:"+n1.calculateFinalAmount(1000));
        premiumOrder p1=new premiumOrder(2,"Sita",75000);
        System.out.println(p1);
        System.out.println("Final Amount:"+p1.calculateFinalAmount(1000));;
        
    }
}