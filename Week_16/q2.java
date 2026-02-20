package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q2
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first string");
        String str1=scan.nextLine();
        System.out.println("Before:"+str1);
        String trimSpaces=str1.trim();
        System.out.println("After:"+trimSpaces);
        
        //sub string certain index sama
        System.out.println(str1.substring(0,10));
        
        //split-for each and array for the variable
        
        String[] wordSplit=str1.split(" ");
        for(String value:wordSplit)
        {
        System.out.println(value);
    }
    }
}