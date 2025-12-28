package Week_8;


/**
 * Write a description of class bankAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bankAccount
{
   private int accountNumber;
   private double balance;
   String name;
   public bankAccount(int number,double balance,String name)
   {
       this.accountNumber=number;
       this.balance=balance;
       this.name=name;
   }
   public void setBalance(double balance)
   {
       this.balance=balance;
   }
   public double getBalance()
   {
   return this.balance;
    }
    public void deposit(double amount)
    {
        this.balance+=amount;
        System.out.println(this.balance);
    }
    public boolean withdraw(double amount)
    {
        if(this.balance>amount)
        {
            this.balance=this.balance-amount;
            System.out.println("The total balance is:"+this.balance);
            return true;
            
        }
        else
        {
            System.out.println("The total balance is:"+this.balance);
           return false;  
        }
    }
}   
