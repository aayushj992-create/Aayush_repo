package week_10;


/**
 * Write a description of class savingAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class savingAccount extends account
{
    public savingAccount(int accountNo,String holderName,double balance){
        super(accountNo,holderName,balance);
    }
    @Override
    public double calculateInterest(){
        double interestRate=super.calculateInterest();
        double Final=getbalance()+getbalance()*interestRate;
        return Final;
    }
    public double calculateInterest(double rate){
        double interestRate=this.calculateInterest();
        double Final=getbalance()*rate;
        double new_balance=getbalance()+Final;
        return new_balance;
    }
    @Override
    public String toString(){
        return super.toString()+"\n Balance"+calculateInterest();
    }
}