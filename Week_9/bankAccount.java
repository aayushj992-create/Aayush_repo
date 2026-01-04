package Week_9;


/**
 * Write a description of class bankAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bankAccount
{
    int accountNumber;
    String accountholderName;
    double balance;
    public bankAccount(int accountNumber,String accountholderName,double balance){
        this.accountNumber=accountNumber;
        this.accountholderName=accountholderName;
        this.balance=balance;
    }
     void displayInfo(){
            System.out.println("The account number is:"+accountNumber);
            System.out.println("The accountholderName is:"+accountholderName);
            System.out.println("The balance is:"+balance);
        }
    void deposit(double amount){
        double balance=this.balance;
            this.balance=balance+amount;
            System.out.println("The total balance before deposit is:"+balance);
        }
       
    double getBalance(){
        System.out.println("The total balance after deposite is:"+balance);
       return this.balance;
        }
}
