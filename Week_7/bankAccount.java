package Week_7;
import java.util.Scanner;


/**
 * Write a description of class bankAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bankAccount
{
  int accountNumber;
  String holderName;
  double balance;
  public bankAccount(int number,String name,double amount)
  {
      this.accountNumber=number;
      this.holderName=name;
      this.balance=amount;
  }
  Scanner scan=new Scanner(System.in);
  void deposit()
  {
        System.out.println("If you want to deposit money type Y");
        char a='Y';
        char b=scan.next().charAt(0);
        if(b==a)
        {
        System.out.println("Enter amount you want to deposit");
        double deposit=scan.nextDouble();
        double total_Balance=balance+deposit;
        System.out.println("Your Account Number is:"+accountNumber);
        System.out.println("Your Name is:"+holderName);
        System.out.println("Your Previous balance was:"+balance);
        System.out.println("Your Total Balance is:"+total_Balance);
    }
        else if(b!=a)
        {
        System.out.println("Your Account Number is:"+accountNumber);
        System.out.println("Your Name is:"+holderName);
        System.out.println("Your balance is:"+balance);        
        }
    }
         void withdraw()
         {
        System.out.println("If you want to withdraw money type Y");
        char c='Y';
        char d=scan.next().charAt(0);
        if(c==d)
        {
        System.out.println("Enter amount you want to withdraw");
        double withdraw=scan.nextDouble();
        double total_Balance=balance-withdraw;
        System.out.println("Your Account Number is:"+accountNumber);
        System.out.println("Your Name is:"+holderName);
        System.out.println("Your Previous balance was:"+balance);
        System.out.println("Your Total Balance is:"+total_Balance);
    }
        else if(c!=d)
        {
        System.out.println("Your Account Number is:"+accountNumber);
        System.out.println("Your Name is:"+holderName);
        System.out.println("Your balance is:"+balance);        
        }
}
}



