package Week_9;


/**
 * Write a description of class savingsAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class savingsAccount extends bankAccount
{
    int interestRate;
    public savingsAccount(int accountNumber,String accountholderName,double balance,int interestRate){
        super(accountNumber,accountholderName,balance);
        this.interestRate=interestRate;
    }
    double calculateInterest(){
        double interest=balance*interestRate/100;
        System.out.println("The total interest value is:"+interest);
        return interest;
    }
}