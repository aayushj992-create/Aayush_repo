import java.util.Scanner;

/**
 * Write a description of class Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1=scan.nextInt();
        System.out.println("The First number is:"+num1);
        System.out.println("Enter second number:");
        int num2=scan.nextInt();
        System.out.println("The second number is:"+num2);
    }
}