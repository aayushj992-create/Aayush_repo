package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q4
{
    public static void main(String[] args)
    {
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter a sentence:");
    String str1=scan.nextLine();
    System.out.println(str1.toUpperCase());
    System.out.println(str1.toLowerCase());
    StringBuilder title=new StringBuilder();
    String[] wordSplit=str1.split(" ");
    for(String x:wordSplit)
    {
        String upper=x.substring(0,1).toUpperCase();
        String lower=x.substring(1).toLowerCase();
        title=title.append(upper).append(lower).append(" ");
    }
    System.out.println(title);
    }
}