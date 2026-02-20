package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q3
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first string");
        String str1=scan.nextLine();
        System.out.println(str1.charAt(8));
        System.out.println("Enter a word");
        String str2=scan.nextLine();
        if(str1.contains(str2))
        {
            int idx=str1.indexOf("a");
            System.out.println("Yes the word is found");
            System.out.println("The index is at :"+idx);
        }
        else
        {
            System.out.println("The word not found");
        }
        }
}