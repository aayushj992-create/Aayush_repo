package week_10;


/**
 * Write a description of class bankApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bankApp
{
    public static void main(String[] args){
        currentAccount c1=new currentAccount(1,"Ram",10000);
        System.out.println(c1);
        System.out.println("Final Balance"+c1.calculateInterest(4));
        savingAccount s1=new savingAccount(2,"Sita",15000);
        System.out.print(s1);
        System.out.println("\n Final Balance"+s1.calculateInterest());
    }
}