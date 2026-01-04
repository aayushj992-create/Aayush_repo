package Week_9;


/**
 * Write a description of class bankApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bankApp
{
   public static void main(String[] args){
       savingsAccount s1= new savingsAccount(11,"Raju",65000,7);
       currentAccount c1= new currentAccount(21,"Geeta",85000,5);
       s1.deposit(5000);
       s1.getBalance();
       s1. calculateInterest();
       c1.withdraw(2000);
       
   }
}