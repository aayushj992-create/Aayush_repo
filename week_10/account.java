package week_10;


/**
 * Write a description of class account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class account
{
    private int accountNo;
    private String holderName;
    private double balance;
    public account(int accountNo,String holderName,double balance){
        this.accountNo=accountNo;
        this.holderName=holderName;
        this.balance=balance;
    }
    public void setaccountNo(int accountNo)
    {
        this.accountNo=accountNo;
    }
    public int getaccountNo()
    {
        return this.accountNo;
    }
    public void setholderName(String holderName)
    {
        this.holderName=holderName;
    }
    public String getholderName()
    {
        return this.holderName;
    }
    public void setbalance(double balance)
    {
        this.balance=balance;
    }
    public double getbalance()
    {
        return this.balance;
    }
    public double calculateInterest(){
        return 0.7;
    }
    @Override
    public String toString(){
        return "AccountId="+this.accountNo+",\nName="+this.holderName;
    }
}