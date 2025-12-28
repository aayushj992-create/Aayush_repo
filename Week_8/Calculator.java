package Week_8;


/**
 * Write a description of class Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    //Instance method --> void return type + no parameters
    public void displayInfo()
    {
        System.out.println("Welcome to calculator app.");
    }
    //void return type + parameters
    public void add(int a,int b)//formal parameters(why is formal parameters used)=actual representation of values a&b 
    {
        System.out.println("The sum of two numbers are:"+(a+b));
    }
    public void add(double a,double b)
    {
        System.out.println("The sum of two decimal numbers are:"+(a+b));
    }
    public void add(int a,int b,int c)
    {
        System.out.println("The sum of three  numbers are:"+(a+b+c));
    }
    public void add(double a,double b,double c)
    {
        System.out.println("The sum of three decimal numbers are:"+(a+b+c));
    }
    //return type+no parameters 
    public int getFixedNumber()
    {
    
      return 10;
    }
    //return type+ parameters
    public int multiply(int a,int b)
    {
        return a*b;
    }
    //static 
    public static int square(int a)
    {
        return a*a;
    }
    //default constructor Car().afai invoke garcha value
}