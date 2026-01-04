package Week_9;


/**
 * Write a description of class currentAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class currentAccount extends bankAccount
{ 
   double overdraftLimit;
  public currentAccount(int accountNumber,String accountholderName,double balance,double overdraftLimit){
      super(accountNumber,accountholderName,balance);
      this.overdraftLimit=overdraftLimit;
  }
  boolean withdraw(double amount){
      if(amount<=balance+overdraftLimit)
      {
            double Final=balance-amount;
            System.out.println("Your total balance after withdrawal is:"+Final);
         return true; 
      }
      else 
      {
          System.out.println("Your balance is"+balance);
          return true;
      }  
  }
}