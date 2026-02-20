package Week_16;
import java.util.*;


/**
 * Write a description of class q7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q7
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter phone number");
        String str1=scan.nextLine();
        Boolean regex=str1.matches("9[8,7]\\d{8}");
        if(regex==true)
        
    {
        System.out.println("yes");
    }
    else
    {
         System.out.println("no");
    }
    
        
    }
}