package week_10;


/**
 * Write a description of class currentAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class currentAccount extends account
{
    public currentAccount(int accountNo,String holderName,double balance){
        super(accountNo,holderName,balance);
    }
    @Override
    public double calculateInterest(){
        double interestRate=super.calculateInterest();
        double Final=getbalance()+getbalance()*interestRate;
        return Final;
    }
    public double calculateInterest(double rate){
        double interestRate=super.calculateInterest();
        double Final=getbalance()*rate+getbalance();
        double new_balance=getbalance()+Final;
        return new_balance;
    }
    @Override
    public String toString(){
        return super.toString()+"\n Balance"+calculateInterest();
    }
}