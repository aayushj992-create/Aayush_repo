package week_26;


/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q2
{
    public static int factorial(int n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args)
    {
        System.out.println(factorial(5));        
    }
}