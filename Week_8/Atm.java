package Week_8;


/**
 * Write a description of class Bank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Atm
{
    public static void main(String[] args)
    {
        bankAccount a1=new bankAccount(910020,99999,"Ram");
        a1.getBalance();
        a1.deposit(1000);
        a1.withdraw(5792);
    }
}