package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q6
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String str1=scan.nextLine();
        StringBuilder rev=new StringBuilder();
        for(int i=str1.length()-1;i>=0;i--)
        {
            rev=rev.append(str1.charAt(i));
        }
        System.out.println(rev);
        String reverse=rev.toString();
        if(str1.equals(reverse))
        {
            System.out.println("Yes it is a palindrome");
        }
        else
        {
            System.out.println("No it is not a palindrome");
        }
    }
}