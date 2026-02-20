package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q1
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first string");
        String s1=scan.nextLine();
        System.out.println("Enter second string");
        String s2=scan.nextLine();
        String str=s1.concat(s2);
        System.out.println("The combined string is"+str);
        System.out.println("Enter third string");
        String s3=scan.nextLine();
        if(s3 .equals(str) )
        {
         System.out.println("Yes it is same");   
        }
        else
        {
            System.out.println("No");
        }
    }
}